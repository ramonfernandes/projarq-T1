package com.pucrs.hackatona.service;

import com.pucrs.hackatona.beans.LoginObject;
import com.pucrs.hackatona.beans.UsuarioDTO;
import com.pucrs.hackatona.dao.DAO;
import com.pucrs.hackatona.dao.UsuarioDAO;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private DAO dao;

    public List<UsuarioDTO> getUsuario() {
        return dao.getUsuario().stream()
                .map(usuario -> getUsuarioDTO(usuario))
                .collect(Collectors.toList());
    }

    public UsuarioDTO getUsuarioDTO(UsuarioDAO usuario) {
        return new UsuarioDTO(usuario.getNome(),
                usuario.getSenha(),
                usuario.getNome(),
                getCurso(usuario.getCurso()),
                usuario.getAluno());
    }

    private Curso getCurso(String curso) {
      switch(curso) {
          case "ES":
              return Curso.ES;
          case "CC":
              return Curso.CC;
          case "EC":
              return Curso.EC;
          case "SI":
              return Curso.SI;
      }
      return Curso.ES;
    };

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
        for (UsuarioDTO u : getUsuario()) {
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
        return getByMatricula(getUsuario(), matricula).size() > 0;
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
            dao.create(new UsuarioDAO.Builder()
                    .nome(usuarioDTO.getNome())
                    .senha(usuarioDTO.getSenha())
                    .curso(usuarioDTO.getCurso().name())
                    .matricula(usuarioDTO.getMatricula())
                    .isAluno(usuarioDTO.getIsAluno())
                    .build());
        } else {
            throw new IllegalArgumentException();
        }
    }
}
