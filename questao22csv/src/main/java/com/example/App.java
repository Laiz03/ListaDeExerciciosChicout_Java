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
        // Aprimore o programa da Questão 20 para permitir que o usuário atualize informações de produtos existentes no arquivo "produtos.csv". Permita que o usuário pesquise um produto pelo nome e, em seguida, atualize os campos, como preço ou quantidade em estoque, desse produto no arquivo CSV.

        Scanner scanner = new Scanner(System.in);

        try {
            // Solicitar ao usuário o nome do produto que deseja atualizar
            System.out.println("Digite o nome do produto que deseja atualizar:");
            String nomeProduto = scanner.nextLine();

            // Pesquisar o produto pelo nome no arquivo CSV e obter suas informações
            Produto produtoParaAtualizar = buscarProdutoPorNome(nomeProduto);

            if (produtoParaAtualizar != null) {
                // Se o produto for encontrado, solicitar ao usuário que atualize as informações
                System.out.println("Produto encontrado:");
                System.out.println(produtoParaAtualizar);

                System.out.println("Digite o novo preço do produto:");
                double novoPreco = Double.parseDouble(scanner.nextLine());

                System.out.println("Digite a nova quantidade do produto:");
                int novaQuantidade = Integer.parseInt(scanner.nextLine());

                // Atualizar as informações do produto no arquivo CSV
                atualizarProdutoNoCSV(produtoParaAtualizar, novoPreco, novaQuantidade);

                System.out.println("Informações do produto atualizadas com sucesso!");

            } else {
                System.out.println("Produto não encontrado.");
            }

        } catch (IOException e) {
            System.err.println("Erro ao atualizar o produto: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static Produto buscarProdutoPorNome(String nomeProduto) throws IOException, CsvValidationException {
        String nomeArquivo = "produtos.csv";

        // Cria um CSVReader para ler o arquivo CSV
        CSVReader reader = new CSVReader(new FileReader(nomeArquivo));
        String[] linha;

        // Pula a primeira linha (cabeçalho)
        reader.readNext();

        // Busca o produto pelo nome no arquivo CSV
        while ((linha = reader.readNext()) != null) {
            String nome = linha[0];
            double preco = Double.parseDouble(linha[1]);
            int quantidade = Integer.parseInt(linha[2]);

            if (nome.equalsIgnoreCase(nomeProduto)) {
                reader.close();
                return new Produto(nome, preco, quantidade);
            }
        }

        reader.close();
        return null; // Retorna null se o produto não for encontrado
    }

    private static void atualizarProdutoNoCSV(Produto produto, double novoPreco, int novaQuantidade) throws IOException, CsvValidationException {
        String nomeArquivo = "produtos.csv";
        List<String[]> linhasAtualizadas = new ArrayList<>();

        // Lê todas as linhas do arquivo CSV e atualiza as informações do produto
        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;

            // Adiciona a primeira linha (cabeçalho) ao ArrayList de linhas atualizadas
            linhasAtualizadas.add(reader.readNext());

            // Lê cada linha do arquivo CSV
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                double preco = Double.parseDouble(linha[1]);
                int quantidade = Integer.parseInt(linha[2]);

                // Se encontrar o produto, atualiza suas informações
                if (nome.equalsIgnoreCase(produto.getNome())) {
                    preco = novoPreco;
                    quantidade = novaQuantidade;
                }

                // Adiciona a linha atualizada ao ArrayList de linhas atualizadas
                linhasAtualizadas.add(new String[]{nome, String.valueOf(preco), String.valueOf(quantidade)});
            }
        }

        // Escreve as linhas atualizadas no arquivo CSV
        try (CSVWriter writer = new CSVWriter(new FileWriter(nomeArquivo))) {
            writer.writeAll(linhasAtualizadas);
        }
    }
}

