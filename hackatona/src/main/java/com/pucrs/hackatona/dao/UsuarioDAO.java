package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.UsuarioDTO;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.stereotype.Service;

import java.util.List;

public class UsuarioDAO {

    private String senha;
    private String matricula;
    private String nome;
    private Curso curso;
    private Boolean isAluno;

    public UsuarioDAO(Builder builder) {
        this.senha = builder.senha;
        this.isAluno = builder.isAluno;
        this.matricula = builder.matricula;
        this.nome = builder.nome;
        this.curso = builder.curso;
    }

    public static class Builder {

        private String senha;
        private String matricula;
        private String nome;
        private Curso curso;
        private Boolean isAluno;

        public Builder senha(String senha) {
            this.senha = senha;
            return this;
        }

        public Builder matricula(String matricula) {
            this.matricula = matricula;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder curso(Curso curso) {
            this.curso = curso;
            return this;
        }

        public Builder isAluno(Boolean isAluno) {
            this.isAluno = isAluno;
            return this;
        }

        public UsuarioDAO build() {
            return new UsuarioDAO(this);
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

    public Boolean getAluno() {
        return isAluno;
    }

    public void setAluno(Boolean aluno) {
        isAluno = aluno;
    }
}
