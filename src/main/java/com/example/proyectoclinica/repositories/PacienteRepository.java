package com.example.proyectoclinica.repositories;

import com.example.proyectoclinica.models.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente,Integer> {
}
