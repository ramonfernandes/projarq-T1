package com.pucrs.hackatona.controller;

import com.google.gson.Gson;
import com.pucrs.hackatona.beans.Usuario;
import com.pucrs.hackatona.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "/aluno")
public class UsuarioController {

    @Autowired
    Gson gson;
    @Autowired
    private UsuarioService service;

    @GetMapping("/usuarios")
    public ResponseEntity get(@RequestParam(required = false) String nome,
                              @RequestParam(required = false) String curso,
                              @RequestParam(required = false) String matricula) {
        List<Usuario> list = service.get();
        if (nome != null)
            list = service.getByNome(list, nome);
        if (curso != null)
            list = service.getByCurso(list, curso);
        if (matricula != null)
            list = service.getByMatricula(list, matricula);
        return ResponseEntity.ok(gson.toJson(list, List.class));
    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestParam(required = false) String matricula,
                                @RequestParam(required = false) String senha) {
        try {
            ResponseEntity.ok(service.confirmLogin(matricula, senha));
        } catch (IllegalArgumentException e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity cadastrar(@RequestBody Usuario usuario) {
        try {
            service.createUsuario(usuario);
            ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.noContent().build();
    }
}
