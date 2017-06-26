package cl.ciisa.crscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Sala extends BaseEntity implements Serializable {
    private Long id;
    private String codigo;
    private Date horaInicio;
    private Date horaFin;
    private Campus campus;
    private Long campusId;
    private TipoSala tipoSala;
    private Long tipoSalaId;

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

    @ManyToOne
    @JoinColumn(name = "id_campus", referencedColumnName = "id", insertable = false, updatable = false)
    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    @Basic
    @Column(name = "id_campus")
    public Long getCampusId() {
        return campusId;
    }

    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id", insertable = false, updatable = false)
    public TipoSala getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(TipoSala tipoSala) {
        this.tipoSala = tipoSala;
    }

    @Basic
    @Column(name = "id_tipo")
    public Long getTipoSalaId() {
        return tipoSalaId;
    }

    public void setTipoSalaId(Long tipoSalaId) {
        this.tipoSalaId = tipoSalaId;
    }
}
