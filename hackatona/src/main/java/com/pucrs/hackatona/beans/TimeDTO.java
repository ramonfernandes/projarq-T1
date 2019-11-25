package com.pucrs.hackatona.beans;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class TimeDTO {


    private int id;

    private String nome;
    private List<UsuarioDTO> alunos;
    private Nota nota;

    private boolean isApproved;

    public TimeDTO() {
    }

    public int getId() {
        return id;
    }

    public TimeDTO(String nome, List<UsuarioDTO> alunos, int id, Nota nota) {
        this.nome = nome;
        this.alunos = alunos;
        this.isApproved = false;
        this.id = id;
        this.nota = nota;
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

    public TimeDTO setNota(Nota nota) {
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
