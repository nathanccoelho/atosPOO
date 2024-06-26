package pooJava.desafio.estacionamento;


import pooJava.desafio.veiculo.Veiculo;

import java.time.Duration;
import java.time.LocalTime;

public class Estacionamento {

    private double preco;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    // Chama o método calcular horas e calcula o valor pelo preço escolhido pelo usuário.
    public String calcularValor() {
        double qtdHoras = calcularQtdHoras();
        double valor = qtdHoras * preco;
        return String.format("%.2f", valor);
    }

    // O Duration.beetween é um método para que retorna a diferença de duas variáveis LocalTime.
    // Logo após calcula os minutos e retorna a quantidade de horas definidas pelo usuário.
    public double calcularQtdHoras() {
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long qtdHoras = duracao.toHours();
        long minutosRestantes = duracao.toMinutesPart();

       return qtdHoras + (minutosRestantes / 60.0);
    }

    // Gera um ticke sem uso, fiz só porque achei legal mesmo. Futuramente poderia implementar, mas teria que
    // colocar um atributo ticket e ficaria muita coisa além do que o desafio pede. (E ja estou usando muito mais coisa).
    public void gerarTickt(){
        int numeroRandom = (int) (Math.random()*100)+1;
        System.out.println("O horário de entrada é: "+getHoraEntrada()+", e seu ticket é o: "+numeroRandom);
    }

    // Método sem retorno que recebe um veículo só para agradecer o usuário por estacionar.
    public void textoAgradecimento (Veiculo veiculo){
        System.out.println("Seu "+veiculo.getModelo()+" está estacionado! Obrigado por escolher o South Park. Até logo. :).");
    }

    // Método sem retorno que traz algumas informaçoes como hora de entrada, hora de saída, preço e chama o
    // método "calcularValor()".
    public void textoFinal (){
        System.out.println("Veículo retirado com sucesso! :). \nO horário de entrada foi: "+getHoraEntrada()+
                " horas e o horário de saída: "+getHoraSaida()+" horas.\nPreço por hora é: "+getPreco()+
                "\nPortanto o valor a ser cobrado é: R$"+calcularValor());
    }

    // Constructors;
    public Estacionamento(double preco) {
        this.preco = preco;
    }
    public Estacionamento() {
    }

    // Getters and Setters;
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}
