package com.pucrs.hackatona.controller;

import com.google.gson.Gson;
import com.pucrs.hackatona.beans.Nota;
import com.pucrs.hackatona.beans.TimeDTO;
import com.pucrs.hackatona.service.TimeService;
import com.pucrs.hackatona.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/time")
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
    public ResponseEntity post(@RequestBody TimeDTO timeDTO) {
        if (usuarioService.allUsuariosExist(timeDTO.getAlunos()) && timeService.validateTime(timeDTO.getAlunos())) {
            timeService.createTeam(timeDTO);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{id}")
    public ResponseEntity post(@PathVariable("id") int id,
                               @RequestBody TimeDTO timeDTO) {
        try {
            timeService.updateTime(id, timeDTO);
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

    @PostMapping("/timeByAlunos")
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
