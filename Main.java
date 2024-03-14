/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.data;

/**
 *
 * @author Ilerna 4.2.3
 */
import java.io.*;
import java.util.Locale;
import java.util.Scanner;
import java.io.File;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static Scanner scannerNum = new Scanner(System.in).useLocale(Locale.US);
    static String nombreCarpeta = "";
    public static void main(String[] args) {
        String nombreFichero = nombreCarpeta+"Main.java";
        String texto = "public static void main {\n" +
                "   public static void main(String[] args) {\n" +
                "       System.out.println(\"Hello world!\");\n" +
                "   }\n" +
                "}";
        Boolean editarFichero = false;
        try {
            FileWriter fichero = new FileWriter(nombreFichero, editarFichero);
            BufferedWriter escritura = new BufferedWriter(fichero);
            escritura.write(texto);
            escritura.close();
        } catch (IOException ex) { 
            throw new RuntimeException(ex);
        }
    }
    public static String leerCarpeta() {
        File carpeta = new File(nombreCarpeta);
        File[] listaDeArchivos = carpeta.listFiles();
        int numFile;
        if (listaDeArchivos != null) {
            for (int i = 0; i < listaDeArchivos.length; i++) {
                if (listaDeArchivos[i].isFile()) {
                    System.out.println((i + 1) + ". " + listaDeArchivos[i].getName());
                }
            }
        } else {
            System.out.println("El directorio está vacío o no existe.");
        }
        System.out.println("Elige un archivo: ");
        numFile = scannerNum.nextInt();
        return (nombreCarpeta + listaDeArchivos[numFile - 1].getName());
    }

}
