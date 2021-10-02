package com.example.proyectoclinica.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence")
    private Integer id_turno;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
    @ManyToOne
    @JoinColumn(name = "id_odontologo")
    private Odontologo odontologo;
    private Date fecha_turno;

    public Turno(Integer id_turno, Paciente paciente, Odontologo odontologo, Date fecha_turno) {
        this.id_turno = id_turno;
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha_turno = fecha_turno;
    }

    public Turno(Paciente paciente, Odontologo odontologo, Date fecha_turno) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fecha_turno = fecha_turno;
    }

    public Turno() {
    }

    public Integer getId_turno() {
        return id_turno;
    }

    public void setId_turno(Integer id_turno) {
        this.id_turno = id_turno;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Odontologo getOdontologo() {
        return odontologo;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }

    public Date getFecha_turno() {
        return fecha_turno;
    }

    public void setFecha_turno(Date fecha_turno) {
        this.fecha_turno = fecha_turno;
    }
}
