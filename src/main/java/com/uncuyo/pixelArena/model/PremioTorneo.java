package com.uncuyo.pixelArena.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "premiotorneo")
public class PremioTorneo implements Serializable {

  @Id
  @Column(name = "idpremio")
  private int idPremio;

  @Id
  @Column(name = "númerotorneo")
  private int numTorneo;

  @Column(name = "Puesto")
  private String puesto;

  public PremioTorneo() {
  }

  public PremioTorneo(int idPremio, int numTorneo, String puesto) {
    this.idPremio = idPremio;
    this.numTorneo = numTorneo;
    this.puesto = puesto;
  }

  public int getIdPremio() {
    return idPremio;
  }

  public void setIdPremio(int idPremio) {
    this.idPremio = idPremio;
  }

  public int getNumTorneo() {
    return numTorneo;
  }

  public void setNumTorneo(int numTorneo) {
    this.numTorneo = numTorneo;
  }

  public String getPuesto() {
    return puesto;
  }

  public void setPuesto(String puesto) {
    this.puesto = puesto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PremioTorneo that = (PremioTorneo) o;
    return idPremio == that.idPremio && numTorneo == that.numTorneo;
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(idPremio);
    result = 31 * result + Integer.hashCode(numTorneo);
    return result;
  }

  @Override
  public String toString() {
    return "PremioTorneo{" + "idPremio=" + idPremio + ", numTorneo=" + numTorneo + ", puesto=" + puesto + '}';
  }
}
