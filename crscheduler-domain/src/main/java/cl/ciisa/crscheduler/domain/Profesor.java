package cl.ciisa.crscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Profesor extends BaseEntity implements Serializable {
    private Long id;
    private String nombre;
    private String aprellidos;
    private int rut;
    private Carrera carrera;
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

    @ManyToOne
    @JoinColumn(name = "id_carrera", referencedColumnName = "id", insertable = false, updatable = false)
    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
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
