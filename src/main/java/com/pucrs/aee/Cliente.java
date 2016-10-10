package com.pucrs.aee;

import java.util.Objects;

/**
 * Created by Junior on 29/09/2016.
 */
public class Cliente {
    private String nome;
    private int idade;

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }


    public boolean isIdoso() {
        return idade >= 65;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cliente{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", idade=").append(idade);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return idade == cliente.idade &&
                Objects.equals(nome, cliente.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, idade);
    }
}
