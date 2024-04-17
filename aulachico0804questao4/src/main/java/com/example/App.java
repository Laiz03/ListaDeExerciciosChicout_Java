package com.example;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        //4. Escreva um programa Java que conte quantas linhas existem no arquivo "meuarquivo.txt" e exiba esse número no console.

        BufferedReader meuarquivo2Questao4;
        int contadorLinhas = 0; 

        try {
            meuarquivo2Questao4 = new BufferedReader(new FileReader("C:\\Users\\laiz.oliveira\\Desktop\\aulachico0804questao3\\meuArquivo2Questao3.txt"));

            String str;

            while((str = meuarquivo2Questao4.readLine()) != null){
                contadorLinhas++;
            }

            System.out.println(contadorLinhas);

            meuarquivo2Questao4.close();

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
