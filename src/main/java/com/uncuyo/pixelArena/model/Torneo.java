package com.uncuyo.pixelArena.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "torneo")
public class Torneo {
    @Id
    @Column(name = "númerotorneo")
    private int numTorneo;
    @Column(name = "nombre")
    private String nombreTorneo;
    @Column(name = "descripción")
    private String descripcionTorneo;
    @Column(name = "fechainicio")
    private Date fechaInicioTorneo;
    @Column(name = "fechafinal")
    private Date fechaFinalTorneo;
    @Column(name = "costoinscripción")
    private double costoInscripcionTorneo;
    @Column(name = "idjuego")
    private String idJuego;

    public Torneo() {
    }

    public Torneo(int numTorneo, String nombreTorneo, String descripcionTorneo, Date fechaInicioTorneo, Date fechaFinalTorneo, double costoInscripcionTorneo, String idJuego) {
        this.numTorneo = numTorneo;
        this.nombreTorneo = nombreTorneo;
        this.descripcionTorneo = descripcionTorneo;
        this.fechaInicioTorneo = fechaInicioTorneo;
        this.fechaFinalTorneo = fechaFinalTorneo;
        this.costoInscripcionTorneo = costoInscripcionTorneo;
        this.idJuego = idJuego;
    }

    public int getNumTorneo() {
        return numTorneo;
    }

    public void setNumTorneo(int numTorneo) {
        this.numTorneo = numTorneo;
    }

    public String getNombreTorneo() {
        return nombreTorneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
    }

    public String getDescripcionTorneo() {
        return descripcionTorneo;
    }

    public void setDescripcionTorneo(String descripcionTorneo) {
        this.descripcionTorneo = descripcionTorneo;
    }

    public Date getFechaInicioTorneo() {
        return fechaInicioTorneo;
    }

    public void setFechaInicioTorneo(Date fechaInicioTorneo) {
        this.fechaInicioTorneo = fechaInicioTorneo;
    }

    public Date getFechaFinalTorneo() {
        return fechaFinalTorneo;
    }

    public void setFechaFinalTorneo(Date fechaFinalTorneo) {
        this.fechaFinalTorneo = fechaFinalTorneo;
    }

    public double getCostoInscripcionTorneo() {
        return costoInscripcionTorneo;
    }

    public void setCostoInscripcionTorneo(double costoInscripcionTorneo) {
        this.costoInscripcionTorneo = costoInscripcionTorneo;
    }

    public String getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(String idJuego) {
        this.idJuego = idJuego;
    }

    @Override
    public String toString() {
        return "Torneo{" + "numTorneo=" + numTorneo + ", nombreTorneo=" + nombreTorneo + ", descripcionTorneo=" + descripcionTorneo + ", fechaInicioTorneo=" + fechaInicioTorneo + ", fechaFinalTorneo=" + fechaFinalTorneo + ", costoInscripcionTorneo=" + costoInscripcionTorneo + ", idJuego=" + idJuego + '}';
    }
}
