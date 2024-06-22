package pooJava.atividade2.conta;

public class ContaBancaria {

    private double saldo;


    public double sacar(double saque){
        double novoSaldo = getSaldo()-saque;
        setSaldo(novoSaldo);
        return novoSaldo;
    }

    public double depositar(double deposito){
        double novoSaldo = getSaldo()+deposito;
        setSaldo(novoSaldo);
        return novoSaldo;
    }


    // Constructors;
    public ContaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public ContaBancaria() {
    }

    // Getters and Setters;
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
