package org.example.parcialfinalpoo.model;

import java.io.InputStream;
import java.util.Scanner;

public class Authentication {
    public static boolean authenticate(String user, String pass) {
        boolean ans = false;
        InputStream inputStream = Authentication.class.getClassLoader().getResourceAsStream("org/example/parcialfinalpoo/cuentasEmp.txt");
        if (inputStream == null) {
            System.out.println("No se encontró el archivo de cuentas.");
            return false;
        }
        try (Scanner sc = new Scanner(inputStream)) {
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(",");
                if (data[0].equals(user) && data[1].equals(pass)) {
                    ans = true;
                    break;
                }
            }
            if (!ans) {
                System.out.println("Usuario o contraseña incorrectos.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error durante el proceso de inicio de sesión.");
            e.printStackTrace();
        }

        return ans;
    }
}
