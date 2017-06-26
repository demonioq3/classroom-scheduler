package cl.ciisa.crscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
@Table(name = "bloque_horario_reserva")
public class BloqueHorario extends BaseEntity implements Serializable {
    private Long id;
    private Profesor profesor;
    private Long idProfesor;
    private Sala sala;
    private Long idSala;
    private Date horaInicio;
    private Date horaFin;
    private boolean vigente;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id", insertable = false, updatable = false)
    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Basic
    @Column(name = "id_profesor", nullable = false, insertable = true, updatable = true)
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    @ManyToOne
    @JoinColumn(name = "id_sala", referencedColumnName = "id", insertable = false, updatable = false)
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
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

}
