package com.pucrs.hackatona.dao;

import java.util.List;

public class TimeDao {

    private String nome;
    private int id;
    private boolean isApproved;
    private int funcionamento;
    private int inovacao;
    private int pitch;
    private int processo;

    public TimeDao setUsuarios(List<UsuarioDAO> usuarios) {
        this.usuarios = usuarios;
        return this;
    }

    private List<UsuarioDAO> usuarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getFuncionamento() {
        return funcionamento;
    }

    public void setFuncionamento(int funcionamento) {
        this.funcionamento = funcionamento;
    }

    public int getInovacao() {
        return inovacao;
    }

    public void setInovacao(int inovacao) {
        this.inovacao = inovacao;
    }

    public int getPitch() {
        return pitch;
    }

    public void setPitch(int pitch) {
        this.pitch = pitch;
    }

    public int getProcesso() {
        return processo;
    }

    public void setProcesso(int processo) {
        this.processo = processo;
    }

    public List<UsuarioDAO> getUsuarios() {
        return usuarios;
    }

    public TimeDao(String nome, int id, boolean isApproved, int funcionamento, int inovacao, int pitch, int processo) {
        this.nome = nome;
        this.id = id;
        this.isApproved = isApproved;
        this.funcionamento = funcionamento;
        this.inovacao = inovacao;
        this.pitch = pitch;
        this.processo = processo;
    }

    public int getId() {
        return id;
    }
}
