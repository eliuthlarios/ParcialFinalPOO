package org.example.parcialfinalpoo;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ReporteGenerador { //00029223 Se define esta clase con la finalidad de proporcionar una funcionalidad extra, sin instanciarla

    private ReporteGenerador() { //00029223 Constructor privado para evitar la instanciacion
    }

    public static void generarArchivoReporte(String tipoReporte, List<String> contenido) { //00029223 Metodo estatico para generar el archivo de reporte
        LocalDateTime fechaActual = LocalDateTime.now(); //00029223 Obtiene la fecha y hora actual
        DateTimeFormatter fechaFormateada = DateTimeFormatter.ofPattern("d-M-yy"); //00029223 Define el formato para la fecha
        DateTimeFormatter horaFormateada = DateTimeFormatter.ofPattern("h;mma"); //00029223 Define el formato para la hora
        String fechaActual1 = fechaActual.format(fechaFormateada); //00029223 Formatea la fecha actual segun el formato definido
        String horaActual1 = fechaActual.format(horaFormateada).toLowerCase(); //00029223 Formatea la hora actual y la convierte a minuscula

        try (FileWriter writer = new FileWriter("Reporte" + tipoReporte + "_" + fechaActual1 + "_" + horaActual1 + ".txt")) { //00029223 Crea un FileWriter para escribir en el archivo con el nombre generado
            writer.write("Reporte de transacciones por cliente en un rango de fechas, generado el " + fechaActual1 + " a las " + horaActual1 + "\n\n"); //00029223 Escribe la primera linea del reporte, el encabezado
            for (String linea : contenido) { //00029223 Itera sobre cada línea de la lista que se le pasa
                writer.write(linea + "\n"); //00029223 Escribe cada línea del contenido en el archivo y un salto de linea
            }
        } catch (IOException e) { //00029223 Captura la excepcion
            e.printStackTrace(); //00029223 Imprime la excepcion
        }
    }
}
