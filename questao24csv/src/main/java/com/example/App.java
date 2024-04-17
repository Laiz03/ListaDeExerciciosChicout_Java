package com.example;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
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
        // Crie um programa Java que use a biblioteca OpenCSV para ler um arquivo CSV chamado "funcionarios.csv" contendo informações sobre funcionários, como nome, cargo e salário. Permita que o usuário filtre os funcionários com base em critérios, como cargo ou salário mínimo, e exiba os resultados no console.
        Scanner scanner = new Scanner(System.in);

        try {
            // Ler o arquivo CSV de funcionários
            List<Funcionario> funcionarios = lerFuncionariosDoCSV("funcionarios.csv");

            // Exibir todos os funcionários lidos do arquivo CSV
            System.out.println("Funcionários lidos do arquivo CSV:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }

            // Solicitar ao usuário o critério de filtro
            System.out.println("\nFiltrar funcionários por (cargo/salário mínimo):");
            String criterio = scanner.nextLine();

            // Filtrar funcionários com base no critério fornecido pelo usuário
            List<Funcionario> funcionariosFiltrados = new ArrayList<>();
            if (criterio.equalsIgnoreCase("cargo")) {
                System.out.println("Digite o cargo:");
                String cargo = scanner.nextLine();
                funcionariosFiltrados = filtrarPorCargo(funcionarios, cargo);
            } else if (criterio.equalsIgnoreCase("salário mínimo")) {
                System.out.println("Digite o salário mínimo:");
                double salarioMinimo = Double.parseDouble(scanner.nextLine());
                funcionariosFiltrados = filtrarPorSalarioMinimo(funcionarios, salarioMinimo);
            } else {
                System.out.println("Critério de filtro inválido.");
            }

            // Exibir os funcionários filtrados no console
            System.out.println("\nFuncionários filtrados:");
            for (Funcionario funcionario : funcionariosFiltrados) {
                System.out.println(funcionario);
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static List<Funcionario> lerFuncionariosDoCSV(String nomeArquivo) throws IOException, CsvValidationException {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(nomeArquivo))) {
            String[] linha;
            reader.readNext(); // Ignorar o cabeçalho
            while ((linha = reader.readNext()) != null) {
                String nome = linha[0];
                String cargo = linha[1];
                double salario = Double.parseDouble(linha[2]);
                Funcionario funcionario = new Funcionario(nome, cargo, salario);
                funcionarios.add(funcionario);
            }
        }
        return funcionarios;
    }

    private static List<Funcionario> filtrarPorCargo(List<Funcionario> funcionarios, String cargo) {
        List<Funcionario> funcionariosFiltrados = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getCargo().equalsIgnoreCase(cargo)) {
                funcionariosFiltrados.add(funcionario);
            }
        }
        return funcionariosFiltrados;
    }

    private static List<Funcionario> filtrarPorSalarioMinimo(List<Funcionario> funcionarios, double salarioMinimo) {
        List<Funcionario> funcionariosFiltrados = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getSalario() >= salarioMinimo) {
                funcionariosFiltrados.add(funcionario);
            }
        }
        return funcionariosFiltrados;
    }
}

