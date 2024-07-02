package pooJava.atividade3;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ImparOrPar {

    public static String verificarImparOrPar(int numero){
        if(numero %2 == 0){
            return "O número "+numero+" é par!";
        } else {
            return "O número "+numero+" é ímpar!";
        }
    }
    public static void main (String[] args){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um número para saber se é ímpar ou par: ");
        int numero = scan.nextInt();

        String resultado = verificarImparOrPar(numero);
        System.out.println(resultado);

        scan.close();

    }
}
