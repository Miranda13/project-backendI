package com.example.proyectoclinica.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Integer id_paciente;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fecha_alta;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_domicilio")
    private  Domicilio domicilio;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String dni, Date date) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_alta = date;
    }

    public Paciente(Integer id_paciente, String nombre, String apellido, String dni, Date date) {
        this.id_paciente = id_paciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_alta = date;
    }

    public Integer getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
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

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Date fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
}
