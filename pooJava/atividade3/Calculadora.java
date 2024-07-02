package pooJava.atividade3;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Calculadora {

    public static double soma(double n1, double n2){
        return n1+n2;
    }
    public static double subtracao(double n1, double n2){
        return n1-n2;
    }
    public static double multiplicacao(double n1, double n2){
        return n1*n2;
    }
    public static double divisao(double n1, double n2){
        return n1/n2;
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner scan = new Scanner(System.in);
        double resultado = 0;

        System.out.println("Digite o primeiro número para a operação: ");
        double numero1 = scan.nextInt();

        System.out.println("Digite o segundo número para a operação: ");
        double numero2 = scan.nextInt();

        scan.nextLine();

        while (true) {
            System.out.println("Escolhar a operação: \n- Soma. \n- Subtração. \n- Multiplicação. \n- Divisão.");
            String operacao = scan.nextLine();
            if (operacao.equalsIgnoreCase("soma")) {
                resultado = soma(numero1, numero2);
                break;
            } else if (operacao.equalsIgnoreCase("subtracao")) {
                resultado = subtracao(numero1, numero2);
                break;
            } else if (operacao.equalsIgnoreCase("multiplicacao")) {
                resultado = multiplicacao(numero1, numero2);
                break;
            } else if (operacao.equalsIgnoreCase("divisao")) {
                resultado = divisao(numero1, numero2);
                break;
            } else {
                System.out.println("Digite uma operação correta!");
                continue;
            }
        }
        System.out.println("O resultado da sua operação é: "+resultado+".");
        scan.close();
    }

}
