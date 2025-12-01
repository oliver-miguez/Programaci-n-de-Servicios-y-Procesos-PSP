import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class CalculadoraCliente extends JFrame implements ActionListener {

    // Componentes de la UI
    private final JTextField display; // Donde introducimos los números y donde se muestra la operación
    private final String[] botones = { // Botones de los numeros, referencia
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "C", "+"
    };

    private String operadorActual = null; // Almacena el operador principal seleccionado
    private StringBuilder numerosParaEnviar = new StringBuilder(); // Almacena el número principal de la operación

    private boolean despuesDeOperador = false; // Indica si el último clic fue un operador

    private static final String HOST = "localhost"; // Host del servidor
    private static final int PUERTO = 6666; // Puerto de conexión

    /**
     * Constructor de la UI
     */
    public CalculadoraCliente() {
        // Configuración básica de la ventana
        setTitle("Calculadora Cliente (Swing)"); // Título de la ventana

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Util para cerrar la ventana al presionar la "x" superior

        // Grid similar al utilizado en QT para colocar los elementos organizados
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Donde mostramos los números seleccionados y su resultado
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.BOLD, 36));

        // Configuración del Display en GridBagLayout
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Ocupa las 4 columnas
        gbc.insets = new Insets(10, 10, 10, 10);
        add(display, gbc);

        // Panel de Botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(4, 4, 10, 10)); // 4 filas, 4 columnas, espaciado

        for (String textoBoton : botones) {
            JButton boton = new JButton(textoBoton);
            boton.setFont(new Font("Arial", Font.BOLD, 20));
            boton.addActionListener(this);

            // Colorear el botón '=' de naranja
            if (textoBoton.matches("[/\\*\\-\\+]")) {
                boton.setBackground(new Color(150, 150, 150)); // Gris oscuro para operadores
                boton.setForeground(Color.WHITE);
            } else if (textoBoton.equals("C")) {
                boton.setBackground(new Color(200, 100, 100)); // Rojo para limpiar
            } else {
                boton.setBackground(new Color(50, 50, 50)); // Negro/Gris para números
                boton.setForeground(Color.WHITE);
            }
            boton.setOpaque(true);
            boton.setBorderPainted(false);
            panelBotones.add(boton);
        }

        // Configuración del Panel de Botones en GridBagLayout
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3; // Ocupa 3 columnas
        gbc.gridheight = 1;
        add(panelBotones, gbc);

        // 3. Botón de IGUAL (=) - Lado derecho y color naranja
        JButton botonIgual = new JButton("=");
        botonIgual.setFont(new Font("Arial", Font.BOLD, 30));
        botonIgual.setBackground(Color.ORANGE);
        botonIgual.setForeground(Color.WHITE);
        botonIgual.setOpaque(true);
        botonIgual.setBorderPainted(false);
        botonIgual.addActionListener(this);

        // Configuración del Botón '=' en GridBagLayout
        gbc.gridx = 3; // Columna 4 (índice 3)
        gbc.gridy = 1; // Fila de los botones
        gbc.gridwidth = 1; // Ocupa 1 columna
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH; // Rellena el espacio
        add(botonIgual, gbc);

        // Configuración final de la ventana
        pack();
        setSize(400, 500); // Tamaño fijo para parecer una calculadora
        setResizable(false);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    /**
     * Eventos botones
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("[0-9]|\\.")) {
            // --- Clic en Número o Punto ---
            if (display.getText().equals("0") || despuesDeOperador) {
                // Si es el primer dígito o después de un operador, reemplaza el '0'
                display.setText(comando);
            } else {
                // Concatena el dígito
                display.setText(display.getText() + comando);
            }
            // Añadimos el dígito al buffer de números (solo el número actual)
            if (numerosParaEnviar.length() == 0 || despuesDeOperador) {
                // Si es el primer número, o el inicio de un nuevo número (después de operador)
                numerosParaEnviar.append(comando);
            } else {
                // Concatenamos el dígito al número actual en el buffer
                numerosParaEnviar.append(comando);
            }
            despuesDeOperador = false;

        } else if (comando.matches("[/\\*\\-\\+]")) {
            // --- Clic en Operador (+, -, *, /) ---
            if (operadorActual == null && !display.getText().equals("0")) {
                // Es la primera operación: Guardamos el operador y separamos el número actual
                operadorActual = comando;
                // Agregamos un espacio para separar los siguientes números
                numerosParaEnviar.append(" ");
                despuesDeOperador = true;
                // Muestra la operación actual en pantalla
                display.setText(display.getText() + " " + operadorActual + " ");
            } else if (operadorActual != null && !despuesDeOperador) {
                // Si ya hay un operador y acabamos de teclear un número:
                // Lo que introduzca ahora será un nuevo número en la lista, no un nuevo operador.

                // Agregamos un espacio para el próximo número, y el operador para que se vea
                numerosParaEnviar.append(" ");
                despuesDeOperador = true;
                display.setText(display.getText() + " " + comando + " ");

            } else {
                // Si se pulsa un operador dos veces seguidas, ignorar el segundo
                display.setText("ERROR: Introduce un número.");
            }

        } else if (comando.equals("C")) {

            // --- Clic en Limpiar ---
            limpiar();

        } else if (comando.equals("=")) {
            // --- Clic en Igual ---
            if (operadorActual != null && numerosParaEnviar.length() > 0 && !despuesDeOperador) {
                // Enviamos la operación al servidor
                enviarAlServidor(operadorActual, numerosParaEnviar.toString());
            } else if (display.getText().equals("0") || operadorActual == null) {
                display.setText("0"); // No hay nada que calcular
            } else {
                display.setText("Error: Expresión incompleta.");
            }
        }
    }

    /**
     * Resetea el estado de la calculadora.
     */
    private void limpiar() {
        operadorActual = null;
        numerosParaEnviar.setLength(0);
        display.setText("0");
        despuesDeOperador = false;
    }

    /**
     * Método para manejar la comunicación con el servidor.
     * @param operador El operador principal a usar (+, -, *, /)
     * @param numeros La lista de números separados por espacio (e.g., "1 23 4")
     */
    private void enviarAlServidor(String operador, String numeros) {
        // Formato del mensaje: OPERADOR num1 num2 num3...
        String mensajeCompleto = operador + " " + numeros.trim();

        System.out.println("Enviando al servidor: " + mensajeCompleto);

        try (Socket socket = new Socket()) {
            InetSocketAddress dir = new InetSocketAddress(HOST, PUERTO);
            socket.connect(dir, 5000); // 5 segundos de timeout
            display.setText("Conectando... ");

            // 1. Enviar datos
            PrintWriter escritor = new PrintWriter(socket.getOutputStream(), true);
            escritor.println(mensajeCompleto);

            // 2. Recibir respuesta
            BufferedReader lector = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String resultadoRecibido = lector.readLine();

            // 3. Mostrar resultado y preparar para nueva operación
            display.setText(resultadoRecibido);

            // Prepara para una nueva operación usando el resultado como primer número
            operadorActual = null;
            numerosParaEnviar.setLength(0);
            numerosParaEnviar.append(resultadoRecibido);
            despuesDeOperador = false;

        } catch (UnknownHostException | SocketException e) {
            display.setText("Error de Conexión: " + e.getMessage());
            System.err.println("Error de Conexión: " + e.getMessage());
            limpiar();
        } catch (IOException e) {
            display.setText("Error I/O: " + e.getMessage());
            System.err.println("Error I/O: " + e.getMessage());
            limpiar();
        }
    }

    public static void main(String[] args) {
        // Asegura que la UI se ejecute en el hilo de Swing
        SwingUtilities.invokeLater(CalculadoraCliente::new);
    }
}