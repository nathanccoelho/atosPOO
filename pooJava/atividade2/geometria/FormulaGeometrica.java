package pooJava.atividade2.geometria;

public abstract class FormulaGeometrica {
    private double area;

    public abstract double calcularArea();

    // Constructors;
    public FormulaGeometrica(double area) {
        this.area = area;
    }
    public FormulaGeometrica() {
    }

    // Getters and Setters;
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
