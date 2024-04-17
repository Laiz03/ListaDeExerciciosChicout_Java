package com.example;
import java.io.*;

//Arquivos Texto

public class App 
{
    public static void main( String[] args )
    {
        //1. Escreva um programa Java que crie um arquivo de texto chamado "meuarquivo.txt" e escreva a mensagem "Olá, mundo!" nele.

        BufferedWriter meuArquivo2;

        try {
            meuArquivo2 = new BufferedWriter(new FileWriter 
            ("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao1\\meuarquivo2.txt"));  //caminho e criação do arquivo

            String str = "Ola, Mundo!";

            meuArquivo2.write(str);

            meuArquivo2.close();

        } catch (Exception e) {
          // TODO: handle exception
        }    
    }
}
