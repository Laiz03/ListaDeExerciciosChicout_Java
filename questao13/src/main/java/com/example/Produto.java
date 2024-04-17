package com.example;

import java.io.Serializable;

class Produto implements Serializable{
    int codigo;
    String nome;
    float valor;

    public Produto (int codigo, String nome, float valor) {
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
    }

    public int getcodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome (String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor (float valor) {
        this.valor = valor;
    }


}
