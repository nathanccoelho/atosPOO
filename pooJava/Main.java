package pooJava;


import pooJava.atividade2.geometria.Circulo;
import pooJava.atividade2.geometria.Retangulo;
import pooJava.atividade2.geometria.Triangulo;
import pooJava.atividades1.Contatos;

public class Main {
    public static void main (String[] args){

        /* Aluno nathan = new Aluno("Nathan", "123456", new double[]{8.6, 7.5, 9.8}, "1999-10-23");
        nathan.toStringAluno(); */

        /*Contatos contato = new Contatos("Nathan", "(11) 96322-5426", "nathancoelho.job@gmail.com");
        contato.toStringContatos();*/

        Retangulo retangulo = new Retangulo(8.8,8.3);
        Circulo circulo = new Circulo(5);
        Triangulo triangulo = new Triangulo(8.7,8.7);

        System.out.println( circulo.calcularArea());
        System.out.println( retangulo.calcularArea());
        System.out.println( triangulo.calcularArea());


    }
}
