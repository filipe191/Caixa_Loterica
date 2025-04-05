import controller.Caixa;
import models.Cliente;

public class Main {
    public static void main(String[] args) {
        Caixa caixa = new Caixa();

        caixa.registrarCliente(new Cliente("Ana", 2));
        caixa.registrarCliente(new Cliente("Bruno", 3));
        caixa.registrarCliente(new Cliente("Carlos", 1));
        caixa.registrarCliente(new Cliente("Diana", 4));

        System.out.println("Iniciando atendimento...\n");

        caixa.processarAtendimento();

        // Pequeno delay para garantir que as mensagens finais das threads apareçam
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\nTodos os clientes foram atendidos!");
        System.out.println("Total atendidos: " + caixa.getClientesAtendidos());
        System.out.println("Clientes aguardando: " + caixa.getClientesAguardando());
    }
}
