package com.example;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileWriter;
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
        // Desenvolva um programa que crie uma lista de objetos da classe `Venda`, onde cada objeto representa uma venda com informações como data, valor e produto vendido. Use a biblioteca OpenCSV para exportar essas vendas para um arquivo CSV chamado "vendas.csv".

        List<Venda> vendas = new ArrayList<>();
        vendas.add(new Venda("2024-04-15", 100.0, "Produto A"));
        vendas.add(new Venda("2024-04-16", 150.0, "Produto B"));
        vendas.add(new Venda("2024-04-17", 200.0, "Produto C"));

        // Exportar as vendas para o arquivo CSV
        exportarVendasParaCSV(vendas, "vendas.csv");

        System.out.println("Vendas exportadas para o arquivo vendas.csv com sucesso!");
    }

    private static void exportarVendasParaCSV(List<Venda> vendas, String nomeArquivo) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            // Escrever o cabeçalho do arquivo CSV
            writer.writeNext(new String[]{"Data", "Valor", "Produto Vendido"});

            // Escrever cada venda na lista no arquivo CSV
            for (Venda venda : vendas) {
                writer.writeNext(new String[]{venda.getData(), String.valueOf(venda.getValor()), venda.getProduto()});
            }
        } catch (IOException e) {
            System.err.println("Erro ao exportar as vendas para o arquivo CSV: " + e.getMessage());
        }
    }
}
