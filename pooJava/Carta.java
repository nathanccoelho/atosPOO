package pooJava;

public class Carta {

    private String naipe;
    private String valor;

    public void toStringCarta(){
        System.out.println("Naípe: "+getNaipe());
        System.out.println("Valor: "+getValor());

    }

    // Constructors;
    public Carta(String naipe, String valor) {
        this.naipe = naipe;
        this.valor = valor;
    }

    public Carta() {

    }

    // Getters and Setters;
    public String getNaipe() {
        return naipe;
    }

    public void setNaipe(String naipe) {
        this.naipe = naipe;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
