package pooJava.atividade2;

public class Calculadora {
    private double resultado;

    public double somar(double x, double y){
        double resultado = x + y;
        setResultado(resultado);
        return resultado;
    }

    public double subtrair(double x, double y){
        double resultado = x - y;
        setResultado(resultado);
        return resultado;

    }    public double multiplicar(double x, double y){
        double resultado = x * y;
        setResultado(resultado);
        return resultado;

    }    public double dividir(double x, double y){
        double resultado = x / y;
        setResultado(resultado);
        return resultado;
    }


    // Constructors;
    public Calculadora(double resultado) {
        this.resultado = resultado;
    }
    public Calculadora() {
    }

    // Getters and Setters;
    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}
