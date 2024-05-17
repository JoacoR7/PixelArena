package com.uncuyo.pixelArena.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "participacionusuario")
public class ParticipacionUsuario {

    @Id
    @Embedded
    private ParticipacionUsuarioPK pk;

    @Column(name = "idrol")
    private int idRol;

    public ParticipacionUsuario() {
    }

    public ParticipacionUsuario(String nombreUsuario, int numTorneo, int idRol) {
        this.pk = new ParticipacionUsuarioPK(nombreUsuario, numTorneo);
        this.idRol = idRol;
    }

    public String getNombreUsuario() {
        return pk.getNombreUsuario();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.pk.setNombreUsuario(nombreUsuario);
    }

    public int getNumTorneo() {
        return pk.getNumTorneo();
    }

    public void setNumTorneo(int numTorneo) {
        this.pk.setNumTorneo(numTorneo);
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ParticipacionUsuario other = (ParticipacionUsuario) obj;
        return Objects.equals(pk, other.pk);
    }

    @Override
    public String toString() {
        return "ParticipacionUsuario{" + "pk=" + pk + ", idRol=" + idRol + '}';
    }

    public static class ParticipacionUsuarioPK implements Serializable {

        private String nombreUsuario;
        private int numTorneo;

        public ParticipacionUsuarioPK() {
        }

        public ParticipacionUsuarioPK(String nombreUsuario, int numTorneo) {
            this.nombreUsuario = nombreUsuario;
            this.numTorneo = numTorneo;
        }

        public String getNombreUsuario() {
            return nombreUsuario;
        }

        public void setNombreUsuario(String nombreUsuario) {
            this.nombreUsuario = nombreUsuario;
        }

        public int getNumTorneo() {
            return numTorneo;
        }

        public void setNumTorneo(int numTorneo) {
            this.numTorneo = numTorneo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombreUsuario, numTorneo);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            ParticipacionUsuarioPK other = (ParticipacionUsuarioPK) obj;
            return Objects.equals(nombreUsuario, other.nombreUsuario)
                    && Objects.equals(numTorneo, other.numTorneo);
        }
    }
}
