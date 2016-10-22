package com.pucrs.aee;

import java.util.NoSuchElementException;

/**
 * Created by Junior on 04/10/2016.
 */
public class Caixa {

    private int numeroDeAtendidos;
    private Cliente clienteAtual;

    public Caixa(){
        numeroDeAtendidos = 0;
        clienteAtual = null;
    }

    public void atenderNovoCliente(Cliente cliente){
        numeroDeAtendidos++;
    }

    public Cliente dispensarClienteAtual(){
        if(clienteAtual == null){
            throw new NoSuchElementException("Não existe nenhum cliente para dispensar.");
        }
        Cliente cliente = this.clienteAtual;
        this.clienteAtual = null;
        return cliente;
    }

    public boolean isVazio(){
        return clienteAtual == null;
    }

    public Cliente getClienteAtual() {
        return clienteAtual;
    }

    public int getNumeroDeAtendidos() {
        return numeroDeAtendidos;
    }
}
