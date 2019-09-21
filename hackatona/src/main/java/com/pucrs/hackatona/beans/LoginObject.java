package com.pucrs.hackatona.beans;

public class LoginObject {

    private String matricula;
    private boolean isAluno;

    public LoginObject(String matricula, boolean isAluno) {
        this.matricula = matricula;
        this.isAluno = isAluno;
    }
}
