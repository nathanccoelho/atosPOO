package pooJava.desafio;

import pooJava.desafio.estacionamento.Estacionamento;
import pooJava.desafio.veiculo.Carro;
import pooJava.desafio.veiculo.Moto;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        // Instanciando classes que vou precisar.
        Scanner scan = new Scanner(System.in);
        Carro carro = new Carro();
        Moto moto = new Moto();
        Estacionamento park = new Estacionamento();

        // Inicializando variáveis inteiras para o menu de opção.
        int opcao = 1;
        int opcaoVeiculo= 1;

        // Inicializando o while com o menu.
        while (opcao != 0){

            // Menu com print básico.
            System.out.println("-------------------------------------------------");
            System.out.println("Olá seja bem-vindo ao estacionamento SOUTH PARK!");
            System.out.println("Selecione a opção desejada: \n1- Entrada de veículo. \n2- Saída de veículo. \n0- Encerrar o programa.");

            // Try para capturar tudo que não for inteiro para a variável inteiro.
            try{
                opcao = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Opção inválida! Digite um número inteiro.");
                scan.nextLine();
                continue;
            }

            // Verifico se o usuário ja cadastrou algum veículo. Se o estacionamento não tiver um preço,
            // significa que o usuário não cadastrou um veículo.
            if (opcao == 2 && park.getPreco()==0){
                System.out.println("Para retirar um veículo primeiro precisa estacionar! Digite a opção '1'.");
                continue;
            }

            // Caso digitar a opção 1, ele cadastrará um veículo.
           else if(opcao == 1){

                    // Menu para coletar as informações necessárias.
                   System.out.println("Digite a placa do seu veículo: ");
                   String placa = scan.nextLine();
                   System.out.println("Digite a marca do seu veículo: ");
                   String marca = scan.nextLine();
                   System.out.println("Digite o modelo do seu veículo: ");
                   String modelo = scan.nextLine();


                   // While para capturar alguma excessão de LocalTime, caso o usuário não digite um formato hh:mm.
                // Repetira até digitar corretamente.
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


                // Menu para setar o preço, se for carro é 15 e mota 09 reais.
               System.out.println("Escolha o tipo do veículo: \n1- Carro (Valor por hora R$15,00)."+
                       "\n2- Moto (Valor por hora R$09,00). \n0- Encerrar o programa. ");

               // Um try para capturar excessão caso o usuário não digite um número.
               try {
                   opcaoVeiculo = scan.nextInt();
                   scan.nextLine();
               } catch (InputMismatchException e){
                   System.out.println("Opção inválida! Digite um número inteiro.");
                   scan.nextLine();
                   continue;
               }

               // Se a opção for a 1 ele seta todas as informações das variáveis para o carro.
               if(opcaoVeiculo == 1) {
                   park.setPreco(15.0);
                   carro.setPlaca(placa);
                   carro.setMarca(marca);
                   carro.setModelo(modelo);
                   park.textoAgradecimento(carro);
                   carro.toDescricao();
                   park.gerarTickt();
               }
               // Se a opção for a 2 mesma coisa para moto.
               else if(opcaoVeiculo == 2) {
                   park.setPreco(9.0);
                   moto.setPlaca(placa);
                   moto.setMarca(marca);
                   moto.setModelo(modelo);
                   park.textoAgradecimento(moto);
                   moto.toDescricao();
                   park.gerarTickt();

               }

               // caso ele digite 0 ou outro número o programa encerrará.
               else{
                   System.out.println("Programa encerrado com sucesso :).");
                   opcao = 0;
                   scan.close();
               }
           }

           // Usuário só entrará nessa opção caso tenha preenchido a primeira.
           else if(opcao == 2){

               // While somente para verificar se a placa é verdedadeira.
               while(true){
                   System.out.println("Para retirar o seu veículo, digite a placa: ");
                   String placa = scan.nextLine();

                   if (!placa.equals(carro.getPlaca()) && !placa.equals(moto.getPlaca())) {
                       System.out.println("A placa digitada está errada! :(");
                   } else {
                       break;
                   }
               }

                // While para capturar alguma excessão de LocalTime, caso o usuário não digite um formato hh:mm.
                // Repetira até digitar corretamente.
                // Porém diferente da entrada horaEntrada, aqui verifica se a horaSaida é menor que a horaEntrada.
                // E se essa condição for satisfeita o loop retornará até o usuário digitar um horário após o de entrada.
               while(true){
                   try{
                       System.out.println("Digite a hora de sáida (use o formato HH:mm): ");
                       String inputHora = scan.nextLine();
                       LocalTime horaSaida = LocalTime.parse(inputHora);
                       if(horaSaida.isBefore(park.getHoraEntrada())) {
                            System.out.println("O horario de sáida não pode ser menor que o horário de entrada.");
                            continue;
                       }

                       park.setHoraSaida(horaSaida);

                       break;
                   } catch(DateTimeParseException e) {
                       System.out.println("Formato inválido! Certifique-se de usar o formato HH:mm.");

                   }
               }

                // Pra finalizar tem um método para calcular automáticamente o valor a ser pago pelas informações
                // de horário definidas pelo usuário. E retorna um texto de despedida.
               park.textoFinal();
               System.out.println("-------------------------------------------------");
               System.out.println("Volte logo :). Obrigado.");
               scan.close();
               break;

           }
            // caso ele digite 0 ou outro número o programa encerrará.
           else{
               System.out.println("Programa encerrado com sucesso :).");
               scan.close();
           }
        }

    }
}
