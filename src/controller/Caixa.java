package controller;

import models.Cliente;

import java.util.LinkedList;
import java.util.Queue;

public class Caixa {
    private Queue<Cliente> filaClientes = new LinkedList<>();
    private int clientesAtendidos = 0;

    public synchronized void registrarCliente(Cliente cliente) {
        filaClientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente.getNome());
    }

    public void processarAtendimento() {
        while (true) {
            Cliente cliente;

            synchronized (this) {
                if (filaClientes.isEmpty()) break;
                cliente = filaClientes.poll();
            }

            Thread threadAtendimento = new Thread(() -> {
                System.out.println("Atendendo cliente: " + cliente.getNome());
                try {
                    Thread.sleep(cliente.getTempoAtendimento() * 1000L);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                synchronized (this) {
                    clientesAtendidos++;
                    System.out.println("Cliente atendido: " + cliente.getNome());
                }
            });

            threadAtendimento.start();

            try {
                threadAtendimento.join(); // Aguarda terminar antes de pegar o próximo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public synchronized int getClientesAtendidos() {
        return clientesAtendidos;
    }

    public synchronized int getClientesAguardando() {
        return filaClientes.size();
    }
}
