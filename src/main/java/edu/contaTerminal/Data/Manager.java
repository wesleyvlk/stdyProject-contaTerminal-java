package main.java.edu.contaTerminal.Data;

import java.util.Collection;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class Manager {
    private final Customer customer;
    private final Collection<Customer> customers;
    private final Random generatorAccount;
    private final Scanner scanner;

    public Manager() {
        this.customer = new Customer("[UF, Cidade]: 9999", "BBC [Nome do Banco]");
        this.customers = new LinkedList<>();
        this.generatorAccount = new Random();
        this.scanner = new Scanner(System.in);
    }

    public void runMenu() {
        boolean runMenu = false;
        if (!runMenu) {
            System.out.println("\n:: Iniciando Registrador de contas bancarias... " +
                    customer.getBank());
            System.out.print("\tAperte ENTER para continuar ");
            scanner.nextLine();
            runMenu = true;
        }
        while (runMenu) {
            System.out.println("\n Menu iniciar:\n");
            System.out.println(" 1 - Registrar nova conta\n 2 - Buscar conta registrada\n 0 - Finalizar\n");
            System.out.print(" Escolha uma opção: [1, 2 ou 0] ");
            switch (scanner.next()) {
                case "1":
                    addRegister();
                    break;
                case "2":
                    showRegisters();
                    break;
                case "0":
                    runMenu = false;
                    System.out.println("\n:: Finalizando Registrador de contas bancarias... " +
                            customer.getBank() + "\n");
                    break;
            }
        }
    }

    private void addRegister() {
        boolean addRegister = false;
        while (!addRegister) {
            System.out.println("\n Registrando nova conta:\n");
            System.out.println(" Preencha o solicitado:");
            System.out.println("\n Nome completo:");
            System.out.printf(" ");
            customer.setClient(scanner.next());
            try {
                System.out.println(" Deposito inicial: [Se não houver: 0] ");
                System.out.printf(" ");
                customer.setBalance(scanner.nextDouble());
            } catch (final InputMismatchException e0) {
                System.out.println("\n insira apenas números!");
                continue;
            }
            customer.getAgency();
            customer.setAccount(generatorAccount.nextInt(99999999 + 1));
            System.out.println("\n Atribuindo dados a agencia...");
            System.out.println("\n Gerando numero de conta...");
            System.out.println("\n Novo cliente registrado com sucesso!");
            customers.add(new Customer(customer.getAgency(), customer.getAccount(), customer.getClient(),
                    customer.getBalance()));
            System.out.print("\tAperte 1 para continuar (ou '0' para finalizar): ");
            if (scanner.next().equals("0")) {
                addRegister = true;
            }
        }
    }

    private void showRegisters() {
        if (customers.isEmpty()) {
            System.out.println("\n Não a contas registradas");
        } else {
            customers.forEach(customer -> System.out.println("\n Agencia " +
                    customer.getAgency() + ", conta: " +
                    customer.getAccount() + ", cliente: "
                    + customer.getClient() + String
                            .format(", saldo: R$ %.2f", customer.getBalance())));
        }
    }
}
