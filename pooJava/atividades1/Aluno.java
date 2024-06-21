package pooJava.atividades1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Aluno {
    private String nome;
    private String matricula;
    private double[] notas;
    private LocalDate dataDeNascimento;


    public void toStringAluno(){
        System.out.println("Nome: "+getNome());
        System.out.println("Matricúla: "+getMatricula());
        System.out.println("Notas: "+Arrays.toString(getNotas()));
        System.out.println("Data de nascimento: "+getDataDeNascimento());
        System.out.println("Média: "+ String.format("%.2f", media()));

    }

    public double media(){
        double soma=0;
        for(double nota: notas){
            soma+=nota;
        }
        return soma/notas.length;
    }


    // Constructors;
    public Aluno(String nome, String matricula, double[] notas, String dataDeNascimento) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = notas;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dataDeNascimento = LocalDate.parse(dataDeNascimento, formatter);
    }
    public Aluno() {
    }

    // Getters and Setters;
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public double[] getNotas() {
        return notas;
    }

    public void setNotas(double[] notas) {
        this.notas = notas;
    }
}
