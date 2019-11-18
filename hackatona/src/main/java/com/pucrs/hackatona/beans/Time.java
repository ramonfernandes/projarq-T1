package com.pucrs.hackatona.beans;

import java.util.List;
import java.util.stream.Collectors;

public class Time {


    private int id;

    private static int idAux = 0;
    private String nome;
    private List<UsuarioDTO> alunos;
    private Nota nota;

    private boolean isApproved;

    public Time(String nome, List<UsuarioDTO> alunos) {
        this.id = idAux;
        this.nome = nome;
        this.alunos = alunos;
        this.isApproved = false;
        idAux++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getIdAux() {
        return idAux;
    }

    public static void setIdAux(int idAux) {
        Time.idAux = idAux;
    }

    public List<UsuarioDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<UsuarioDTO> alunos) {
        this.alunos = alunos;
    }

    public List<String> getMatriculas() {
        return alunos.stream()
                .map(UsuarioDTO::getMatricula)
                .collect(Collectors.toList());
    }

    public boolean containsMatricula(String matricula) {
        return getMatriculas().contains(matricula);
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public Time setNota(Nota nota) {
        this.nota = nota;
        return this;
    }

    public Nota getNota() {
        return this.nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
