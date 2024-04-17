package com.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //13. Crie um programa Java que serialize uma lista de objetos da classe Produto em um arquivo binário chamado "produtos.dat" e, em seguida, deserialize a lista e exiba todos os produtos no console.

        Produto produto = new Produto(01, "Laiz", 12);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("produtos.dat"))){
            out.writeObject(produto);
            System.out.println("Objeto Produto serializado com sucesso");
        } catch (Exception e) {
            System.out.println("Objeto Produto não foi serializado com sucesso");
        }


        try (ObjectInputStream in = new ObjectInputStream (new FileInputStream("produtos.dat"))){
            Produto produtoo = (Produto) in.readObject();

            System.out.println("\nCodigo: " + produtoo.getcodigo());
            System.out.println("Nome: " + produtoo.getNome());
            System.out.println("Valor: " + produtoo.getValor()); System.out.println("");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
