package com.pucrs.hackatona.dao;

import java.util.List;
import java.util.UUID;

public class TimeDao {

    private String nome;
    private int id;
    private boolean isApproved;
    private int funcionamento;
    private int inovacao;
    private int pitch;
    private int processo;
    private List<UsuarioDAO> usuarios;

    public TimeDao(String nome, boolean approved, int id) {
        this.nome = nome;
        this.isApproved = isApproved;
        this.id = id;
    }

    public TimeDao setUsuarios(List<UsuarioDAO> usuarios) {
        this.usuarios = usuarios;
        return this;
    };

    public TimeDao(int id, String nome, boolean isApproved, int funcionamento, int inovacao, int pitch, int processo) {
        this.nome = nome;
        this.isApproved = isApproved;
        this.funcionamento = funcionamento;
        this.inovacao = inovacao;
        this.pitch = pitch;
        this.processo = processo;
        this.id = id;
    }

    public String getNome() {
        return nome;
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
