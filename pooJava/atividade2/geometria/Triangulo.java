package pooJava.atividade2.geometria;

public class Triangulo extends FormulaGeometrica {
    private double base;
    private double altura;


    @Override
    public double calcularArea() {
        double area = Math.round(((this.getBase()*this.getAltura())/2)*100)/100.0;
        setArea(area);
        return area;
    }


    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    public Triangulo() {
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

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
