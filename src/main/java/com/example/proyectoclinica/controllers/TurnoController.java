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
    public ResponseEntity<Turno> crearTurno(@RequestBody Turno turno) {
        ResponseEntity<Turno> response;
        if (pacienteService.obtenerUno(turno.getPaciente().getId_paciente()).isPresent() &&
                odontologoService.obtenerUno(turno.getOdontologo().getId_odontologo()).isPresent())
            response = ResponseEntity.ok(turnoService.guardar(turno));
        else
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listar() {
        return ResponseEntity.ok(turnoService.obtenerTodos());
    }

    @PutMapping
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.actualizar(turno));
    }

    @DeleteMapping("/{id_turno}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id_turno) {
        ResponseEntity<String> response;
        if (turnoService.obtenerUno(id_turno).isPresent()) {
            turnoService.eliminar(id_turno);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return response;
    }
}
