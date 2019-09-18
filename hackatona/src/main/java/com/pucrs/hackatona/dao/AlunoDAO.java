package com.pucrs.hackatona.dao;

import com.google.gson.reflect.TypeToken;
import com.pucrs.hackatona.beans.Pessoa;
import com.pucrs.hackatona.enumerator.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlunoDAO {

    @Autowired
    Gson gson;
    private List<Pessoa> alunoList;
    private FileReader fileReader;

    public AlunoDAO() {
//        this.alunoList = new ArrayList<Pessoa>(){{
//            add(new Pessoa("Ramon", Curso.ES));
//            add(new Pessoa("João", Curso.ES));
//            add(new Pessoa("Pedro", Curso.CC));
//            add(new Pessoa("Matheus", Curso.CC));
//            add(new Pessoa("Judas", Curso.EC));
//            add(new Pessoa("José", Curso.EC));
//            add(new Pessoa("Paulo", Curso.SI));
//            add(new Pessoa("Maria", Curso.SI));
//        }};
        try {
            fileReader = new FileReader("./data/pessoas.json");
            this.alunoList = gson.fromJson(fileReader,  new TypeToken<ArrayList<Pessoa>>() {}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Pessoa> get() {
        return alunoList;
    }
}
