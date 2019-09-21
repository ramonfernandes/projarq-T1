package com.pucrs.hackatona.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucrs.hackatona.enumerator.Curso;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

//@Data
//@NoArgsConstructor
public class Aluno {

    @JsonIgnore
    private UUID id;
    private String matricula;
    private String nome;
    private Curso curso;

    public Aluno(UUID id, String matricula, String nome, Curso curso) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public boolean isName(String compareNome) {
        return nome.equals(compareNome);
    }

    public boolean isCurso(Curso compareCurso) {
        return curso.equals(compareCurso);
    }

    public boolean isMatricula(String compareMatricula) {
        return matricula.equals(compareMatricula);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
