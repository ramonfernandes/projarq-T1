package com.pucrs.hackatona.controller;

import com.google.gson.Gson;
import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.Time;
import com.pucrs.hackatona.beans.Usuario;
import com.pucrs.hackatona.service.TimeService;
import com.pucrs.hackatona.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController(value = "/time")
public class TimeController {

    @Autowired
    Gson gson;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private TimeService timeService;

    @GetMapping()
    public ResponseEntity getAll() {
        return ResponseEntity.ok(timeService.getAll());
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody List<Usuario> list) {
        if (usuarioService.allUsuariosExist(list) && timeService.validateTime(list)) {
            timeService.createTeam(list);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity post(@PathVariable("id") int id,
                               @RequestBody Time time) {
        try {
            timeService.updateTime(id, time);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") int id) {
        try {
            return ResponseEntity.ok(timeService.getTeamById(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/timeByAlunos")
    public ResponseEntity getTimeByAlunos(@RequestBody List<String> matriculas) {
        return ResponseEntity.ok(timeService.getByMatriculas(matriculas));
    }

    @PostMapping("/avaliar/{id}")
    public ResponseEntity post(@PathVariable("id") int id,
                               @RequestBody Nota nota) {
        try {
            timeService.updateNota(timeService.getTeamById(id), nota);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
