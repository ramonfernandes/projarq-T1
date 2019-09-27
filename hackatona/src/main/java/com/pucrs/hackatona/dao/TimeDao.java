package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.Time;
import com.pucrs.hackatona.beans.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeDao {

    List<Time> times = new ArrayList<Time>();

    public void createTeam(Time time) {
        times.add(time);
    }

    public List<Time> getAll() {
        return times;
    }

    public void updateTime(Time oldTime, Time newTime) {
        times.remove(oldTime);
        times.add(newTime);
    }
    public void updateNota(Time time, Nota nota) {
        for(Time t : times){
            if (t.getId() == time.getId()){
                t.setNota(nota);
            }
        }

    }

}
