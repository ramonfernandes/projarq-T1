package com.pucrs.hackatona.beans;

import java.util.List;

public class Time {

    private int id;
    private static int idAux = 0;
    List<Aluno> alunos;
    private boolean isApproved;

    public Time(List<Aluno> alunos) {
        this.id = idAux;
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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }
}
