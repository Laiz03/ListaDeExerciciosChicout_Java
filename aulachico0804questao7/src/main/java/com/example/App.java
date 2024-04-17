package com.example;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App 
{
    /**
     * @param args
     */
    public static void main( String[] args )
    {
        //7. Escreva um programa Java que leia o arquivo "meuarquivo.txt", ordene as linhas em ordem alfabética e salve o resultado em um novo arquivo chamado "meuarquivo_ordenado.txt".

        //cria o caminho do arquivo
        File meuarquivo_ordenado = new File("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao7\\meuArquivo2Questao3.txt");

        //cria o arquivo
        try {
            meuarquivo_ordenado.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
        }

        BufferedReader meuarquivoQuestao7;
        BufferedWriter meuarquivo_ordenado2;
        String str;

        // Lista para armazenar as palavras do arquivo
        List<String> palavra = new ArrayList<>();

        try {
            meuarquivoQuestao7 = new BufferedReader(new FileReader("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao3\\meuArquivo2Questao3.txt"));
            meuarquivo_ordenado2 = new BufferedWriter(new FileWriter("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao7\\meuArquivo2Questao3.txt"));

            while ((str = meuarquivoQuestao7.readLine()) != null) {
                // Separar as palavras utilizando expressão regular
                String[] separaPalavra = str.split("\\W+");
                // Adicionar as palavras na lista
                palavra.addAll(Arrays.asList(separaPalavra));
                //ordena 
                Collections.sort(palavra); 
            }

            for (String palavra1 : palavra) {
                meuarquivo_ordenado2.write(palavra1);
                meuarquivo_ordenado2.newLine(); 
            }

            meuarquivoQuestao7.close();
            meuarquivo_ordenado2.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
