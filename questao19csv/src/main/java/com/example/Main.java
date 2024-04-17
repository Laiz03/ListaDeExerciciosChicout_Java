package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import com.opencsv.CSVWriter;

public class Main {

//19. Desenvolva um programa Java que use a biblioteca OpenCSV para criar um arquivo CSV chamado "funcionarios.csv" e escrever informações sobre funcionários nele. Peça ao usuário que insira os detalhes dos funcionários, como nome, cargo e salário, e adicione esses dados ao arquivo CSV.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            FileWriter funcionario = new FileWriter("funcionarios.csv");

            CSVWriter csvWriter = new CSVWriter(funcionario);

            while (true) {
                System.out.println("Digite o nome do funcionário (ou digite 'sair' para terminar):");
                String nome = scanner.nextLine();
                if (nome.equalsIgnoreCase("sair")) {
                    break;
                }
                
                System.out.println("Digite o cargo do funcionário:");
                String cargo = scanner.nextLine();

                System.out.println("Digite o salário do funcionário:");
                String salario = scanner.nextLine();

                // Escreva os detalhes do funcionário no arquivo CSV
                csvWriter.writeNext(new String[]{nome, cargo, salario});
            }

            csvWriter.close();
            funcionario.close();

            System.out.println("Arquivo funcionarios.csv criado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo CSV: ");
        } finally {
            scanner.close();
        }
    }
}
