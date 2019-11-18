package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.LoginObject;
import com.pucrs.hackatona.beans.UsuarioDTO;
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

    public List<UsuarioDTO> get() {
        return dao.get();
    }

    public List<UsuarioDTO> getByNome(List<UsuarioDTO> list, String nome) {
        return list
                .stream()
                .filter(usuario -> usuario.isName(nome))
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> getByCurso(List<UsuarioDTO> list, String cursoName) throws IllegalArgumentException {
        Curso curso = Curso.valueOf(cursoName);
        return list
                .stream()
                .filter(usuario -> usuario.isCurso(curso))
                .collect(Collectors.toList());
    }

    public LoginObject confirmLogin(String matricula, String senha) throws IllegalArgumentException {
        for (UsuarioDTO u : get()) {
            if (u.isLogin(matricula, senha)) {
                return new LoginObject(matricula, u.getIsAluno());
            }
        }
        throw new IllegalArgumentException();
    }

    public List<UsuarioDTO> getAlunos(List<UsuarioDTO> list) {
        return list
                .stream()
                .filter(UsuarioDTO::getIsAluno)
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> getProfessores(List<UsuarioDTO> list) {
        return list
                .stream()
                .filter(UsuarioDTO::isProfessor)
                .collect(Collectors.toList());
    }

    public List<UsuarioDTO> getByMatricula(List<UsuarioDTO> list, String matricula) {
        return list
                .stream()
                .filter(usuario -> usuario.isMatricula(matricula))
                .collect(Collectors.toList());
    }

    public boolean existUsuario(String matricula) {
        return getByMatricula(get(), matricula).size() > 0;
    }

    public boolean allUsuariosExist(List<UsuarioDTO> usuarioDTOS) {
        for (UsuarioDTO usuarioDTO : usuarioDTOS) {
            if (!existUsuario(usuarioDTO.getMatricula()))
                return false;
        }
        return true;
    }

    public void createUsuario(UsuarioDTO usuarioDTO) {
        if (!existUsuario(usuarioDTO.getMatricula())) {
            dao.create(usuarioDTO);
        }else {
            throw new IllegalArgumentException();
        }
    }
}
