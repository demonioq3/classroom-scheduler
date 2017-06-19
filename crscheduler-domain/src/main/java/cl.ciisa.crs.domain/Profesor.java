package cl.ciisa.crs.domain;

import javax.persistence.*;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Profesor extends BaseEntity {
    private Long id;
    private String nombre;
    private String aprellidos;
    private int rut;
    private Long idCarrera;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

}
