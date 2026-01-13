package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Crea una contraseña:");
        String contrasena = sc.next();

        String contrasena_registro = generadorHash(contrasena);

        System.out.println("Usuario Registrado. Inicie sesión: ");
        String contrasena_inicio_sesion = sc.next();

        String contrasena_inicio_hash = generadorHash(contrasena_inicio_sesion);

        comparacionHash(contrasena_registro,contrasena_inicio_hash);

    }

    public static String generadorHash(String dato){

        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(dato.getBytes());
            byte[] resumen = md.digest();

            String hex = HexFormat.of().formatHex(resumen);
            System.out.println(hex);
            return hex;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }



    public static void comparacionHash(String contrasena_creada, String contrasena_inicio_sesion){
        if (Objects.equals(contrasena_creada, contrasena_inicio_sesion)){
            System.out.println("ACCESO CONCEDIDO");
        }else{
            System.out.println("Credenciales inválidas");
        }
    }

}