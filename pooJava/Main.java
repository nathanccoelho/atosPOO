package pooJava;

import pooJava.desafio.estacionamento.Estacionamento;
import pooJava.desafio.veiculo.Carro;
import pooJava.desafio.veiculo.Moto;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        Carro carro = new Carro();
        Moto moto = new Moto();
        Estacionamento park = new Estacionamento();

        int opcao = 1;
        int opcaoVeiculo= 1;


        while (opcao != 0){
            System.out.println("-------------------------------------------------");
            System.out.println("Olá seja bem-vindo ao estacionamento SOUTH PARK!");
            System.out.println("Selecione a opção desejada: \n1- Entrada de veículo. \n2- Saída de veículo. \n0- Encerrar o programa.");

            try{
                opcao = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Opção inválida! Digite um número inteiro.");
                scan.nextLine();
                continue;
            }

            if (opcao == 2 && park.getPreco()==0){
                System.out.println("Para retirar um veículo primeiro precisa estacionar! Digite a opção '1'.");
                continue;
            }
           else if(opcao == 1){

                   System.out.println("Digite a placa do seu veículo: ");
                   String placa = scan.nextLine();
                   System.out.println("Digite a marca do seu veículo: ");
                   String marca = scan.nextLine();
                   System.out.println("Digite o modelo do seu veículo: ");
                   String modelo = scan.nextLine();

               while(true){
                   System.out.println("Digite a hora atual (use formato HH:mm): ");
                   String inputHora = scan.nextLine();


                   try {
                       LocalTime horaAtual = LocalTime.parse(inputHora);
                       park.setHoraEntrada(horaAtual);
                       break;
                   } catch (DateTimeParseException e) {
                       System.out.println("Formato inválido! Certifique-se de usar o formato HH:mm.");
                   }
               }



               System.out.println("Escolha o tipo do veículo: \n1- Carro (Valor por hora R$15,00)."+
                       "\n2- Moto (Valor por hora R$09,00). \n0- Encerrar o programa. ");

               try {
                   opcaoVeiculo = scan.nextInt();
                   scan.nextLine();
               } catch (InputMismatchException e){
                   System.out.println("Opção inválida! Digite um número inteiro.");
                   scan.nextLine();
                   continue;
               }

               if(opcaoVeiculo == 1) {
                   park.setPreco(15.0);
                   carro.setPlaca(placa);
                   carro.setMarca(marca);
                   carro.setModelo(modelo);
                   park.textoAgradecimento(carro);
                   carro.toDescricao();
                   park.gerarTickt();
               }
               else if(opcaoVeiculo == 2) {
                   park.setPreco(9.0);
                   moto.setPlaca(placa);
                   moto.setMarca(marca);
                   moto.setModelo(modelo);
                   park.textoAgradecimento(moto);
                   moto.toDescricao();
                   park.gerarTickt();

               }
               else{
                   System.out.println("Programa encerrado com sucesso :).");
                   opcao = 0;
                   scan.close();
               }
           }

           else if(opcao == 2){

               while(true){
                   System.out.println("Para retirar o seu veículo, digite a placa: ");
                   String placa = scan.nextLine();

                   if (!placa.equals(carro.getPlaca()) && !placa.equals(moto.getPlaca())) {
                       System.out.println("A placa digitada está errada! :(");
                   } else {
                       break;
                   }
               }

               while(true){
                   try{
                       System.out.println("Digite a hora de sáida (use o formato HH:mm): ");
                       String inputHora = scan.nextLine();
                       LocalTime horaSaida = LocalTime.parse(inputHora);
                       park.setHoraSaida(horaSaida);
                       break;
                   } catch(DateTimeParseException e) {
                       System.out.println("Formato inválido! Certifique-se de usar o formato HH:mm.");

                   }
               }


               park.textoFinal();
               System.out.println("-------------------------------------------------");
               System.out.println("Volte logo :). Obrigado.");
               scan.close();
               break;

           }
           else{
               System.out.println("Programa encerrado com sucesso :).");
               scan.close();
           }
        }

    }
}
