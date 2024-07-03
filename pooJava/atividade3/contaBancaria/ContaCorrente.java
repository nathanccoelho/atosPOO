package pooJava.atividade3.contaBancaria;

public class ContaCorrente extends ContaBancaria{
    private double creditoEspecial;

    @Override
    public void extrato() {
        super.extrato();
        System.out.println("Crédito especial: "+getCreditoEspecial());
    }

    @Override
    public void descricao() {
        System.out.println("Nome titular: "+getTitular()+"\nCPF titular: "+getCpf()+"\nAgência: "+getAgencia()+"\nConta: "+getNumeroConta()
        +"\nSaldo atual: "+getSaldo()+"\nCrédito Especial: "+getCreditoEspecial());
    }

    @Override
    public boolean sacar(double saque) {
        double saldoDisponivel = getSaldo() + creditoEspecial;
        if (saque > saldoDisponivel) {
            System.out.println("Saldo insuficiente! O valor máximo disponível para saque é: " + saldoDisponivel);
            return false;
        }
        setSaldo(getSaldo() - saque);
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
