package com.example;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        //2. Crie um programa Java que leia o arquivo "meuarquivo.txt" criado na pergunta anterior e exiba seu conteúdo no console.

        BufferedReader meuArquivoDestino2;

        try {
            meuArquivoDestino2 = new BufferedReader(new FileReader
            ("C:\\Users\\laiz.oliveira\\Desktop\\aulachico0804\\meuarquivo2.txt"));
            String str;

            while((str = meuArquivoDestino2.readLine()) != null){
                System.out.println(str); //imprimindo o arquivo criado no console
            }

            meuArquivoDestino2.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
