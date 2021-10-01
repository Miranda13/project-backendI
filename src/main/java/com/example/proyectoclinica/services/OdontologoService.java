package com.example.proyectoclinica.services;



import com.example.proyectoclinica.models.Odontologo;

import java.util.List;
import java.util.Optional;

public interface OdontologoService {
    List<Odontologo> obtenerTodos();
    Optional<Odontologo> obtenerUno(Integer id_odontologo);
    Odontologo guardar(Odontologo odontologo);
    void eliminar(Integer id_odontologo);
    Odontologo actualizar(Odontologo odontologo);
}
