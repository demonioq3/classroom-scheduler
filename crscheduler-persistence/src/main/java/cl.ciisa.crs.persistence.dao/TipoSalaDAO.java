package cl.ciisa.crs.persistence.dao;

import cl.ciisa.crs.domain.Sala;
import cl.ciisa.crs.domain.TipoSala;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class TipoSalaDAO implements Serializable {

    @PersistenceContext(unitName = "crPersistenceUnit")
    private EntityManager em;

    public TipoSala getById(Long id) {
        TipoSala tipoSala = em.find(TipoSala.class, id);

        em.detach(tipoSala);
        return tipoSala;
    }

    public List<TipoSala> findAll() {
        return em.createQuery("select i from TipoSala i ORDER BY i.id asc").getResultList();
    }

    public TipoSala create(TipoSala tipoSala) {

        em.persist(tipoSala);

        em.flush();

        return tipoSala;
    }

    public TipoSala update(TipoSala tipoSala) {
        if ( tipoSala == null )
            throw new IllegalArgumentException("tipoSala can't be null");

        TipoSala updated = em.merge(tipoSala);
        em.flush();

        return updated;
    }

    public boolean delete(TipoSala tipoSala) {

        TipoSala toDelete = em.find(TipoSala.class,tipoSala.getId());
        em.remove(toDelete);

        return true;
    }

}
