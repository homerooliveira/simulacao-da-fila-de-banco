package com.pucrs.aee;

import java.util.Random;

public class Simulacao {

    public void simularClientes(int tempo) {
        Random random = new Random();
        Banco banco = new Banco();
        GeradorDeClientes geradorDeClientes = new GeradorDeClientes();
        QueueTAD<Cliente> fila = new QueueLinked<>();

        for (int i = 0; i < tempo; i++) {
            System.out.println("---------------Tempo:" + i + "-------------");

            int numeroDeClientes = random.nextInt(15);
            geradorDeClientes.criarClientes(fila, numeroDeClientes);

            System.out.println("Número de clientes gerados=" + numeroDeClientes);
            System.out.println("Fila total=" + fila);
            System.out.println("Tamanho da fila=" + fila.size());

            QueueTAD<Cliente> filaDeAtendimento = banco.criarFilaDeAtendimento(fila);
            banco.atenderClientes(filaDeAtendimento);
        }
    }




}
