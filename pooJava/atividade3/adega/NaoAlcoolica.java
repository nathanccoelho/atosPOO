package pooJava.atividade3.adega;

public class NaoAlcoolica extends Bebida{

    private boolean contemAcucar;



    @Override
    public void descricao() {
        System.out.println("Bebida não alcoólica: "+getNome()+"\nMl: "+getMl()+"\nPreço: "+getPreco()+"\nContém açucar: "+isContemAcucar());
    }


    // Constructors;
    public NaoAlcoolica(double preco, int ml, String nome) {
        super(preco, ml, nome);
    }

    public NaoAlcoolica(double preco, int ml, String nome, boolean contemAcucar) {
        super(preco, ml, nome);
        this.contemAcucar = contemAcucar;
    }

    public NaoAlcoolica() {
        super();
    }


    // Getters and Setters
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

    public boolean isContemAcucar() {
        return contemAcucar;
    }

    public void setContemAcucar(boolean contemAcucar) {
        this.contemAcucar = contemAcucar;
    }
}
