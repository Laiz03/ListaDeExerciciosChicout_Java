package com.example;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        //3. Modifique o programa anterior para adicionar a mensagem "Isso é uma adição!" ao final do arquivo "meuarquivo.txt" sem apagar o conteúdo existente.

        BufferedWriter meuArquivo2Questao3;

        try {
            meuArquivo2Questao3 = new BufferedWriter(new FileWriter 
            ("D:\\Atividades ADS\\DESENVOLVIMENTO DE SOFTWARE - CHICO\\LISTA DE EXERCICIOS - CHICO\\aulachico0804questao3\\meuArquivo2Questao3.txt"));  //caminho e criação do arquivo

            String str = "Ola, Mundo!";
            meuArquivo2Questao3.write(str);

            str = "Isso e uma adicao!";
            meuArquivo2Questao3.newLine();
            meuArquivo2Questao3.write(str);

            str = "Isso e Java, Java, Java, Java!";
            meuArquivo2Questao3.newLine();
            meuArquivo2Questao3.write(str);

            str = "Vou excluir esse projeto";
            meuArquivo2Questao3.newLine();
            meuArquivo2Questao3.write(str);

            str = "Isso é uma subtracao";
            meuArquivo2Questao3.newLine();
            meuArquivo2Questao3.write(str);

            str = "excluir excluir excluir";
            meuArquivo2Questao3.newLine();
            meuArquivo2Questao3.write(str);


            meuArquivo2Questao3.close();

        } catch (Exception e) {
          
        }    

    }
}
