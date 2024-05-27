package com.uncuyo.pixelArena.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long Id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "email")
    private String email;
    @Column(name = "numteléfono")
    private int numtelefono;
    @Column(name = "activo")
    private boolean activo;

    public Empresa() {
    }

    public Empresa(String nombre, String email, int numtelefono) {
        this.nombre = nombre;
        this.email = email;
        this.numtelefono = numtelefono;
        this.activo = true;
    }

    public long getId() {
        return Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumtelefono() {
        return numtelefono;
    }

    public void setNumtelefono(int numtelefono) {
        this.numtelefono = numtelefono;
    }

    @Override
    public String toString() {
        return "Id: " + Id + ", Nombre: " + nombre + ", Email: " + email + ", Número de teléfono: " + numtelefono;
    }

}
