package cl.ciisa.crs.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
@Table(name = "bloque_horario_reserva", schema = "crscheduler", catalog = "")
public class BloqueHorario {
    private Long id;
    private Long idProfesor;
    private Long idSala;
    private Date horaInicio;
    private Date horaFin;
    private boolean vigente;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_profesor")
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Basic
    @Column(name = "id_sala")
    public Long getIdSala() {
        return idSala;
    }

    public void setIdSala(Long idSala) {
        this.idSala = idSala;
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
    @Column(name = "vigente")
    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BloqueHorario that = (BloqueHorario) o;

        if (vigente != that.vigente) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (idProfesor != null ? !idProfesor.equals(that.idProfesor) : that.idProfesor != null) return false;
        if (idSala != null ? !idSala.equals(that.idSala) : that.idSala != null) return false;
        if (horaInicio != null ? !horaInicio.equals(that.horaInicio) : that.horaInicio != null) return false;
        if (horaFin != null ? !horaFin.equals(that.horaFin) : that.horaFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (idProfesor != null ? idProfesor.hashCode() : 0);
        result = 31 * result + (idSala != null ? idSala.hashCode() : 0);
        result = 31 * result + (horaInicio != null ? horaInicio.hashCode() : 0);
        result = 31 * result + (horaFin != null ? horaFin.hashCode() : 0);
        result = 31 * result + (vigente ? 1 : 0);
        return result;
    }
}
