package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Aluno;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoDAO {

    private List<Aluno> alunoList;

    public AlunoDAO() {
        this.alunoList = new ArrayList<Aluno>(){{
            add(new Aluno("Ramon", Curso.ES));
            add(new Aluno("João", Curso.ES));
            add(new Aluno("Pedro", Curso.CC));
            add(new Aluno("Matheus", Curso.CC));
            add(new Aluno("Judas", Curso.EC));
            add(new Aluno("José", Curso.EC));
            add(new Aluno("Paulo", Curso.SI));
            add(new Aluno("Maria", Curso.SI));
        }};
    }

    public List<Aluno> get() {
        return alunoList;
    }
}
