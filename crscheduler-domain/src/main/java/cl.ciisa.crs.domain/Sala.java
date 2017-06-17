package cl.ciisa.crs.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Sala {
    private Long id;
    private String codigo;
    private Date horaInicio;
    private Date horaFin;
    private Long idCampus;
    private Long idTipo;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "codigo")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "hora_inicio")
    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    @Basic
    @Column(name = "hora_fin")
    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Basic
    @Column(name = "id_campus")
    public Long getIdCampus() {
        return idCampus;
    }

    public void setIdCampus(Long idCampus) {
        this.idCampus = idCampus;
    }

    @Basic
    @Column(name = "id_tipo")
    public Long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Long idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sala sala = (Sala) o;

        if (id != null ? !id.equals(sala.id) : sala.id != null) return false;
        if (codigo != null ? !codigo.equals(sala.codigo) : sala.codigo != null) return false;
        if (horaInicio != null ? !horaInicio.equals(sala.horaInicio) : sala.horaInicio != null) return false;
        if (horaFin != null ? !horaFin.equals(sala.horaFin) : sala.horaFin != null) return false;
        if (idCampus != null ? !idCampus.equals(sala.idCampus) : sala.idCampus != null) return false;
        if (idTipo != null ? !idTipo.equals(sala.idTipo) : sala.idTipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (horaInicio != null ? horaInicio.hashCode() : 0);
        result = 31 * result + (horaFin != null ? horaFin.hashCode() : 0);
        result = 31 * result + (idCampus != null ? idCampus.hashCode() : 0);
        result = 31 * result + (idTipo != null ? idTipo.hashCode() : 0);
        return result;
    }
}
