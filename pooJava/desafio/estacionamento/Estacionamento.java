package pooJava.desafio.estacionamento;


import pooJava.desafio.veiculo.Veiculo;

import java.time.Duration;
import java.time.LocalTime;

public class Estacionamento {

    private double preco;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;

    public String calcularValor() {
        double qtdHoras = calcularQtdHoras();
        double valor = qtdHoras * preco;
        return String.format("%.2f", valor);
    }

    public double calcularQtdHoras() {
        Duration duracao = Duration.between(horaEntrada, horaSaida);
        long qtdHoras = duracao.toHours();
        long minutosRestantes = duracao.toMinutesPart();

       return qtdHoras + (minutosRestantes / 60.0);
    }

    public void gerarTickt(){
        int numeroRandom = (int) (Math.random()*100)+1;
        System.out.println("O horário de entrada é: "+getHoraEntrada()+", e seu ticket é o: "+numeroRandom);
    }

    public void textoAgradecimento (Veiculo veiculo){
        System.out.println("Seu "+veiculo.getModelo()+" está estacionado! Obrigado por escolher o South Park. Até logo. :).");
    }

    public void textoFinal (){
        System.out.println("Veículo retirado com sucesso! :). \nO horário de entrada foi: "+getHoraEntrada()+" horas e o horário de saída: "+getHoraSaida()+" horas.\nPreço por hora é: "+getPreco()+"\nPortanto o valor a ser cobrado é: R$"+calcularValor());
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
