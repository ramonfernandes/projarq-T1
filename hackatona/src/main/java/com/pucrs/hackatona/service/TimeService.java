package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.Aluno;
import com.pucrs.hackatona.beans.Time;
import com.pucrs.hackatona.dao.TimeDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private TimeDao timeDao;

    private boolean validateTeam(List<Aluno> alunos) {
        for (Aluno aluno : alunos)
            for (Aluno alunoToCompare : alunos)
                if (!aluno.getCurso().equals(alunoToCompare.getCurso()))
                    return true;

        return false;
    }

    public boolean createTeam(List<Aluno> alunos) {
        if (validateTeam(alunos)) {
            timeDao.createTeam(alunos);
            return true;
        }
        return false;
    }

    public List<Time> getAll() {
        return timeDao.getAll();
    }
}
