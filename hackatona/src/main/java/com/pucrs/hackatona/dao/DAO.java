package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.Time;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DAO {


    public void createTeam(Time time) {
    }

    public List<Time> getAll() {
        return new ArrayList<>();
    }

    public void updateTime(Time oldTime, Time newTime) {
    }

    public void updateNota(Time time, Nota nota) {
    }

    public List<UsuarioDAO> getUsuario() {
        return new ArrayList<UsuarioDAO>();
    }

    public void create(UsuarioDAO usuario) {
    }

}

