package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class App 
{
    public static void main( String[] args )
    {
        // 15. Desenvolva um programa que copie um arquivo binário grande chamado "arquivo_grande.bin" para outro arquivo chamado "copia_arquivo_grande.bin" usando buffers para melhorar o desempenho.

        String arquivoOrigem = "arquivo_grande.bin";
        String arquivoDestino = "copia_arquivo_grande.bin";

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(arquivoOrigem));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(arquivoDestino))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            System.out.println("Arquivo copiado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao copiar arquivo: " + e.getMessage());
        }
    }
}
