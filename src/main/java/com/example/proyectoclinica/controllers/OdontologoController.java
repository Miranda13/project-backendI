package com.example.proyectoclinica.controllers;

import com.example.proyectoclinica.models.Odontologo;
import com.example.proyectoclinica.services.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
@CrossOrigin("*")
public class OdontologoController {
    private final OdontologoService odontologoService;

    @Autowired
    public OdontologoController(OdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    @PostMapping()
    public ResponseEntity<Odontologo> crear(@RequestBody Odontologo odontologo) {
        return ResponseEntity.ok(odontologoService.crear(odontologo));
    }

    @GetMapping
    public ResponseEntity<List<Odontologo>> obtenerTodos() {
        return ResponseEntity.ok(odontologoService.obtenerTodos());
    }

    @GetMapping("/{id_odontologo}")
    public ResponseEntity<Optional> obtenerUno(@PathVariable Integer id_odontologo) {
        if (odontologoService.obtenerUno(id_odontologo).isPresent()) {
            return ResponseEntity.ok(odontologoService.obtenerUno(id_odontologo));
        } else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{id_odontologo}")
    public ResponseEntity<String> eliminar(@PathVariable Integer id_odontologo) {
        if (odontologoService.obtenerUno(id_odontologo).isPresent()) {
            odontologoService.eliminar(id_odontologo);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Odontologo eliminado");
        }
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping()
    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
        if(odontologoService.obtenerUno(odontologo.getId_odontologo()).isPresent())
            return ResponseEntity.ok(odontologoService.actualizar(odontologo));
        else
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
