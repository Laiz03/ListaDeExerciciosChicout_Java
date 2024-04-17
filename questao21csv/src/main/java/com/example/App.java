package com.example;

import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App 
{
    /**
     * @param args
     * @throws NumberFormatException 
     * @throws CsvValidationException 
     */
       public static void main( String[] args ) throws CsvValidationException, NumberFormatException
    {
        // Modifique o programa da Questão 20 para permitir que o usuário insira detalhes de produtos, como nome, preço e quantidade, e adicione esses produtos ao arquivo CSV "produtos.csv" usando a biblioteca OpenCSV.
  
        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar detalhes do produto ao usuário
            System.out.println("Digite o nome do produto:");
            String nome = scanner.nextLine();

            System.out.println("Digite o preço do produto:");
            double preco = Double.parseDouble(scanner.nextLine());

            System.out.println("Digite a quantidade do produto:");
            int quantidade = Integer.parseInt(scanner.nextLine());

            // Adicionar o produto ao arquivo CSV
            adicionarProdutoAoCSV(nome, preco, quantidade);

            System.out.println("Produto adicionado ao arquivo produtos.csv com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao adicionar o produto ao arquivo CSV: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void adicionarProdutoAoCSV(String nome, double preco, int quantidade) throws IOException {
        String nomeArquivo = "produtos.csv";

        // Cria um FileWriter e um CSVWriter para escrever no arquivo CSV
        FileWriter fileWriter = new FileWriter(nomeArquivo, true); // true para modo de adição (append)
        CSVWriter csvWriter = new CSVWriter(fileWriter);

        // Escreve os detalhes do produto no arquivo CSV
        csvWriter.writeNext(new String[]{nome, String.valueOf(preco), String.valueOf(quantidade)});

        // Fecha o CSVWriter e o FileWriter
        csvWriter.close();
        fileWriter.close();
    }
}
    

