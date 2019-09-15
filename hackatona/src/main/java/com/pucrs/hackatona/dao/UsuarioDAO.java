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
            add(new Usuario("ramon@email.com","senha1", "Ramon Fernandes", Curso.ES,true));
            add(new Usuario("joao@email.com","senha2", "João Da Silva", Curso.EC,false));
            add(new Usuario("ramiro@email.com","senha3", "Ramiro Araujo", Curso.ES,true));
            add(new Usuario("valdisnei@email.com","senha4", "Valdisnei Fernandes", Curso.CC,false));
            add(new Usuario("vitoria@email.com","senha5", "Vitoria Da Silva", Curso.CC,true));
            add(new Usuario("pereira@email.com","senha6", "Arnaldo Pererira", Curso.CC,true));
            add(new Usuario("eliza@email.com","senha7", "Eliza Lopes", Curso.SI,true));
            add(new Usuario("mario@email.com","senha8", "Mario Costa", Curso.SI,true));
        }};
    }

    public List<Usuario> get() {
        return usuarioList;
    }
}
