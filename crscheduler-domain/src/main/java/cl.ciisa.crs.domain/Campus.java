package cl.ciisa.crs.domain;

import javax.persistence.*;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
public class Campus extends BaseEntity {
    private Long id;
    private String direccion;
    private Institucion institucion;
    private Long idInstitucion;

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
    @Column(name = "direccion")
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @ManyToOne
    @JoinColumn(name = "id_institucioneducacional")
    public Institucion getInstitucion() {
        return institucion;
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    @Basic
    @Column(name = "id_institucioneducacional")
    public Long getIdInstitucion() {
        return idInstitucion;
    }

    public void setIdInstitucion(Long idInstitucion) {
        this.idInstitucion = idInstitucion;
    }
}
