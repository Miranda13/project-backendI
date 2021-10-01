package com.example.proyectoclinica.services;

import com.example.proyectoclinica.models.Odontologo;
import com.example.proyectoclinica.repositories.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoServiceImpl implements OdontologoService {
    private final OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoServiceImpl(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public List<Odontologo> obtenerTodos() {
        return odontologoRepository.findAll();
    }

    @Override
    public Optional<Odontologo> obtenerUno(Integer id_Odontologo) {
        return  odontologoRepository.findById(id_Odontologo);
    }

    @Override
    public Odontologo guardar(Odontologo Odontologo) {
        return odontologoRepository.save(Odontologo);
    }

    @Override
    public void eliminar(Integer id_Odontologo) {
        odontologoRepository.deleteById(id_Odontologo);
    }

    @Override
    public Odontologo actualizar(Odontologo Odontologo) {
        return odontologoRepository.save(Odontologo);
    }
}
