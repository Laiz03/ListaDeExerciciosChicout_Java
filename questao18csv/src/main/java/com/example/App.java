package com.example;

import java.io.BufferedReader;
import java.io.FileReader;

public class App 
{
    public static void main( String[] args )
    {
        // Crie um programa Java que use a biblioteca OpenCSV para ler um arquivo CSV chamado "alunos.csv" e exibir o conteúdo no console. O arquivo CSV contém informações sobre alunos, como nome, idade e nota.

        BufferedReader Alunos = null;

        try {
            Alunos = new BufferedReader(new FileReader("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\questao18csv\\Alunos.csv"));
            String str;
            while ((str = Alunos.readLine()) != null) {
                String[] strL = str.split(","); //separa o arquivo cvs por virgula
                System.out.println(str);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
