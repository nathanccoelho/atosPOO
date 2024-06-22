package pooJava.atividade2.conta;

public class ContaCorrente extends ContaBancaria {
    @Override
    public double sacar(double saque) {
        return super.sacar(saque);
    }

    @Override
    public double depositar(double deposito) {
        return super.depositar(deposito);
    }

    // Constructors;
    public ContaCorrente(double saldo) {
        super(saldo);
    }

    public ContaCorrente() {
        super();
    }

    // Getters and Setters;
    @Override
    public double getSaldo() {
        return super.getSaldo();
    }

    @Override
    public void setSaldo(double saldo) {
        super.setSaldo(saldo);
    }
}
