package com.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Funcionario {
    String nome;
    int CPF;
    int idade;
    float salario;

    public Funcionario(String nome, int CPF, int idade, float salario) {
        this.nome = nome;
        this.CPF = CPF;
        this.idade = idade;
        this.salario = salario;
    }

    public String getNome(){
        return nome;
    }
    
    public int getCPF(){
        return CPF;
    }

    public int getIdade(){
        return idade;
    }

    public float getSalario(){
        return salario;
    }


}
