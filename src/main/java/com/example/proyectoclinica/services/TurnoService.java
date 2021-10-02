package com.example.proyectoclinica.services;

import com.example.proyectoclinica.models.Turno;

import java.util.List;
import java.util.Optional;

public interface TurnoService {
    List<Turno> obtenerTodos();
    Optional<Turno> obtenerUno(Integer id_turno);
    Turno crear(Turno turno);
    void eliminar(Integer id_turno);
    Turno actualizar(Turno turno);
}
