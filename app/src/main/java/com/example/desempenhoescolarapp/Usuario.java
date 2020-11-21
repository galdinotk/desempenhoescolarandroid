package com.example.desempenhoescolarapp;

import java.util.ArrayList;

public class Usuario {
    private String email = null;
    private String nome = null;
    private String senha = null;
    private String tipo = null;
    private String cargo = null;
    private ArrayList<String> turmas = null;
    private ArrayList<String> disciplinas = null;
    private String turma = null;
    private Boletim boletim = null;


    public Usuario() {
        this.email = "";
        this.nome = "";
        this.senha = "";
        this.tipo = "";
        this.cargo = "";
        this.turmas = new ArrayList<>();
        this.disciplinas = new ArrayList<>();
        this.turma = "";
        boletim = new Boletim();
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getCargo() {
        return cargo;
    }

    public String getTipo() {
        return tipo;
    }

    public ArrayList<String> getTurmas() {
        return turmas;
    }

    public ArrayList<String> getDisciplinas() {
        return disciplinas;
    }

    public String getTurma() {
        return turma;
    }

    public Boletim getBoletim() {
        return boletim;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setTurmas(ArrayList<String> turmas) {
        this.turmas = turmas;
    }

    public void setDisciplinas(ArrayList<String> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public void setBoletim(Boletim boletim) {
        this.boletim = boletim;
    }
}
