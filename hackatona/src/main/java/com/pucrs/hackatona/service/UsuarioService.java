package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.LoginObject;
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

    public LoginObject confirmLogin(String matricula, String senha) throws IllegalArgumentException {
        for (Usuario u : get()) {
            if (u.isLogin(matricula, senha)) {
                return new LoginObject(matricula, u.getIsAluno());
            }
        }
        throw new IllegalArgumentException();
    }

    public List<Usuario> getAlunos(List<Usuario> list) {
        return list
                .stream()
                .filter(Usuario::getIsAluno)
                .collect(Collectors.toList());
    }

    public List<Usuario> getProfessores(List<Usuario> list) {
        return list
                .stream()
                .filter(Usuario::isProfessor)
                .collect(Collectors.toList());
    }

    public List<Usuario> getByMatricula(List<Usuario> list, String matricula) {
        return list
                .stream()
                .filter(usuario -> usuario.isMatricula(matricula))
                .collect(Collectors.toList());
    }

    public boolean existUsuario(String matricula) {
        return getByMatricula(get(), matricula).size() > 0;
    }

    public boolean allUsuariosExist(List<Usuario> usuarios) {
        for (Usuario usuario : usuarios) {
            if (!existUsuario(usuario.getMatricula()))
                return false;
        }
        return true;
    }

    public void createUsuario(Usuario usuario) {
        if (!existUsuario(usuario.getMatricula())) {
            dao.create(usuario);
        }else {
            throw new IllegalArgumentException();
        }
    }
}
