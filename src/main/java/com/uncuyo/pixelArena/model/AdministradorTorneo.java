package com.uncuyo.pixelArena.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administradortorneo")
public class AdministradorTorneo implements Serializable {

  @Id
  @Column(name = "númerotorneo")
  private int numTorneo;

  @Id
  @Column(name = "legajomoderador")
  private String legajoModerador;

  public AdministradorTorneo() {
  }

  public AdministradorTorneo(int numTorneo, String legajoModerador) {
    this.numTorneo = numTorneo;
    this.legajoModerador = legajoModerador;
  }

  public int getNumTorneo() {
    return numTorneo;
  }

  public void setNumTorneo(int numTorneo) {
    this.numTorneo = numTorneo;
  }

  public String getLegajoModerador() {
    return legajoModerador;
  }

  public void setLegajoModerador(String legajoModerador) {
    this.legajoModerador = legajoModerador;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AdministradorTorneo that = (AdministradorTorneo) o;
    return numTorneo == that.numTorneo && legajoModerador.equals(that.legajoModerador);
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(numTorneo);
    result = 31 * result + (legajoModerador != null ? legajoModerador.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AdministradorTorneo{" + "numTorneo=" + numTorneo + ", legajoModerador=" + legajoModerador + '}';
  }
}
