package pooJava.atividade3.adega;

public abstract class Bebida {
    private double preco;
    private int ml;
    private String nome;


    public abstract void descricao();



    // Constructors;
    public Bebida(double preco, int ml, String nome) {
        this.preco = preco;
        this.ml = ml;
        this.nome = nome;
    }
    public Bebida() {
    }

    // Getters and Setters;
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
