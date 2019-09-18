package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.Pessoa;
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

    public List<Pessoa> get() {
        return dao.get();
    }

    public List<Pessoa> getByNome(List<Pessoa> list, String nome) {
        return list
                .stream()
                .filter(aluno -> aluno.isName(nome))
                .collect(Collectors.toList());
    }

    public List<Pessoa> getByCurso(List<Pessoa> list, String cursoName) throws IllegalArgumentException {
        Curso curso = Curso.valueOf(cursoName);
        return list
                .stream()
                .filter(aluno -> aluno.isCurso(curso))
                .collect(Collectors.toList());
    }

    public List<Pessoa> getByMatricula(List<Pessoa> list, String matricula) {
        return list
                .stream()
                .filter(aluno -> aluno.isMatricula(matricula))
                .collect(Collectors.toList());
    }

    public List<Pessoa> getByPapel(List<Pessoa> list, boolean isProfessor) {
        return list
                .stream()
                .filter(aluno -> aluno.isProfessor() == isProfessor)
                .collect(Collectors.toList());
    }

}
