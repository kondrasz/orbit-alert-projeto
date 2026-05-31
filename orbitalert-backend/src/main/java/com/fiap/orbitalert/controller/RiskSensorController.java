package com.fiap.orbitalert.controller;

import com.fiap.orbitalert.model.RiskSensorLog;
import com.fiap.orbitalert.repository.RiskSensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/alertas")
@CrossOrigin
public class RiskSensorController {

    @Autowired
    private RiskSensorRepository repository;

    @GetMapping
    public List<RiskSensorLog> listarTodos() {
        return repository.findAll();
    }

    @PostMapping
    public ResponseEntity<RiskSensorLog> criarLog(@RequestBody RiskSensorLog novoLog) {
        if (novoLog.getDataHora() == null) {
            novoLog.setDataHora(LocalDateTime.now());
        }
        RiskSensorLog salvo = repository.save(novoLog);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RiskSensorLog> buscarPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(log -> ResponseEntity.ok(log))
                .orElse(ResponseEntity.notFound().build());
    }
}