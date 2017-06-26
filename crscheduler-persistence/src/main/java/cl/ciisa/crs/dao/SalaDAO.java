package cl.ciisa.crs.dao;

import cl.ciisa.crscheduler.domain.Sala;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class SalaDAO implements Serializable {

    @PersistenceContext(unitName = "CRPUnit")
    private EntityManager em;

    public Sala getById(Long id) {
        Sala sala = em.find(Sala.class, id);

        return sala;
    }

    public List<Sala> findAll() {
        return em.createQuery("select i from Sala i ORDER BY i.id asc").getResultList();
    }

    public Sala create(Sala sala) {

        em.persist(sala);

        em.flush();

        return sala;
    }

    public Sala update(Sala sala) {
        if ( sala == null )
            throw new IllegalArgumentException("sala can't be null");

        Sala updated = em.merge(sala);
        em.flush();

        return updated;
    }

    public boolean delete(Sala sala) {

        Sala toDelete = em.find(Sala.class,sala.getId());
        em.remove(toDelete);

        return true;
    }

}
