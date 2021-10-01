package com.example.proyectoclinica.models;

import javax.persistence.*;

@Entity
@Table(name = "odontologos")
public class Odontologo {
    @Id
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Integer id_odontologo;
    private String nombre;
    private String apellido;
    private String matricula;

    public Odontologo(String nombre, String apellido, String matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo(Integer id_odontologo, String nombre, String apellido, String matricula) {
        this.id_odontologo = id_odontologo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }

    public Odontologo() {
    }

    public Integer getId_odontologo() {
        return id_odontologo;
    }

    public void setId_odontologo(Integer id_odontologo) {
        this.id_odontologo = id_odontologo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
