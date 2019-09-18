package com.pucrs.hackatona.controller;

import com.google.gson.Gson;
import com.pucrs.hackatona.beans.Aluno;
import com.pucrs.hackatona.dao.AlunoDAO;
import com.pucrs.hackatona.enumerator.Curso;
import com.pucrs.hackatona.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/aluno")
public class AlunoController {

    @Autowired
    Gson gson;
    @Autowired
    private AlunoService service;

    @GetMapping()
    public ResponseEntity get(@RequestParam(required = false) String nome,
                              @RequestParam(required = false) String curso) {
        List<Aluno> list = service.get();
        if(nome != null)
            list = service.getByNome(list, nome);
        if(curso != null)
            list = service.getByCurso(list, curso);
        return ResponseEntity.ok(gson.toJson(list, List.class));

    }

}
