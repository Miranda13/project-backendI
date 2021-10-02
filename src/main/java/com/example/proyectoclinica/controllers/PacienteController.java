package com.example.proyectoclinica.controllers;

import com.example.proyectoclinica.models.Paciente;
import com.example.proyectoclinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin("*")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public ResponseEntity<Paciente> crear(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(pacienteService.crear(paciente));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> obtenerTodos() {
        return ResponseEntity.ok(pacienteService.obtenerTodos());
    }

    @GetMapping("/{id_paciente}")
    public ResponseEntity<Optional> obtenerUno(@PathVariable Integer id_paciente) {
        if (pacienteService.obtenerUno(id_paciente).isPresent())
            return ResponseEntity.ok(pacienteService.obtenerUno(id_paciente));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id_paciente}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id_paciente) {
        if (pacienteService.obtenerUno(id_paciente).isPresent()) {
            pacienteService.eliminar(id_paciente);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente eliminado");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping()
    public ResponseEntity<Paciente> actualizar(@RequestBody Paciente paciente) {
        if (pacienteService.obtenerUno(paciente.getId_paciente()).isPresent())
            return ResponseEntity.ok(pacienteService.actualizar(paciente));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

}
