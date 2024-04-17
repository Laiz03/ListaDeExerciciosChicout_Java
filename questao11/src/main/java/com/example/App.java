package com.example;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class App 
{
    public static void main( String[] args )
    {
        //Escreva um programa Java que serializa um objeto da classe Pessoa em um arquivo binário chamado "pessoa.dat".

        Pessoa pessoa = new Pessoa("Laíz", 20);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("pessoa.dat"))) {
            out.writeObject(pessoa); // executa a serialização do objeto pessoa. Quando chama out.writeObject(pessoa), o objeto pessoa é convertido em uma sequência de bytes e gravado no arquivo binário especificado. 
            System.out.println("Objeto Pessoa serializado com sucesso."); 
        } catch (Exception e) {
            System.out.println("Erro ao serializar o objeto Pessoa: " + e.getMessage());
        }

    }
}
