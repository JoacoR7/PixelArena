package com.uncuyo.pixelArena.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizadordetorneos")
public class OrganizadorTorneo {
    @Id
    @Column(name = "legajo")
    private String legajo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "email")
    private String email;
    @Column(name = "numteléfono")
    private int numtel;

    public OrganizadorTorneo() {
    }

    public OrganizadorTorneo(String legajo, String nombre, String apellido, String email, int numtel) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.numtel = numtel;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    @Override
    public String toString() {
        return "OrganizadorTorneo{" + "legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", numtel=" + numtel + '}';
    }
}
