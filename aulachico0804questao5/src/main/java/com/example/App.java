package com.example;
import java.io.*;

public class App 
{
    public static void main( String[] args )
    {
        //5. Crie um programa Java que leia o conteúdo do arquivo "meuarquivo.txt", substitua todas as ocorrências da palavra "Java" pela palavra "Python" e salve o resultado em um novo arquivo chamado "meuarquivo_python.txt".

        //cria o caminho do arquivo
        File meuArquivoDestino5_Python = new File("C:\\Users\\laiz.oliveira\\Desktop\\aulachicoquestao5\\meuArquivoDestino5_Python2.txt");

        //cria o arquivo
        try {
            meuArquivoDestino5_Python.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
        }

        BufferedReader meuArquivoQuestao5;
        BufferedWriter meuArquivoDestino5_Python2;

        try {
            meuArquivoQuestao5 = new BufferedReader(new FileReader("C:\\Users\\laiz.oliveira\\Desktop\\aulachico0804questao3\\meuArquivo2Questao3.txt"));
            meuArquivoDestino5_Python2 = new BufferedWriter(new FileWriter("C:\\Users\\laiz.oliveira\\Desktop\\aulachicoquestao5\\meuArquivoDestino5_Python2.txt"));

            String str;

            while ((str = meuArquivoQuestao5.readLine()) != null) {
                meuArquivoDestino5_Python2.newLine(); 
                System.out.println(str.replaceAll("Java", "Python"));
                meuArquivoDestino5_Python2.write(str.replaceAll("Java", "Python"));
            }

            meuArquivoDestino5_Python2.close();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
