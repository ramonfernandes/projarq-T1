package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Aluno;
import com.pucrs.hackatona.beans.Time;

import java.util.ArrayList;
import java.util.List;

public class TimeDao {

    List<Time> times = new ArrayList<Time>();

    public void createTeam(List<Aluno> alunos) {
        times.add(new Time(alunos));
    }

    public List<Time> getAll() {
        return times;
    }
}
