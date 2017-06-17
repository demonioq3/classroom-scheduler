package cl.ciisa.crs.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Profesor {
    private Long id;
    private String nombre;
    private String aprellidos;
    private int rut;
    private Long idCarrera;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "aprellidos")
    public String getAprellidos() {
        return aprellidos;
    }

    public void setAprellidos(String aprellidos) {
        this.aprellidos = aprellidos;
    }

    @Basic
    @Column(name = "rut")
    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    @Basic
    @Column(name = "id_carrera")
    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Profesor profesor = (Profesor) o;

        if (rut != profesor.rut) return false;
        if (id != null ? !id.equals(profesor.id) : profesor.id != null) return false;
        if (nombre != null ? !nombre.equals(profesor.nombre) : profesor.nombre != null) return false;
        if (aprellidos != null ? !aprellidos.equals(profesor.aprellidos) : profesor.aprellidos != null) return false;
        if (idCarrera != null ? !idCarrera.equals(profesor.idCarrera) : profesor.idCarrera != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (aprellidos != null ? aprellidos.hashCode() : 0);
        result = 31 * result + rut;
        result = 31 * result + (idCarrera != null ? idCarrera.hashCode() : 0);
        return result;
    }
}
