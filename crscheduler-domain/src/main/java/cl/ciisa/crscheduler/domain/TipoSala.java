package cl.ciisa.crscheduler.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by agustinsantiago on 6/17/17.
 */
@Entity
@Table(name = "sala_tipo", schema = "crscheduler", catalog = "")
public class TipoSala extends BaseEntity implements Serializable {
    private Long id;
    private String nombre;

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

}
