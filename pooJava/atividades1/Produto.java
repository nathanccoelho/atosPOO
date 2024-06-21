package pooJava.atividades1;

public class Produto {

    private String nome;
    private int codigo;
    private int quantidadeEmEstoque;


    public void removeProduto(){

    }

    public void addProduto(){

    }


    // Constructors;
    public Produto(String nome, int codigo, int quantidadeEmEstoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto() {

    }

    // Getters and Setters;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
