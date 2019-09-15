package com.pucrs.hackatona.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.pucrs.hackatona.enumerator.Curso;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import sun.security.util.Password;

import java.util.UUID;

@Data
@NoArgsConstructor
public class Usuario {

    @JsonIgnore
    private UUID id;
    private String email;
    private String senha;
    private String nome;
    private Curso curso;
    private Boolean aluno;

    public Usuario(String email, String senha, String nome, Curso curso, Boolean aluno) {
        this.id = UUID.randomUUID();
        this.email = email;
        this.senha = senha;
        this.aluno = aluno;
        this.nome = nome;
        this.curso = curso;
    }

    public boolean isName(String compareNome) {
        return nome.equals(compareNome);
    }

    public boolean isEmail(String compareEmail) {
        return nome.equals(compareEmail);
    }

    public boolean isCurso(Curso compareCurso) {
        return curso.equals(compareCurso);
    }

    public boolean isAluno() { return aluno; }

    public boolean isProfessor() { return !aluno; }

    public boolean isLogin(String compareEmail, String compareSenha) { return email.equals(compareEmail) && senha.equals(compareSenha); }


}
