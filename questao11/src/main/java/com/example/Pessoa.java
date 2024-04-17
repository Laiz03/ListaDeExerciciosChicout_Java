package com.example;
import java.io.Serializable;

// Metodo get, acesso ao atributo
// Metodo set, modifica o atributo


class Pessoa implements Serializable{
    String nome;
    int idade;


public Pessoa(String nome, int idade) {
    this.nome = nome;
    this.idade = idade;
}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}

public int getIdade() {
    return idade;
}

public void getIdade(int idade) {
    this.idade = idade;
}

}