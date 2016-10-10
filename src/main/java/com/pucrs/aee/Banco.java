package com.pucrs.aee;

/**
 * Created by Junior on 09/10/2016.
 */
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
        QueueTAD<Cliente> filaDeAtendimento = procuraIdosos(fila);

        if (!fila.isEmpty()) {
            int sizeOfFila = 5;
            if (filaDeAtendimento.size() < 5) {
                sizeOfFila = 10 - filaDeAtendimento.size();
            }
            if (fila.size() < sizeOfFila) {
                sizeOfFila = fila.size();
            }

            for (int i = 0; i < sizeOfFila; i++) {
                filaDeAtendimento.enqueue(fila.dequeue());
            }
        }

        return filaDeAtendimento;

    }

    private QueueTAD<Cliente> procuraIdosos(QueueTAD<Cliente> fila) {
        int size = fila.size();
        int idosos = 0;
        QueueTAD<Cliente> aux = new QueueLinked<>();


        for (int i = 0; i < size; i++) {
            Cliente cliente = fila.dequeue();
            if (idosos < 5 && cliente.isIdoso()) {
                aux.enqueue(cliente);
                idosos++;
            } else {
                fila.enqueue(cliente);
            }
        }
        return aux;
    }

    public void atenderFila(QueueTAD<Cliente> filaDeAtendimento) {
        System.out.println();
        int size = filaDeAtendimento.size();
        if (size - 5 < 0) {
            for (int i = 0; i < size; i++) {
                Cliente cliente = filaDeAtendimento.dequeue();
                caixasPrioritarios[i].atenderNovoCliente(cliente);
                System.out.println("Caixa Prioritário["+i+"]"+ cliente);
            }
        } else if (size - 5 > 0) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Caixa Prioritário["+i+"]"+filaDeAtendimento.dequeue());
            }
            System.out.println();
            for (int i = 5; i < size; i++) {
                System.out.println("Caixa Normal["+i+"]"+filaDeAtendimento.dequeue());
            }
        } else {
            for (int i = 0; i < size; i++) {
                System.out.println("Caixa Prioritário["+i+"]"+filaDeAtendimento.dequeue());
            }
        }


    }
}
