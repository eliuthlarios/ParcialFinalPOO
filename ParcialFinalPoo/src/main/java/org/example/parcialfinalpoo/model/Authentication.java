package org.example.parcialfinalpoo.model;

import java.io.InputStream;
import java.util.Scanner;

public class Authentication { //00103923 Declara la clase Authentication
    public static boolean authenticate(String user, String pass) { // 00103923 Declara el metodo estatico authentication con 2 parametros String que retorna un booleano
        boolean ans = false; //00103923 Inicializa la variable booleana ans como falsa
        InputStream inputStream = Authentication.class.getClassLoader().getResourceAsStream("org/example/parcialfinalpoo/cuentasEmp.txt"); //00103923 Obtiene el archivo de texto mediante la entrada de datos
        if (inputStream == null) { //00103923 Verifica si la entrada es nula
            System.out.println("No se encontró el archivo de cuentas."); //00103923 Escribe el mensaje si no se encontro el archivo
            return false; //00103923 Retorna falso si el archivo no se encuentra
        }
        try (Scanner sc = new Scanner(inputStream)) { //00103923 Intenta escanear el contenido de la entrada con un Scanner
            while (sc.hasNextLine()) { //00103923 Itera sobre cada linea del archivo
                String[] data = sc.nextLine().split(","); //00103923 Divide la line actual en un arreglo separandolo por medio de comas
                if (data[0].equals(user) && data[1].equals(pass)) { //00103923 Compara el usuario y la contraseña con la linea proporcionada
                    ans = true; //00103923 Si coinciden los valores, cambia el booleano ans a verdadero
                    break; //00103923 Si encuentran coincidencia cierra el bucle
                }
            }
            if (!ans) { //00103923 Verifica en caso no se hayan encontrado coincidencias
                System.out.println("Usuario o contraseña incorrectos."); //00103923 Imprime mensaje de error
            }
        } catch (Exception e) { //00103923 Captura cualquier excepcion en el proceso
            System.out.println("Ocurrió un error durante el proceso de inicio de sesión."); //00103923 Imprime mensaje de error
            e.printStackTrace(); //00103923 Muestra el seguimiento del error
        }

        return ans; //00103923 Retorna el valor booleano ans, verdadero en caso de que la autenticación tuvo exito y falso si fue erronea
    }
}
