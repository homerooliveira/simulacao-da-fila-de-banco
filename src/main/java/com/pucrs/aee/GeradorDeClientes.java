package com.pucrs.aee;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * Created by Junior on 04/10/2016.
 */
public class GeradorDeClientes {
    private static  List<String> nomes;
    private Random gerador;

    public GeradorDeClientes() {
        gerador = new Random();
        try {
            nomes = Files.readAllLines(Paths.get("src/main/resources/nomes.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Cliente gerarNovoCliente() {
        int idade = gerador.nextInt(82)+18;
        String nome = nomes.get(gerador.nextInt(nomes.size()));
        return new Cliente(nome, idade);

    }


}
