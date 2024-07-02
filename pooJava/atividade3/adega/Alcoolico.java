package pooJava.atividade3.adega;

public class Alcoolico extends Bebida{

    private double teorAlcoolico;


    @Override
    public void descricao() {
        System.out.println("Bebida alcoólica: "+getNome()+"\nMl: "+getMl()+"\nPreço: "+getPreco()+"\nTeor alcoolico: "+getTeorAlcoolico());

    }


    // Constructor;
    public Alcoolico(double preco, int ml, String nome, double teorAlcoolico) {
        super(preco, ml, nome);
        this.teorAlcoolico = teorAlcoolico;
    }
    public Alcoolico(double preco, int ml, String nome) {
        super(preco, ml, nome);
    }
    public Alcoolico() {
        super();
    }


    // Getters and Setters;
    @Override
    public double getPreco() {
        return super.getPreco();
    }

    @Override
    public void setPreco(double preco) {
        super.setPreco(preco);
    }

    @Override
    public int getMl() {
        return super.getMl();
    }

    @Override
    public void setMl(int ml) {
        super.setMl(ml);
    }

    @Override
    public String getNome() {
        return super.getNome();
    }

    @Override
    public void setNome(String nome) {
        super.setNome(nome);
    }

    public double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }
}
