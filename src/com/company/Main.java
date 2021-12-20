package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        List<String> lista = new ArrayList();
        int numLinea = 1;
        int lineasCorrectas = 0;
        int lineasIncorrectas = 0;

        try {
            File doc = new File("c:/Users/engac/OneDrive/Documents/archivoCSV.csv");

            Scanner obj = new Scanner(doc);

            while (obj.hasNextLine()) {

                String linea = obj.nextLine();
                String[]  partesLinea = linea.split(",");

                // mirar si el numero de campos de usuario es correcto

                if (partesLinea.length!=3) {
                    System.err.println("Incorrecto número de campos en la linea número: " + numLinea );
                }

                // nombre completo: miraré que tenga minimo 3 palabras

                StringTokenizer st = new StringTokenizer(partesLinea[1]);

                if (st.countTokens() <3) System.err.println("El nombre no está completo. Linea : " + numLinea);

                // comprobacion email correcto

                String emailPatron = "[^@]+@[^@]+\\.[a-zA-Z]{3,}";
                if (Pattern.matches(emailPatron,partesLinea[0])) lineasCorrectas++;

                else {
                    lineasIncorrectas++;
                    System.err.println("Número de linea mal formada:" + numLinea);
                }

                // mirar si el email actual del fichero  está ya en la lista

                if (lista.contains(linea))
                {
                    System.err.println("Repetida la linea: " + numLinea + " Correo: " + partesLinea[0]);





                }

                lista.add(linea);
                numLinea++;


            }
            System.out.println("Lineas correctas: " + lineasCorrectas);
            System.out.println("Lineas incorrectas: " + lineasIncorrectas);
            System.out.println(lista);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }


    }


}
