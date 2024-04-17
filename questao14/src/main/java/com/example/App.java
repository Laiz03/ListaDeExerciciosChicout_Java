package com.example;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class App 
{

    public static void main( String[] args )
    {
        //14. Implemente um programa que carregue um objeto serializado da classe ContaBancaria do arquivo "conta.dat", atualize o saldo e, em seguida, serialize o objeto atualizado de volta ao arquivo.

        ContaBancaria contab = new ContaBancaria("Laíz", 12345, 50, 123456789);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("conta.dat"))) {
            out.writeObject(contab);
            System.out.println("Objeto ContaBancaria serializado com sucesso");
        } catch (Exception e) {
            System.out.println("Objeto não serializado");
        }

        System.out.println("Nome: " + contab.nome);
        System.out.println("Saldo: " + contab.saldo);

        contab.saldo = 900;

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("conta.dat"))) {
            out.writeObject(contab);
            System.out.println("Objeto ContaBancaria serializado com sucesso");
        } catch (Exception e) {
            System.out.println("Objeto não serializado");
        }

        System.out.println("\nSaldo Atualizado: " + contab.saldo);
    }
}
