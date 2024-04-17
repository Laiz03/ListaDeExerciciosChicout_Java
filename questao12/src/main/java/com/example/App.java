package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class App 
{
    public static void main( String[] args )
    {
        // 12. Modifique o programa anterior para deserializar o objeto do arquivo "pessoa.dat" e exibir os detalhes da pessoa no console.

        Pessoa pessoa = new Pessoa("Laíz", 20);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pessoa.dat"))) {
            out.writeObject(pessoa); // executa a serialização do objeto pessoa. Quando chama out.writeObject(pessoa), o objeto pessoa é convertido em uma sequência de bytes e gravado no arquivo binário especificado. 
            System.out.println("Objeto Pessoa serializado com sucesso."); 
        } catch (Exception e) {
            System.out.println("Erro ao serializar o objeto Pessoa: " + e.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("pessoa.dat"))){
            // lendo o objeto do arquivo
            Pessoa pessoaa = (Pessoa) in.readObject(); 
            //  detalhes da pessoa
            System.out.println("\nNome: " + pessoaa.getNome());
            System.out.println("Idade: " + pessoaa.getIdade()); System.out.println("");
        } catch (Exception e) {
            System.out.println("Erro ao deserializar");
        }

    }
}
