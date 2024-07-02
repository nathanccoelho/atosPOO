package pooJava.atividade3;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class NumeroSecreto {
    public static int numberRandom(){
        int numeroLimite = 10;
        return (int) (Math.random()*numeroLimite)+1;
    }

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));

        Scanner scan = new Scanner(System.in);
        int tentativa = 2;
        int numeroSecreto = numberRandom();



        for(int i = 0; i <3; i++) {
            System.out.println("Para encontrar o número secreto, digite um número: ");
            int numero = scan.nextInt();

            if (numero == numeroSecreto) {
                System.out.println("Parabéns! Você acertou o número secreto.");
                System.exit(0);
            } else {
                System.out.println("Que pena você errou :(... tente novamente. \nTentativas restantes: "+tentativa);
                tentativa --;
            }
        }

        scan.close();

    }
}
