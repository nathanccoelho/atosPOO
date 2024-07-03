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
        int numeroSecreto = numberRandom();
        int tentativasMaximas = 3;
        int tentativa;

        while (true) {
            tentativa = tentativasMaximas;

            for (int i = 0; i < tentativasMaximas; i++) {
                System.out.println("Para encontrar o número secreto, digite um número: ");
                int numero = scan.nextInt();

                if (numero == numeroSecreto) {
                    System.out.println("Parabéns! Você acertou o número secreto.");
                    System.out.println("Número secreto: " + numeroSecreto);

                } else {
                    tentativa--;
                    System.out.println("Que pena você errou :(... tente novamente. \nTentativas restantes: " + tentativa);
                }

                System.out.println("---------------------------------");
            }

            System.out.println("O número secreto era: " + numeroSecreto + "\nDeseja reiniciar? S/N");
            scan.nextLine();
            String continuar = scan.nextLine();

            if (continuar.equalsIgnoreCase("n") || continuar.equalsIgnoreCase("nao")) {
                System.out.println("Obrigado pelo jogo! Até a próxima.");
                break;
            } else {
                numeroSecreto = numberRandom();
            }
        }

        scan.close();

    }
}
