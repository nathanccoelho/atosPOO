package pooJava.atividade2.geometria;

public class Circulo extends FormulaGeometrica {

    private double raio;


    @Override
    public double calcularArea() {
        double area = Math.round(Math.PI * Math.pow(this.getRaio(), 2)*100)/100.0;

        setArea(area);
        return area;
    }


    // Constructors
    public Circulo(double raio) {
        this.raio = raio;
    }
    public Circulo() {
    }


    // Getters and Setters;
    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public void setArea(double area) {
        super.setArea(area);
    }
}
