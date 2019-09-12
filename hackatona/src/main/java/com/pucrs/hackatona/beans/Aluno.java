package com.pucrs.hackatona.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucrs.hackatona.enumerator.Curso;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Aluno {

    @JsonIgnore
    private UUID id;
    private String nome;
    private Curso curso;

    public Aluno(String nome, Curso curso) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.curso = curso;
    }

    public boolean isName(String compareNome) {
        return nome.equals(compareNome);
    }

    public boolean isCurso(Curso compareCurso) {
        return curso.equals(compareCurso);
    }
}
