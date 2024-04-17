package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class App 
{
    public static void main( String[] args )
    {
        // 17. Implemente um programa que crie um arquivo binário personalizado contendo informações estruturadas, como registros de funcionários, e permita adicionar, atualizar e excluir registros no arquivo.
    
        Funcionario funcionario1 = new Funcionario("Laíz", 123456, 20, 1600);

        adicionarFuncionario("funcionarios.bin", funcionario1);

        excluirFuncionario("funcionarios.bin", "Laíz");

    }


    private static void adicionarFuncionario(String nomeArquivo, Funcionario novoFuncionario) {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(nomeArquivo, true))) {
            out.writeUTF(novoFuncionario.getNome());
            out.writeInt(novoFuncionario.getCPF());
            out.writeInt(novoFuncionario.getIdade());
            out.writeFloat(novoFuncionario.getSalario());
            System.out.println("Novo funcionário adicionado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void excluirFuncionario(String nomeArquivo, String nomeParaExcluir) {
        File arquivoOriginal = new File(nomeArquivo);
        File arquivoTemporario = new File("temporario.bin");

        try (
            DataInputStream in = new DataInputStream(new FileInputStream(arquivoOriginal));
            DataOutputStream out = new DataOutputStream(new FileOutputStream(arquivoTemporario))
        ) {
            while (in.available() > 0) {
                String nome = in.readUTF();
                int CPF = in.readInt();
                int idade = in.readInt();
                float salario = in.readFloat();

                if (!nome.equals(nomeParaExcluir)) {
                    out.writeUTF(nome);
                    out.writeInt(CPF);
                    out.writeInt(idade);
                    out.writeFloat(salario);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Renomear o arquivo temporário para substituir o original
        if (arquivoOriginal.delete()) {
            if (!arquivoTemporario.renameTo(arquivoOriginal)) {
                System.out.println("Falha ao renomear arquivo temporário.");
            }
        } else {
            System.out.println("Falha ao excluir arquivo original.");
        }
    }

}
