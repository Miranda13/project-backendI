package com.example.proyectoclinica.services;

import com.example.proyectoclinica.models.Domicilio;

import java.util.List;
import java.util.Optional;

public interface DomicilioService {
    List<Domicilio> obtenerTodos();
    Optional<Domicilio> obtenerUno(Integer id_domicilio);
    Domicilio guardar(Domicilio domicilio);
    void eliminar(Integer id_domicilio);
    Domicilio actualizar(Domicilio domicilio);
}
