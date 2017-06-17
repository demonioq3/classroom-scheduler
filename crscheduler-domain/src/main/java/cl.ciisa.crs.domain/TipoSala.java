package cl.ciisa.crs.domain;

import javax.persistence.*;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
@Table(name = "sala_tipo", schema = "crscheduler", catalog = "")
public class TipoSala {
    private Long id;
    private String nombre;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoSala tipoSala = (TipoSala) o;

        if (id != null ? !id.equals(tipoSala.id) : tipoSala.id != null) return false;
        if (nombre != null ? !nombre.equals(tipoSala.nombre) : tipoSala.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}
