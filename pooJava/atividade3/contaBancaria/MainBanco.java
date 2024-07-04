package pooJava.atividade3.contaBancaria;

import java.util.InputMismatchException;
import java.util.Scanner;



/* Confesso que mesmo sem precisar me coloquei no desafio de criar um banco com POO (Sempre quis fazer algo parecido).
* Foi mais desafiador do que o Estacionamento, tanto que precisei olhar algumas coisas com o ChatGPT.
* Ainda não está completo, o método sacar está faltando algumas verificações que vou explicando conforme segue o código.*/
public class MainBanco {
    public static void main(String[] args) {

        // Instancias que vou precisar mais a variável opção pra entrar no menú.
        Scanner scan = new Scanner(System.in);
        ContaBancaria conta = null;
        int opcao = 1;


        // While para o menú.
        while (opcao != 0) {
            System.out.println("Olá bem vindo ao banco Rabbit!");
            System.out.println("-----------------------------------");
            System.out.println("Digite uma opção: \n1- Criar conta. \n2- Sacar. \n3- Depositar " +
                    "\n4- Extrato. \n5- Realizar investimentos. \n6- Retirar investimentos. \n0- Sair.");

            // Captura de exceção para a variável opcão.
            try {
                opcao = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Digite um número inteiro.");
                scan.nextLine();
                continue;
            }

            // No desafio do Estacionamento utilizei if-else, por isso decidi mudar e usar o switch-case.
            // cada caso chama uma função estática, fiz assim pra reduzir código, porque abstraio o ContaCorrente e
            // ContaPoupança para somente ContaBancaria.
            switch (opcao) {
                case 1:
                    conta = criarConta(scan);
                    break;
                case 2:

                    // Não tem muito segrese nos casos, o if é só pra verificar se a conta está nulla, se estiver ele
                    // retorna ao menú e printa uma mensagem.
                    if (conta != null && conta instanceof ContaPoupanca) {
                        realizarSaquePoupanca(scan, (ContaPoupanca) conta);
                    } else if (conta != null && conta instanceof ContaCorrente) {
                        realizarSaqueCorrente(scan, (ContaCorrente) conta);
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
                    // No caso 5 e 6 ele verifica com o instanceof se a conta é poupança porque é uma opção só para essa classe.
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

    // Primeiro método estático é para criar conta, e ele retorna um ContaBancaria para ser genérico e posteriormente
    // eu conseguir utilizar ou corrente ou poupança.
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

        // Aqui instancia a conta com base no que o usuário quer, corrente ou poupança.
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


    // Nesse método tinha comentado que não tinha implementado porque o saque estava genérico pra ContaBancaria.
    // E como no ContaCorrente tem o créditoEspecial o cliente consegue realizar saque com o crédito, diferente do cliente
    // de contaPoupança. Cheguei na conclusão de só criar dois métodos um pra poupança e outro para corrente, e fazer a
    // verificação no case 2, sacar.
    private static void realizarSaquePoupanca(Scanner scan, ContaPoupanca conta) {
        System.out.println("Digite o valor para o saque: ");
        try {
            double saque = scan.nextDouble();
            if(saque < 0){
                System.out.println("O valor do saque deve ser positivo!");
            } else if (saque>conta.getSaldo()) {
                System.out.println("Saldo insuficiente :(."+"\nSaldo atual: "+conta.getSaldo());
            } else {
                conta.sacar(saque);
                System.out.println("Saque realizado com sucesso! " +
                        "\nNovo saldo: " + conta.getSaldo()+"\nInvestimentos: "+conta.getInvestimentos());
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor de saque inválido! Digite um número válido.");
            scan.nextLine();
        }
    }

    private static void realizarSaqueCorrente(Scanner scan, ContaCorrente conta) {
        double saldoDisponivel = conta.getSaldo()+ conta.getCreditoEspecial();

        System.out.println("Digite o valor para o saque: ");

        try {
            double saque = scan.nextDouble();
            if(saque < 0){
                System.out.println("O valor do saque deve ser positivo!");
            } else if (saque > saldoDisponivel) {
                System.out.println("Saldo insuficiente! O valor máximo disponível para saque é: " + saldoDisponivel);
            } else {
                conta.sacar(saque);
                System.out.println("Saque realizado com sucesso! " +
                        "\nNovo saldo: " + conta.getSaldo()+"\nCrédito especial: "+conta.getCreditoEspecial());
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor de saque inválido! Digite um número válido.");
            scan.nextLine();
        }
    }


    // Não tem segredo, pega o valor do paramêtro e coloca no conta.depositar(deposito).
    // Nesse caso como não precisei reimplementar nas subsClasses ele printa direto da classe pai.
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

    // Função parecida com o deposito e saque, a única diferença é que recebe somente o contaPoupança.
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

    // Mesma lógica da função realizarInvestimento.
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