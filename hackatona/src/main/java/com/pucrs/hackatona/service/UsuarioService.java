package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.Usuario;
import com.pucrs.hackatona.dao.UsuarioDAO;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDAO dao;

    public List<Usuario> get() {
        return dao.get();
    }

    public List<Usuario> getByNome(List<Usuario> list, String nome) {
        return list
                .stream()
                .filter(usuario -> usuario.isName(nome))
                .collect(Collectors.toList());
    }

    public List<Usuario> getByCurso(List<Usuario> list, String cursoName) throws IllegalArgumentException {
        Curso curso = Curso.valueOf(cursoName);
        return list
                .stream()
                .filter(usuario -> usuario.isCurso(curso))
                .collect(Collectors.toList());
    }
}
