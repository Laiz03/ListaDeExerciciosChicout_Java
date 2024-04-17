package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        //Crie um programa Java que leia o arquivo "meuarquivo.txt" e conte quantas vezes a palavra "Java" aparece no texto. Exiba o resultado no console.

        BufferedReader meuArquivoQuestao9;
        String str;
        boolean encontrou = false;
        int contador = 0;

        try {
            meuArquivoQuestao9 = new BufferedReader(new FileReader("D:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao3\\meuArquivo2Questao3.txt"));
            
            while ((str = meuArquivoQuestao9.readLine()) != null) {
                int indice = 0;
                while ((indice = str.indexOf("excluir", indice)) != -1) {
                    encontrou = true; 
                    contador++;
                    indice += "excluir".length();
                } 
            }
            
            if (encontrou) {
                System.out.println("A palavra foi encontrada " + contador + " vez(es)");
             } else {
                 System.out.println("Palavra não encontrada");
             }
            
            meuArquivoQuestao9.close();


        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo!");
        }
    }
}
