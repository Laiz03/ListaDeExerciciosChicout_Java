package com.example;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App 
{
    public static void main( String[] args )
    {
        // Escreva um programa que leia os primeiros 100 bytes de um arquivo binário chamado "arquivo.bin" e os exiba no console.

        String Arquivo = "arquivo.bin";
        int numBytesParaLer = 100;

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(Arquivo))){
            byte[] buffer = new byte[numBytesParaLer ];
            int bytesRead = in.read(buffer, 0, numBytesParaLer);
            if (bytesRead != -1) {
                // Exibir os bytes como representação hexadecimal
                System.out.println("Os primeiros 100 bytes do arquivo " + Arquivo + ":");
                for (int i = 0; i < bytesRead; i++) {
                    System.out.print(buffer[i] + " ");
                }
                System.out.println();
            } else {
                System.out.println("Não foi possível ler o arquivo.");
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
