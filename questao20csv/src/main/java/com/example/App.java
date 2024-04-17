package com.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class App 
{
   
    /**
     * @param args
     * @throws NumberFormatException 
     * @throws CsvValidationException 
     */
    public static void main( String[] args ) throws CsvValidationException, NumberFormatException
    {
        // Crie uma classe Java chamada `Produto` que represente um produto com campos como nome, preço e quantidade em estoque. Em seguida, escreva um programa que use a biblioteca OpenCSV para ler um arquivo CSV chamado "produtos.csv" que contém informações sobre produtos e armazenar esses dados em objetos da classe `Produto`. Exiba os detalhes dos produtos no console.

        String nomeArquivo = "produtos.csv";

        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            List<Produto> produtos = new ArrayList<>();
            String[] linha;

            // Pula a primeira linha, que contém os cabeçalhos
            reader.readNext();

            // Lê cada linha do arquivo CSV e cria objetos Produto
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);

                Produto produto = new Produto(nome, preco, quantidade);
                produtos.add(produto);
            }

            // Exibe os detalhes dos produtos no console
            for (Produto produto : produtos) {
                System.out.println(produto);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        }
    }
}