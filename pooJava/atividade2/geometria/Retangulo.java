package pooJava.atividade2.geometria;

public class Retangulo extends FormulaGeometrica{

    private double altura;
    private double largura;

    @Override
    public double calcularArea() {
        double area = Math.round(this.getAltura()*this.getLargura()*100)/100.0;
        setArea(area);
        return area;
    }

    // Constructors;
    public Retangulo(double altura, double largura) {
        this.altura = altura;
        this.largura = largura;
    }


    public Retangulo() {
        super();
    }

    // Getters and Setters;
    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public void setArea(double area) {
        super.setArea(area);
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }
}
