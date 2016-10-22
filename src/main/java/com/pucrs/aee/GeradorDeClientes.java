package com.pucrs.aee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;


public class GeradorDeClientes {
    private static List<String> nomes;
    private Random gerador;

    public GeradorDeClientes() {
        gerador = new Random();
        try {
            nomes = Files.readAllLines(Paths.get("src/main/resources/nomes.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void criarClientes(QueueTAD<Cliente> fila, int numeroDeClientes) {
        for (int j = 0; j < numeroDeClientes; j++) {
            Cliente cliente = gerarNovoCliente();
            fila.enqueue(cliente);
        }
    }

    private Cliente gerarNovoCliente() {
        int idade = gerador.nextInt(82) + 18;
        String nome = nomes.get(gerador.nextInt(nomes.size()));
        return new Cliente(nome, idade);

    }

}
