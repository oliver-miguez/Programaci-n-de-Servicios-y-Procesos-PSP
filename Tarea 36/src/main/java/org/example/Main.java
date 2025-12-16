package org.example;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

/**
 * Tu tarea consiste en crear en Java un Agente de Correo capaz de enviar y leer emails usando los protocolos SMTP e IMAP (O POP3 que es lo que permite mailtrap).
 * Debes desarrollar una aplicación que envíe un mensaje de notificación y luego lea la bandeja de entrada para mostrar los correos pendientes.
 *     El proyecto debe incluir la librería Jakarta Mail.
 *     Se recomienda usar Mailtrap.io para enviar y recibir correos sin riesgo, aunque también puedes usar otros servidores como Gmail u Outlook siempre que configures
 *     bien los puertos y la autenticación.
 * Envío (SMTP):
 *     Configura una sesión SMTP con las credenciales de tu servidor.
 *     Envía un correo con:
 *         Asunto: "Prueba de Agente - [Tu Nombre]"
 *         Cuerpo: "El sistema de notificaciones está activo."
 * Lectura (IMAP):
 *     En el mismo programa, conecta al servidor IMAP.
 *     Accede a la bandeja INBOX.
 *     Lee los mensajes y muestra por consola el remitente y el asunto de los correos más recientes.
 */
public class Main {
    public static void main(String[] args) {

        // Configuración necesaria
        Properties props = new Properties();
        props.put("mail.smtp.host","sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port","2525");

        // Autenticación
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");

        // Creación de la sesión
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("abb85e7fd9956d","54d66c712deeaa");
            }
        });

        // Crear y enviar mensaje
        try{
            // Crea el mensaje
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("testCorreo@XogosAqui.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("otroTestMas@Asi.es"));
            msg.setSubject("Prueba de agente");
            msg.setText("El sistema de notificaciones está activo.");

            // Enviar
            Transport.send(msg);
            System.out.println("Enviado. Revisa la bandeja de entrada");
        } catch (MessagingException e) {
            System.out.println("Error con el tema de enviar y crear mensaje: "+e.getMessage());
        }

        //Leer Correos
        try {
            //Configuración
            props.put("mail.pop3.host","pop3.mailtrap.io");
            props.put("mail.pop3.port","9950");
            props.put("mail.pop3.starttls.enable","true");

            // Conexión
            Store store = session.getStore("pop3");
            store.connect("abb85e7fd9956d","54d66c712deeaa");

            // Abrir inbox y leer
            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] mensajes = inbox.getMessages();
            for(Message m : mensajes){
                System.out.println("Asunto: "+ m.getSubject());
            }

        } catch (NoSuchProviderException e) {
            System.out.println("Error con el tema de la conexión: "+e.getMessage());
        } catch (MessagingException e) {
            System.out.println("Error con el tema de abrir y leer: "+e.getMessage());
        }


    }
}