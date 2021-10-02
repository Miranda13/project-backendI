package com.example.proyectoclinica.controllers;

import com.example.proyectoclinica.models.Turno;
import com.example.proyectoclinica.services.OdontologoService;
import com.example.proyectoclinica.services.PacienteService;
import com.example.proyectoclinica.services.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
@CrossOrigin("*")
public class TurnoController {

    private final TurnoService turnoService;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoController(TurnoService turnoService, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoService = turnoService;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @PostMapping
    public ResponseEntity<Turno> crear(@RequestBody Turno turno) {
        if (pacienteService.obtenerUno(turno.getPaciente().getId_paciente()).isPresent() &&
                odontologoService.obtenerUno(turno.getOdontologo().getId_odontologo()).isPresent())
            return ResponseEntity.ok(turnoService.crear(turno));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.obtenerTodos());
    }

    @PutMapping
    public ResponseEntity<Turno> actualizar(@RequestBody Turno turno) {
        if (turnoService.obtenerUno(turno.getPaciente().getId_paciente()).isPresent())
            return ResponseEntity.ok(turnoService.actualizar(turno));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id_turno}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id_turno) {
        if (turnoService.obtenerUno(id_turno).isPresent()) {
            turnoService.eliminar(id_turno);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Turno eliminado");
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
