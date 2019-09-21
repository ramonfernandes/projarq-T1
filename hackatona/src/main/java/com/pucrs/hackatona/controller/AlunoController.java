package com.pucrs.hackatona.controller;

import com.google.gson.Gson;
import com.pucrs.hackatona.beans.Pessoa;
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
    private UsuarioService service;

    @GetMapping("/usuarios")
    public ResponseEntity get(@RequestParam(required = false) String nome,
                              @RequestParam(required = false) String curso,
                              @RequestParam(required = false) String matricula) {
        List<Pessoa> list = service.get();
        if(nome != null)
            list = service.getByNome(list, nome);
        if(curso != null)
            list = service.getByCurso(list, curso);
        return ResponseEntity.ok(gson.toJson(list, List.class));
    }

    @GetMapping("/alunos")
    public ResponseEntity get() {
        List<Usuario> list = service.get();
        list = service.getAlunos(list);
        if(matricula != null)
            list = service.getByMatricula(list, matricula);

        return ResponseEntity.ok(gson.toJson(list, List.class));
    }


}
