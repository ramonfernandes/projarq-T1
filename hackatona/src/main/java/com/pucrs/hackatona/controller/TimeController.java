package com.pucrs.hackatona.controller;

import com.google.gson.Gson;
import com.pucrs.hackatona.beans.Aluno;
import com.pucrs.hackatona.service.AlunoService;
import com.pucrs.hackatona.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController(value = "/time")
public class TimeController {

    @Autowired
    Gson gson;
    @Autowired
    private AlunoService alunoService;
    @Autowired
    private TimeService timeService;

    @GetMapping()
    public ResponseEntity getAll() {
        return ResponseEntity.ok(timeService.getAll());
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody List<Aluno> list) {
        if(alunoService.allAlunosExist(list)){
            timeService.createTeam(list);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.badRequest().build();
        }
    }

//    @PostMapping("/{id}")
//    public ResponseEntity approveTeam(PathParam String id) {
//        if(alunoService.allAlunosExist(list)){
//            timeService.createTeam(list);
//            return ResponseEntity.ok().build();
//        }else {
//            return ResponseEntity.badRequest().build();
//        }
//    }
}
