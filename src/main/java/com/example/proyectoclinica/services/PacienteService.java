package com.example.proyectoclinica.services;
import com.example.proyectoclinica.models.Paciente;

import java.util.List;
import java.util.Optional;

public interface PacienteService {
    List<Paciente> obtenerTodos();
    Optional<Paciente> obtenerUno(Integer id_paciente);
    Paciente guardar(Paciente paciente);
    void eliminar(Integer id_paciente);
    Paciente actualizar(Paciente paciente);
}
