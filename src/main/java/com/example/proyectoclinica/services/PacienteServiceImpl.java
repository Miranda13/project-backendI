package com.example.proyectoclinica.services;

import com.example.proyectoclinica.models.Paciente;
import com.example.proyectoclinica.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements PacienteService {
    private final PacienteRepository pacienteRepository;
    private DomicilioServiceImpl domicilioService;

    @Autowired
    public PacienteServiceImpl(PacienteRepository pacienteRepository, DomicilioServiceImpl domicilioService){
        this.pacienteRepository = pacienteRepository;
        this.domicilioService = domicilioService;
    }

    @Override
    public List<Paciente> obtenerTodos() {
        return pacienteRepository.findAll();
    }

    @Override
    public Optional<Paciente> obtenerUno(Integer id_paciente) {
        return pacienteRepository.findById(id_paciente);
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        paciente.setDomicilio(domicilioService.guardar(paciente.getDomicilio()));
        return pacienteRepository.save(paciente);

    }

    @Override
    public void eliminar(Integer id_paciente)  {
        pacienteRepository.deleteById(id_paciente);
    }

    @Override
    public Paciente actualizar(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
}
