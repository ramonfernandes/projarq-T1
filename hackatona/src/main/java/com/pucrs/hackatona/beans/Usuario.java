package com.pucrs.hackatona.beans;

import com.pucrs.hackatona.enumerator.Curso;

public class Usuario {

    private String senha;
    private String matricula;
    private String nome;
    private Curso curso;
    private Boolean isAluno;

    public Usuario(String matricula, String senha, String nome, Curso curso, Boolean isAluno) {
        this.senha = senha;
        this.isAluno = isAluno;
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAluno() {
        return isAluno;
    }

    public void setIsAluno(Boolean isAluno) {
        this.isAluno = isAluno;
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

    public boolean getIsAluno() {
        return isAluno;
    }

    public boolean isProfessor() {
        return !isAluno;
    }

    public boolean isLogin(String compareMatricula, String compareSenha) {
        return matricula.equals(compareMatricula)
                && senha.equals(compareSenha);
    }

    public boolean isMatricula(String compareMatricula) {
        return matricula.equals(compareMatricula);
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
