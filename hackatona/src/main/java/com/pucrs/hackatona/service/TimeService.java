package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.Usuario;
import com.pucrs.hackatona.beans.Time;
import com.pucrs.hackatona.dao.TimeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeService {

    @Autowired
    private TimeDao timeDao;

    public boolean validateTime(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios)
            for (Usuario usuarioToCompare : usuarios)
                if (!usuario.getCurso().equals(usuarioToCompare.getCurso()))
                    return true;

        return false;
    }

    public void createTeam(List<Usuario> usuarios) {
        timeDao.createTeam(usuarios);
    }

    public List<Time> getAll() {
        return timeDao.getAll();
    }

    public Time getTeamById(Integer id) {
        return timeDao.getAll().stream()
                .filter(time -> time.getId() == id)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public void updateTime(int id, Time time) {
        if (time.getId() == id) {
            Time oldTime = getTeamById(id);
            timeDao.updateTime(oldTime, time);
        }
    }

    public List<Time> getByMatriculas(List<String> matriculas){
        List<Time> times = getAll();
        for (String matricula : matriculas) {
            times = times.stream()
                    .filter(time -> time.containsMatricula(matricula))
                    .collect(Collectors.toList());
        }
        return times;
    }

    public void updateNota(Time time, Nota nota) {
        timeDao.updateTime(time, time.setNota(nota));
    }
}
