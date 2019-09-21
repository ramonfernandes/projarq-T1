package com.pucrs.hackatona.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;
import java.util.stream.Collectors;

public class Time {

    @JsonIgnore
    private int id;
    @JsonIgnore
    private static int idAux = 0;
    private List<Usuario> usuarios;
    @JsonIgnore
    private Nota nota;
    @JsonIgnore
    private boolean isApproved;

    public Time(List<Usuario> usuarios) {
        this.id = idAux;
        this.usuarios = usuarios;
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

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<String> getMatriculas() {
        return usuarios.stream()
                .map(Usuario::getMatricula)
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
}
