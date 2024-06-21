package pooJava.atividade2;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Compromisso {

    private LocalDate data;
    private LocalTime horario;
    private String descricao;


    public abstract void criar();
    public abstract void editar();
    public abstract void excluir();

    // Constructors;
    public Compromisso(LocalDate data, LocalTime horario, String descricao) {
        this.data = data;
        this.horario = horario;
        this.descricao = descricao;
    }
    public Compromisso() {
    }

    // Getters and Setters;
    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public void setHorario(LocalTime horario) {
        this.horario = horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
