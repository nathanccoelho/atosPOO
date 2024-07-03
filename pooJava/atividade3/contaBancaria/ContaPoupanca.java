package pooJava.atividade3.contaBancaria;

public class ContaPoupanca extends ContaBancaria{

    private double investimentos;

    public void extrato() {
        super.extrato();
        System.out.println("Investimentos especial: "+getInvestimentos());
    }


    public boolean gerarInvestimentos(double valor) {
        if (valor <= 0 ) {
            System.out.println("O valor do investimento deve ser positivo.");
            return false;
        } else if (valor > getSaldo()) {
            System.out.println("O valor do investimento deve ser menor que seu saldo.");
            return false;
        }

        double juros = valor * 0.05;
        double totalInvestimentos = getInvestimentos() + valor + juros;

        setInvestimentos(totalInvestimentos);
        setSaldo(getSaldo() - valor);
        System.out.println("Investimento realizado com sucesso! " +
                "\nNovo saldo: " + getSaldo()+"\nInvestimentos: "+getInvestimentos());

        return true;
    }

    public boolean retirarInvestimento(double valor){
        if (valor <= 0 ) {
            System.out.println("O valor do investimento deve ser positivo.");
            return false;
        } else if (valor > getInvestimentos()) {
            System.out.println("O valor de retirada deve ser menor que seu investimento.");
            return false;
        }

        setSaldo(getSaldo()+getInvestimentos());
        setInvestimentos(getInvestimentos()-valor);

        System.out.println("A retirada do investimentos foi realizado com sucesso!" +
                " \nNovo saldo: " + getSaldo()+"\nInvestimentos: "+getInvestimentos());
        return true;

    }

    @Override
    public void descricao() {
        System.out.println("Nome titular: "+getTitular()+"\nCPF titular: "+getCpf()+"\nAgência: "+getAgencia()+"\nConta: "+getNumeroConta()
                +"\nSaldo atual: "+getSaldo()+"\nInvestimentos: "+getInvestimentos());
    }


    // Constructors;
    public ContaPoupanca(String titular, String cpf) {
        super(titular, cpf);
    }

    public ContaPoupanca() {
        super();
    }


    // Getters and Setters;
    public double getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(double investimentos) {
        this.investimentos = investimentos;
    }
}
