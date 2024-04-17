package com.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
        // Adicione a funcionalidade de exclusão de produtos no programa da Questão 20. Permita que o usuário pesquise um produto pelo nome e, em seguida, exclua-o do arquivo CSV "produtos.csv". Certifique-se de atualizar o arquivo CSV após a exclusão.

        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar ao usuário o nome do produto que deseja excluir
            System.out.println("Digite o nome do produto que deseja excluir:");
            String nomeProduto = scanner.nextLine();

            // Excluir o produto do arquivo CSV
            excluirProdutoDoCSV(nomeProduto);

            System.out.println("Produto excluído do arquivo produtos.csv com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao excluir o produto: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void excluirProdutoDoCSV(String nomeProduto) throws IOException, CsvValidationException {
        String nomeArquivo = "produtos.csv";
        List<String[]> linhasAtualizadas = new ArrayList<>();

        // Lê todas as linhas do arquivo CSV e exclui o produto
        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;

            // Adiciona a primeira linha (cabeçalho) ao ArrayList de linhas atualizadas
            linhasAtualizadas.add(reader.readNext());

            // Lê cada linha do arquivo CSV
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];

                // Se encontrar o produto, não adiciona a linha ao ArrayList de linhas atualizadas (exclui o produto)
                if (!nome.equalsIgnoreCase(nomeProduto)) {
                    linhasAtualizadas.add(linha);
                }
            }
        }

        // Escreve as linhas atualizadas no arquivo CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            writer.writeAll(linhasAtualizadas);
        }
    }
}
