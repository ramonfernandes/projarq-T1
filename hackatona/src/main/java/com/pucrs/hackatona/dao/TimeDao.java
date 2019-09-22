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

    public void createTeam(List<Usuario> usuarios) {
        times.add(new Time(usuarios));
    }

    public List<Time> getAll() {
        return times;
    }

    public void updateTime(Time oldTime, Time newTime) {
        times.remove(oldTime);
        times.add(newTime);
    }
}
