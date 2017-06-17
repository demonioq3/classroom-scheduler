package cl.ciisa.crs.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Campus {
    private Long id;
    private String direccion;
    private Long idInstitucioneducacional;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Basic
    @Column(name = "id_institucioneducacional")
    public Long getIdInstitucioneducacional() {
        return idInstitucioneducacional;
    }

    public void setIdInstitucioneducacional(Long idInstitucioneducacional) {
        this.idInstitucioneducacional = idInstitucioneducacional;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Campus campus = (Campus) o;

        if (id != null ? !id.equals(campus.id) : campus.id != null) return false;
        if (direccion != null ? !direccion.equals(campus.direccion) : campus.direccion != null) return false;
        if (idInstitucioneducacional != null ? !idInstitucioneducacional.equals(campus.idInstitucioneducacional) : campus.idInstitucioneducacional != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (idInstitucioneducacional != null ? idInstitucioneducacional.hashCode() : 0);
        return result;
    }
}
