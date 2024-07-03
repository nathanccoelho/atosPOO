package pooJava.atividade3.contaBancaria;

import java.util.Random;

public abstract class ContaBancaria {

    private String titular;
    private String cpf;
    private double saldo;
    private String agencia;
    private String numeroConta;


    // Descricao para as classes filhas;
    public abstract void descricao();

    public void extrato(){
        System.out.println("Extrato: \nTitular: " + getTitular() + "\nSaldo: " + getSaldo());
    }

    // Saque de algum valor e alterar o saldo.
    public boolean sacar(double saque){
        if(saque< 0){
            return false;
        } else if (saque>getSaldo()) {
            return false;
        }
        setSaldo(getSaldo()-saque);
        return true;
    }


    // Depositar valor e alterar saldo.
    public boolean depositar(double deposito){
        if(deposito < 0){
            System.out.println("O valor do depósito deve ser positivo!");
            return false;
        }
        setSaldo(getSaldo()+deposito);
        System.out.println("Depósito realizado com sucesso! Novo saldo: " + getSaldo());

        return true;
    }

    // Gera um número aleatório de 4 digitos e converte em String.
    private String gerarAgencia(){
       Random random = new Random();
       int agencia = random.nextInt(9000)+1000;
       return String.valueOf(agencia);
    }

    // Gera um número aleatório de 6 digitos e converte em String.
    private String gerarConta(){
        Random random = new Random();
        int agencia = random.nextInt(900000)+100000;
        return String.valueOf(agencia);
    }


    // Constructors;
    public ContaBancaria(String titular, String cpf) {
        this.titular = titular;
        this.cpf = cpf;
        this.agencia = gerarAgencia();
        this.numeroConta = gerarConta();
    }

    public ContaBancaria() {
        this.agencia = gerarAgencia();
        this.numeroConta = gerarConta();
    }

    // Getters and Setters;
    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
