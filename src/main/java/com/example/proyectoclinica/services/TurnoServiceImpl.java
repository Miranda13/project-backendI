package com.example.proyectoclinica.services;

import com.example.proyectoclinica.models.Paciente;
import com.example.proyectoclinica.models.Turno;
import com.example.proyectoclinica.repositories.TurnoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurnoServiceImpl implements TurnoService {
    private final TurnoRepository turnoRepository;
    private PacienteService pacienteService;
    private OdontologoService odontologoService;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public TurnoServiceImpl(TurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }

    @Override
    public List<Turno> obtenerTodos() {
        return turnoRepository.findAll();
    }

    @Override
    public Optional<Turno> obtenerUno(Integer id_turno) {
        return turnoRepository.findById(id_turno);
    }

    @Override
    public Turno crear(Turno turno) {
        return turnoRepository.save(turno);
    }

    @Override
    public void eliminar(Integer id_turno) {
        turnoRepository.deleteById(id_turno);
    }

    @Override
    public Turno actualizar(Turno turno) {
        return turnoRepository.save(turno);
    }
}
