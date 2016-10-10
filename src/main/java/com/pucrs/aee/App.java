package com.pucrs.aee;

import java.util.Random;

/**
 * Created by Junior on 28/09/2016.
 */

public class App {

    private static Banco banco;

    public static void main(String[] args) {
        QueueTAD<Cliente> fila = new QueueLinked<>();
        GeradorDeClientes geradorDeClientes = new GeradorDeClientes();
        Caixa[] caixasPrioritarios = new Caixa[5];
        Random random = new Random();
        banco = new Banco();

        criarCaixas(caixasPrioritarios);

        for (int i = 0; i < 1000000; i++) {
            System.out.println("---------------Tempo:"+ i+"-------------" );

            int size = random.nextInt(15);
            for (int j = 0; j < size; j++) {
                Cliente cliente = geradorDeClientes.gerarNovoCliente();
                fila.enqueue(cliente);
            }

            System.out.println("Número de clientes gerados="+size);

            System.out.println("Fila total=" + fila);
            System.out.println("tamanho=" + fila.size());

            QueueTAD<Cliente> filaDeAtendimento = banco.criarFilaDeAtendimento(fila);

            System.out.println("Fila de Atedendimento=" + filaDeAtendimento);
            System.out.println("tamanho=" + filaDeAtendimento.size());

            banco.atenderFila(filaDeAtendimento);

            System.out.println();
            System.out.println();


        }
    }


//    private static void atenderClientes(QueueTAD<Cliente> filaPrioridade, Caixa[] caixasPrioridade) {
//        int numeroDeCaixas = 5;
//        if (filaPrioridade.size() < caixasPrioridade.length) {
//            numeroDeCaixas = filaPrioridade.size();
//        }
//        for (int j = 0; j < numeroDeCaixas; j++) {
//            Cliente c = filaPrioridade.dequeue();
//            caixasPrioridade[j].atenderNovoCliente(c);
//        }
//    }

    private static void criarCaixas(Caixa[] caixas) {
        for (int i = 0; i < caixas.length; i++) {
            caixas[i] = new Caixa();
        }
    }


}
