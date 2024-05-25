package com.uncuyo.pixelArena.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "torneo")
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numerotorneo")
    private long numTorneo;
    @Column(name = "nombre")
    private String nombreTorneo;
    @Column(name = "descripcion")
    private String descripcionTorneo;
    @Column(name = "fechainicio")
    private Date fechaInicioTorneo;
    @Column(name = "fechafinal")
    private Date fechaFinalTorneo;
    @Column(name = "costoinscripción")
    private double costoInscripcionTorneo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idjuego")
    private Juego juego;

    public Torneo() {
    }

    public Torneo(String nombreTorneo, String descripcionTorneo, Date fechaInicioTorneo, Date fechaFinalTorneo, double costoInscripcionTorneo, Juego juego) {
        this.nombreTorneo = nombreTorneo;
        this.descripcionTorneo = descripcionTorneo;
        this.fechaInicioTorneo = fechaInicioTorneo;
        this.fechaFinalTorneo = fechaFinalTorneo;
        this.costoInscripcionTorneo = costoInscripcionTorneo;
        this.juego = juego;
    }
    
    public Torneo(String nombreTorneo, String descripcionTorneo, Date fechaInicioTorneo, double costoInscripcionTorneo, Juego juego) {
        this.nombreTorneo = nombreTorneo;
        this.descripcionTorneo = descripcionTorneo;
        this.fechaInicioTorneo = fechaInicioTorneo;
        this.costoInscripcionTorneo = costoInscripcionTorneo;
        this.juego = juego;
    }

    public long getNumTorneo() {
        return numTorneo;
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

    public Juego getJuego() {
        return juego;
    }

    public void setJuego(Juego juego) {
        this.juego = juego;
    }

    @Override
    public String toString() {
        return "Torneo{" + "numTorneo=" + numTorneo + ", nombreTorneo=" + nombreTorneo + ", descripcionTorneo=" + descripcionTorneo + ", fechaInicioTorneo=" + fechaInicioTorneo + ", fechaFinalTorneo=" + fechaFinalTorneo + ", costoInscripcionTorneo=" + costoInscripcionTorneo + ", juego=" + juego + '}';
    }
}
