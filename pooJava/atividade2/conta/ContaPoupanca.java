package pooJava.atividade2.conta;

public class ContaPoupanca extends ContaBancaria{
    @Override
    public double sacar(double saque) {
        return super.sacar(saque);
    }

    @Override
    public double depositar(double deposito) {
        return super.depositar(deposito);
    }

    // Constructors;
    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    public ContaPoupanca() {
        super();
    }

    // Getters and Setter;
    @Override
    public double getSaldo() {
        return super.getSaldo();
    }

    @Override
    public void setSaldo(double saldo) {
        super.setSaldo(saldo);
    }
}
