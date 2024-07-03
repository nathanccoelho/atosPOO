package pooJava.atividade3.contaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainBanco {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ContaBancaria conta = null;
        int opcao = 1;

        while (opcao != 0) {
            System.out.println("Olá bem vindo ao banco Rabbit!");
            System.out.println("-----------------------------------");
            System.out.println("Digite uma opção: \n1- Criar conta. \n2- Sacar. \n3- Depositar " +
                    "\n4- Extrato. \n5- Realizar investimentos. \n6- Retirar investimentos. \n0- Sair.");

            try {
                opcao = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite um número inteiro.");
                scan.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    conta = criarConta(scan);
                    break;
                case 2:
                    if (conta != null) {
                        realizarSaque(scan, conta);
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro!");
                    }
                    break;
                case 3:
                    if (conta != null) {
                        realizarDeposito(scan, conta);
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro!");
                    }
                    break;
                case 4:
                    if (conta != null) {
                        conta.extrato();
                    } else {
                        System.out.println("Você precisa criar uma conta primeiro!");
                    }
                    break;
                case 5:
                    if (conta instanceof ContaPoupanca) {
                        realizarInvestimento(scan, (ContaPoupanca) conta);
                    } else {
                        System.out.println("Você precisa criar uma conta poupança primeiro!");
                    }
                    break;
                case 6:
                    if (conta instanceof ContaPoupanca) {
                        retirarInvestimento(scan, (ContaPoupanca) conta);
                    } else {
                        System.out.println("Você precisa criar uma conta poupança primeiro!");
                    }
                    break;
                case 0:
                    System.out.println("Obrigado! Até logo :).");
                    break;
                default:
                    System.out.println("Opção inválida! Digite uma opção correta.");
                    break;
            }
        }
    }

    private static ContaBancaria criarConta(Scanner scan) {
        int contaTipo = 0;

        while(true){
            System.out.println("Deseja cadastrar: \n1- Conta Corrente. \n2- Conta Poupança.");
            try {
                contaTipo = scan.nextInt();
                scan.nextLine();
                break;
            } catch (InputMismatchException e){
                System.out.println("Opção inválida! Digite um número inteiro.");
                scan.nextLine();
                continue;
            }
        }

        System.out.println("Digite o nome do titular:");
        String nome = scan.nextLine();
        System.out.println("Digite o CPF do titular:");
        String cpf = scan.nextLine();

        ContaBancaria conta;
        if (contaTipo == 1) {
            conta = new ContaCorrente();
        } else {
            conta = new ContaPoupanca();
        }

        conta.setTitular(nome);
        conta.setCpf(cpf);

        System.out.println("Parabéns! Sua conta foi criada com sucesso.");
        conta.descricao();
        return conta;
    }

    private static void realizarSaque(Scanner scan, ContaBancaria conta) {
        System.out.println("Digite o valor para o saque: ");
        try {
            double saque = scan.nextDouble();
            if(saque < 0){
                System.out.println("O valor do saque deve ser positivo!");
            } else if (saque>conta.getSaldo()) {
                System.out.println("Saldo insuficiente :(."+"\nSaldo atual: "+conta.getSaldo());
            } else {
                conta.sacar(saque);
                System.out.println("Saque realizado com sucesso! Novo saldo: " + conta.getSaldo());
            }

        } catch (InputMismatchException e) {
            System.out.println("Valor de saque inválido! Digite um número válido.");
            scan.nextLine();
        }
    }

    private static void realizarDeposito(Scanner scan, ContaBancaria conta) {
        System.out.println("Digite o valor para o depósito: ");
        try {
            double deposito = scan.nextDouble();
            scan.nextLine();
            conta.depositar(deposito);
        } catch (InputMismatchException e) {
            System.out.println("Valor de depósito inválido! Digite um número válido.");
            scan.nextLine();
        }
    }

    private static void realizarInvestimento(Scanner scan, ContaPoupanca contaPoupanca) {
        System.out.println("Digite o valor para investimento na conta poupança: ");
        try {
            double investimento = scan.nextDouble();
            scan.nextLine();
            contaPoupanca.gerarInvestimentos(investimento);
        } catch (InputMismatchException e) {
            System.out.println("Valor de investimento inválido! Digite um número válido.");
            scan.nextLine();
        }
    }

    private static void retirarInvestimento(Scanner scan, ContaPoupanca contaPoupanca){
        System.out.println("Digite o valor para retirar o investimento na conta poupança: ");
        try {
            double investimento = scan.nextDouble();
            scan.nextLine();
            contaPoupanca.retirarInvestimento(investimento);
        } catch (InputMismatchException e) {
            System.out.println("Valor de investimento inválido! Digite um número válido.");
            scan.nextLine();
        }
    }
}