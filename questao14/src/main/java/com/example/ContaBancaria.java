package com.example;
import java.io.Serializable;

class ContaBancaria implements Serializable {
    String nome;
    int numero;
    float saldo;
    int CPF;

    public ContaBancaria(String nome, int numero, int saldo, int CPF) {
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
        this.CPF = CPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

}
