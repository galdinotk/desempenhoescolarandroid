package com.example.desempenhoescolarapp;

public class Horario {
    private String turma;
    private String horario1;
    private String horario2;
    private String horario3;
    private String horario4;
    private String horario5;

    public Horario () {
        this.turma = "";
        this.horario1 = "";
        this.horario2 = "";
        this.horario3 = "";
        this.horario4 = "";
        this.horario5 = "";
    }

    public Horario (String t, String h1, String h2, String h3, String h4, String h5) {
        this.turma = t;
        this.horario1 = h1;
        this.horario2 = h2;
        this.horario3 = h3;
        this.horario4 = h4;
        this.horario5 = h5;
    }

    public String getTurma() {
        return turma;
    }

    public String getHorario1() {
        return horario1;
    }

    public String getHorario2() {
        return horario2;
    }

    public String getHorario3() {
        return horario3;
    }

    public String getHorario4() {
        return horario4;
    }

    public String getHorario5() {
        return horario5;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setHorario1(String horario1) {
        this.horario1 = horario1;
    }

    public void setHorario2(String horario2) {
        this.horario2 = horario2;
    }

    public void setHorario3(String horario3) {
        this.horario3 = horario3;
    }

    public void setHorario4(String horario4) {
        this.horario4 = horario4;
    }

    public void setHorario5(String horario5) {
        this.horario5 = horario5;
    }
}
