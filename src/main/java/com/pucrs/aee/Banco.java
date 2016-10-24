package com.pucrs.aee;


public class Banco {

    private Caixa[] caixasPrioritarios;
    private Caixa[] caixasNormais;

    public Banco() {
        caixasPrioritarios = new Caixa[5];
        caixasNormais = new Caixa[5];
        criarCaixas(caixasPrioritarios);
        criarCaixas(caixasNormais);
    }


    private void criarCaixas(Caixa[] caixas) {
        for (int i = 0; i < caixas.length; i++) {
            caixas[i] = new Caixa();
        }
    }


    public QueueTAD<Cliente> criarFilaDeAtendimento(QueueTAD<Cliente> fila) {
        QueueTAD<Cliente> filaDeIdosos = procuraIdosos(fila);

        if (!fila.isEmpty()) {
            int tamanhoPadrao = 5;
            if (filaDeIdosos.size() < tamanhoPadrao) {
                tamanhoPadrao = 10 - filaDeIdosos.size();
            }

            if (fila.size() < tamanhoPadrao) {
                tamanhoPadrao = fila.size();
            }

            for (int i = 0; i < tamanhoPadrao; i++) {
                filaDeIdosos.enqueue(fila.dequeue());
            }
        }

        return filaDeIdosos;

    }

    private QueueTAD<Cliente> procuraIdosos(QueueTAD<Cliente> fila) {
        int size = fila.size();
        int numeroDeIdosos = 0;
        QueueTAD<Cliente> filaDeIdosos = new QueueLinked<>();

        for (int i = 0; i < size; i++) {
            Cliente cliente = fila.dequeue();
            if (numeroDeIdosos < 5 && cliente.isIdoso()) {
                filaDeIdosos.enqueue(cliente);
                numeroDeIdosos++;
            } else {
                fila.enqueue(cliente);
            }
        }
        return filaDeIdosos;
    }

    public void atenderClientes(QueueTAD<Cliente> filaDeAtendimento) {
        int size = filaDeAtendimento.size();
        if (size - 5 < 0) {
            for (int i = 0; i < size; i++) {
                Cliente cliente = filaDeAtendimento.dequeue();
                caixasPrioritarios[i].atenderNovoCliente(cliente);
                System.out.println("Caixa Prioritário[" + i + "]" + cliente);
            }
        } else if (size - 5 > 0) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Caixa Prioritário[" + i + "]" + filaDeAtendimento.dequeue());
            }
            System.out.println();
            for (int i = 5; i < size; i++) {
                System.out.println("Caixa Normal[" + i + "]" + filaDeAtendimento.dequeue());
            }
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println("Caixa Prioritário[" + i + "]" + filaDeAtendimento.dequeue());
            }
        }


    }
}
