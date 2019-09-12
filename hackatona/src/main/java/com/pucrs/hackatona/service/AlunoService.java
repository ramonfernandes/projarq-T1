package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.Aluno;
import com.pucrs.hackatona.dao.AlunoDAO;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    private AlunoDAO dao;

    public List<Aluno> get() {
        return dao.get();
    }

    public List<Aluno> getByNome(List<Aluno> list, String nome) {
        return list
                .stream()
                .filter(aluno -> aluno.isName(nome))
                .collect(Collectors.toList());
    }

    public List<Aluno> getByCurso(List<Aluno> list, String cursoName) throws IllegalArgumentException {
        Curso curso = Curso.valueOf(cursoName);
        return list
                .stream()
                .filter(aluno -> aluno.isCurso(curso))
                .collect(Collectors.toList());
    }
}
