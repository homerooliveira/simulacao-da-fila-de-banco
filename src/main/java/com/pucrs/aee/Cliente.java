package com.pucrs.aee;

/**
 * Created by Junior on 29/09/2016.
 */
public class Cliente {
    private String nome;
    private int idade;
    private int numero;

    public Cliente(String nome, int idade, int numero) {
        this.nome = nome;
        this.idade = idade;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getNumero() {
        return numero;
    }
}
