package com.example.proyectoclinica.models;

import javax.persistence.*;

@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Integer id_domicilio;
    private String barrio;
    private String ciudad;
    private String direccion;

    public Domicilio(Integer id_domicilio, String barrio, String ciudad, String direccion) {
        this.id_domicilio = id_domicilio;
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Domicilio(String barrio, String ciudad, String direccion) {
        this.barrio = barrio;
        this.ciudad = ciudad;
        this.direccion = direccion;
    }

    public Domicilio() {
    }

    public Integer getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(Integer id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
