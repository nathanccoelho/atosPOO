package pooJava.atividade3.contaBancaria;

public class ContaCorrente extends ContaBancaria{
    private double creditoEspecial;

    // Retorna o extrato, ainda gostaria de retornar as últimas transações.
    @Override
    public void extrato() {
        super.extrato();
        System.out.println("Crédito especial: "+getCreditoEspecial());
    }


    // Só retorna as informações.
    @Override
    public void descricao() {
        System.out.println("Nome titular: "+getTitular()+"\nCPF titular: "+getCpf()+"\nAgência: "+getAgencia()+"\nConta: "+getNumeroConta()
        +"\nSaldo atual: "+getSaldo()+"\nCrédito Especial: "+getCreditoEspecial());
    }

    // Nesse caso precisei acrescentar o saldoDisponivel que é o saldo mais o créditoEspecial, ja que é um atributo
    // especifico de contaCorrente.
    @Override
    public boolean sacar(double saque) {
        double saldo = getSaldo();
        double saldoDisponivel = getSaldo() + getCreditoEspecial();
        if (saque > saldoDisponivel) {
            return false;
        }

        if (saque <= saldo) {
            setSaldo(saldo - saque);
        } else {
            double valorDoCreditoEspecial = saque - saldo;
            setSaldo(0);
            setCreditoEspecial(getCreditoEspecial() - valorDoCreditoEspecial);
        }

        return true;
    }


    // Construtors;
    public ContaCorrente(String titular, String cpf) {
        super(titular, cpf);
        this.creditoEspecial = 1000;
    }
    public ContaCorrente() {
        super();
        this.creditoEspecial = 1000;
    }


    // Getters and Setters;
    public double getCreditoEspecial() {
        return creditoEspecial;
    }

    public void setCreditoEspecial(double creditoEspecial) {
        this.creditoEspecial = creditoEspecial;
    }


}
