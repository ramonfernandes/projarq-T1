package com.pucrs.hackatona.dao;

import com.pucrs.hackatona.beans.Usuario;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioDAO {

    private List<Usuario> usuarioList;

    //(String email, String senha, String nome, Curso curso, Boolean aluno
    public UsuarioDAO() {
        this.usuarioList = new ArrayList<Usuario>(){{
            add(new Usuario("1111111111", "senha1", "Ramon Fernandes", Curso.ES,true));
            add(new Usuario("1111111112", "senha2", "João Da Silva", Curso.EC,false));
            add(new Usuario("1111111113", "senha3", "Ramiro Araujo", Curso.ES,true));
            add(new Usuario("1111111114", "senha4", "Valdisnei Fernandes", Curso.CC,false));
            add(new Usuario("1111111115", "senha5", "Vitoria Da Silva", Curso.CC,true));
            add(new Usuario("1111111116", "senha6", "Arnaldo Pererira", Curso.CC,true));
            add(new Usuario("1111111117", "senha7", "Eliza Lopes", Curso.SI,true));
            add(new Usuario("1111111118", "senha8", "Mario Costa", Curso.SI,true));
        }};
    }

    public List<Usuario> get() {
        return usuarioList;
    }

    public void create(Usuario usuario) {
        usuarioList.add(usuario);
    }
}
