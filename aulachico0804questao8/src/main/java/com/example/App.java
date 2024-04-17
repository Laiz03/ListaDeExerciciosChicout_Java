package com.example;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        //Implemente um programa Java que leia o arquivo "meuarquivo.txt" e remova todas as linhas que contêm a palavra "excluir". Salve o resultado em um novo arquivo chamado "meuarquivo_sem_excluir.txt".

        //cria o caminho do arquivo
        File meuarquivoquestao8_sem_excluir = new File("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao8\\meuarquivoquestao8_sem_excluir.txt");

        //cria o arquivo
        try {
            meuarquivoquestao8_sem_excluir.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        BufferedReader meuarquivoQuestao8;
        BufferedWriter meuarquivoquestao8_sem_excluir2;
        String str;

        try {
            meuarquivoQuestao8 = new BufferedReader(new FileReader("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao3\\meuArquivo2Questao3.txt"));
            meuarquivoquestao8_sem_excluir2 = new BufferedWriter(new FileWriter("E:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao8\\meuarquivoquestao8_sem_excluir.txt"));

            while ((str = meuarquivoQuestao8.readLine()) != null) {
                System.out.println(str.contains("excluir"));
                if (!str.contains("excluir")) {  //!str.contains("excluir") retorna se a linha n contem a palavra excluir 
                    meuarquivoquestao8_sem_excluir2.write(str);
                    meuarquivoquestao8_sem_excluir2.newLine();
                }
            }

            meuarquivoquestao8_sem_excluir2.close();
            meuarquivoQuestao8.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
