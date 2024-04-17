package com.example;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        //6. Implemente um programa Java que leia um arquivo CSV chamado "dados.csv" (com valores separados por vírgula) e exiba cada linha no console, dividida em campos.

        BufferedReader arquivoCSV = null; 
        String csv;

        try {
            arquivoCSV = new BufferedReader(new FileReader("C:\\Users\\laiz.oliveira\\Desktop\\aulachicoquestao6\\dados.csv"));

            while((csv = arquivoCSV.readLine()) != null) {
                String[] csvL = csv.split(",");
                //System.out.println(csv);
                System.out.println("Campo 1: " + csvL[0]);
                System.out.println("Campo 2: " + csvL[1]);
                System.out.println("Campo 3: " + csvL[2]);
                System.out.println("");
            }

            arquivoCSV.close();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
