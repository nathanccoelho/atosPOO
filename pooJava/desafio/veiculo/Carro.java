package pooJava.desafio.veiculo;

public class Carro extends Veiculo{

    @Override
    public void toDescricao() {
        super.toDescricao();
    }


    // Contructors;
    public Carro(String placa, String modelo, String marca) {
        super(placa, modelo, marca);
    }

    public Carro() {
        super();
    }


    // Getters and Setters;
    @Override
    public String getPlaca() {
        return super.getPlaca();
    }

    @Override
    public void setPlaca(String placa) {
        super.setPlaca(placa);
    }

    @Override
    public String getModelo() {
        return super.getModelo();
    }

    @Override
    public void setModelo(String modelo) {
        super.setModelo(modelo);
    }

    @Override
    public String getMarca() {
        return super.getMarca();
    }

    @Override
    public void setMarca(String marca) {
        super.setMarca(marca);
    }
}
