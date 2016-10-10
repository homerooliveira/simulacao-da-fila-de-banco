package com.pucrs.aee;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Junior on 09/10/2016.
 */
public class BancoTest {

    private Banco banco;

    @Before
    public void setUp() throws Exception{
        this.banco  = new Banco();
    }

    @Test
    public void deveReceberUmaFilaVazia(){
        QueueTAD<Cliente> clientes = new QueueLinked<>();
        QueueTAD<Cliente> filaDeAtendimento = banco.criarFilaDeAtendimento(clientes);
        assertTrue(filaDeAtendimento.isEmpty());

    }

    @Test
    public void deveReceberUmaFilaCom5Idosos(){
        Cliente cliente1 = new Cliente("Jone Jerde", 75);
        Cliente cliente2 = new Cliente("Samuel Pagac", 89);
        Cliente cliente5 = new Cliente("Taylor Ondricka", 100);
        Cliente cliente3 = new Cliente("Marc Greenfelder", 90);
        Cliente cliente4 = new Cliente("Inge Hoppe", 65);

        QueueTAD<Cliente> clientes = new QueueLinked<>();

        clientes.enqueue(cliente1);
        clientes.enqueue(cliente2);
        clientes.enqueue(cliente3);
        clientes.enqueue(cliente4);
        clientes.enqueue(cliente5);

        QueueTAD<Cliente> filaDeAtendimento = banco.criarFilaDeAtendimento(clientes);

        assertEquals(5, filaDeAtendimento.size());
        assertEquals(cliente1, filaDeAtendimento.dequeue());
        assertEquals(cliente2, filaDeAtendimento.dequeue());
        assertEquals(cliente3, filaDeAtendimento.dequeue());
        assertEquals(cliente4, filaDeAtendimento.dequeue());
        assertEquals(cliente5, filaDeAtendimento.dequeue());

    }

    @Test
    public void deveReceberUmaFilaCom5IdososE2Jovens(){
        Cliente cliente1 = new Cliente("Jone Jerde", 75);
        Cliente cliente2 = new Cliente("Samuel Pagac", 89);
        Cliente cliente3 = new Cliente("Marc Greenfelder", 90);
        Cliente cliente4 = new Cliente("Inge Hoppe", 65);
        Cliente cliente5 = new Cliente("Taylor Ondricka", 100);
        Cliente cliente6 = new Cliente("Taylor Ondricka", 45);
        Cliente cliente7 = new Cliente("Inge Hoppe", 18);

        QueueTAD<Cliente> clientes = new QueueLinked<>();

        clientes.enqueue(cliente1);
        clientes.enqueue(cliente2);
        clientes.enqueue(cliente3);
        clientes.enqueue(cliente4);
        clientes.enqueue(cliente5);
        clientes.enqueue(cliente6);
        clientes.enqueue(cliente7);

        QueueTAD<Cliente> filaDeAtendimento = banco.criarFilaDeAtendimento(clientes);

        assertEquals(7, filaDeAtendimento.size());

        assertEquals(cliente1, filaDeAtendimento.dequeue());
        assertEquals(cliente2, filaDeAtendimento.dequeue());
        assertEquals(cliente3, filaDeAtendimento.dequeue());
        assertEquals(cliente4, filaDeAtendimento.dequeue());
        assertEquals(cliente5, filaDeAtendimento.dequeue());
        assertEquals(cliente6, filaDeAtendimento.dequeue());
        assertEquals(cliente7, filaDeAtendimento.dequeue());

    }

    @Test
    public void deveReceberUmaFilaCom6Jovens(){
        Cliente cliente1 = new Cliente("Jone Jerde", 18);
        Cliente cliente2 = new Cliente("Samuel Pagac", 19);
        Cliente cliente3 = new Cliente("Marc Greenfelder", 30);
        Cliente cliente4 = new Cliente("Taylor Ondricka", 41);
        Cliente cliente5 = new Cliente("Taylor Ondricka", 43);
        Cliente cliente6 = new Cliente("Inge Hoppe", 54);

        QueueTAD<Cliente> clientes = new QueueLinked<>();

        clientes.enqueue(cliente1);
        clientes.enqueue(cliente2);
        clientes.enqueue(cliente3);
        clientes.enqueue(cliente4);
        clientes.enqueue(cliente5);
        clientes.enqueue(cliente6);

        QueueTAD<Cliente> filaDeAtendimento = banco.criarFilaDeAtendimento(clientes);

        assertEquals(6, filaDeAtendimento.size());
        assertEquals(cliente1, filaDeAtendimento.dequeue());
        assertEquals(cliente2, filaDeAtendimento.dequeue());
        assertEquals(cliente3, filaDeAtendimento.dequeue());
        assertEquals(cliente4, filaDeAtendimento.dequeue());
        assertEquals(cliente5, filaDeAtendimento.dequeue());
        assertEquals(cliente6, filaDeAtendimento.dequeue());

    }

}