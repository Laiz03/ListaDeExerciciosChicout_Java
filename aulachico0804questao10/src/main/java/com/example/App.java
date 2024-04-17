package com.example;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        //Escreva um programa Java que crie dois arquivos de texto ("arquivo1.txt" e "arquivo2.txt") com algum conteúdo. Em seguida, crie um terceiro arquivo chamado "arquivo_concatenado.txt" que contenha o conteúdo dos dois primeiros arquivos concatenados.


        File arquivo1 = new File ("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao10\\arquivo1.txt");
        File arquivo2 = new File ("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao10\\arquivo2.txt");
        File arquivo_concatenado = new File ("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao10\\arquivo_concatenado.txt");

        try {
            // Criar os arquivos e escrever algum conteúdo neles
            escreverArquivo(arquivo1, "Olá Mundo");
            escreverArquivo(arquivo2, "Tudo bem com vocês?");

            // Concatenar os conteúdos dos arquivos 1 e 2 em um terceiro arquivo
            concatenarArquivos(arquivo1, arquivo2, arquivo_concatenado);

            System.out.println("Arquivos concatenados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao manipular os arquivos");
        }
    }

    private static void escreverArquivo(File arquivo1, String conteudo) throws IOException {
        FileWriter writer = new FileWriter(arquivo1);
        writer.write(conteudo);
        writer.close();
    }

    private static void concatenarArquivos(File arquivo1, File arquivo2, File arquivo_concatenado) throws IOException {
        FileReader reader1 = new FileReader(arquivo1);
        FileReader reader2 = new FileReader(arquivo2);
        FileWriter writer = new FileWriter(arquivo_concatenado);

        int caractere;
        while ((caractere = reader1.read()) != -1) {
            writer.write(caractere);
        }
        while ((caractere = reader2.read()) != -1) {
            writer.write(caractere);
        }

        reader1.close();
        reader2.close();
        writer.close();
    }
}
