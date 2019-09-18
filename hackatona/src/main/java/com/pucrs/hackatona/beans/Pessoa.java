package com.pucrs.hackatona.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucrs.hackatona.enumerator.Curso;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Pessoa {

    @JsonIgnore
    private UUID id;
    private String nome;
    private Curso curso;
    private String matricula;
    private boolean isProfessor;

    public Pessoa(String nome, Curso curso, String matricula, boolean isProfessor) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.curso = curso;
        this.matricula = matricula;
        this.isProfessor = isProfessor;
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

    public boolean isProfessor() {
        return isProfessor;
    }

}
