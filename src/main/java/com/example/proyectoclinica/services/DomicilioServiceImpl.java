package com.example.proyectoclinica.services;

import com.example.proyectoclinica.models.Domicilio;
import com.example.proyectoclinica.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServiceImpl implements DomicilioService {
    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioServiceImpl(DomicilioRepository domicilioRepository) {
        this.domicilioRepository = domicilioRepository;
    }

    @Override
    public List<Domicilio> obtenerTodos() {
        return domicilioRepository.findAll();
    }

    @Override
    public Optional<Domicilio> obtenerUno(Integer id_domicilio) {
        return  domicilioRepository.findById(id_domicilio);
    }

    @Override
    public Domicilio crear(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }

    @Override
    public void eliminar(Integer id_domicilio) {
        domicilioRepository.deleteById(id_domicilio);
    }

    @Override
    public Domicilio actualizar(Domicilio domicilio) {
        return domicilioRepository.save(domicilio);
    }
}
