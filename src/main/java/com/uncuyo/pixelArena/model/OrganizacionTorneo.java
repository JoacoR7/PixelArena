package com.uncuyo.pixelArena.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "organizadortorneo")
public class OrganizacionTorneo implements Serializable {

  @Id
  @Column(name = "númerotorneo")
  private int numTorneo;

  @Id
  @Column(name = "legajoorganizador")
  private String legajoOrganizador;

  public OrganizacionTorneo() {
  }

  public OrganizacionTorneo(int numTorneo, String legajoOrganizador) {
    this.numTorneo = numTorneo;
    this.legajoOrganizador = legajoOrganizador;
  }

  public int getNumTorneo() {
    return numTorneo;
  }

  public void setNumTorneo(int numTorneo) {
    this.numTorneo = numTorneo;
  }

  public String getLegajoOrganizador() {
    return legajoOrganizador;
  }

  public void setLegajoOrganizador(String legajoOrganizador) {
    this.legajoOrganizador = legajoOrganizador;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    OrganizacionTorneo that = (OrganizacionTorneo) o;
    return numTorneo == that.numTorneo && legajoOrganizador.equals(that.legajoOrganizador);
  }

  @Override
  public int hashCode() {
    int result = Integer.hashCode(numTorneo);
    result = 31 * result + (legajoOrganizador != null ? legajoOrganizador.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "OrganizacionTorneo{" + "numTorneo=" + numTorneo + ", legajoOrganizador=" + legajoOrganizador + '}';
  }
}
