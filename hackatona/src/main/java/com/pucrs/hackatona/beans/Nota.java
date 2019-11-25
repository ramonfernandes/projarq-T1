package com.pucrs.hackatona.beans;

public class Nota {

    private int funcionamento;
    private int inovacao;
    private int pitch;
    private int processo;
    private int time;
    private int timeId;

    public Nota() {
    }

    public Nota(int funcionamento, int inovacao, int pitch, int processo, int time, int timeId) {
        this.funcionamento = funcionamento;
        this.inovacao = inovacao;
        this.pitch = pitch;
        this.processo = processo;
        this.time = time;
        this.timeId = timeId;
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

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getNotaTotal() {
        return time + processo + pitch + inovacao + funcionamento;
    }
}
