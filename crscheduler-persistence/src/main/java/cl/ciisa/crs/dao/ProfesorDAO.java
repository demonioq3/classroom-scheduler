package cl.ciisa.crs.dao;

import cl.ciisa.crscheduler.domain.Profesor;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class ProfesorDAO implements Serializable {

    @PersistenceContext(unitName = "CRPUnit")
    private EntityManager em;

    public Profesor getById(Long id) {
        Profesor profesor = em.find(Profesor.class, id);

        return profesor;
    }

    public List<Profesor> findAll() {
        return em.createQuery("select i from Profesor i ORDER BY i.id asc").getResultList();
    }

    public Profesor create(Profesor profesor) {

        em.persist(profesor);

        em.flush();

        return profesor;
    }

    public Profesor update(Profesor profesor) {
        if ( profesor == null )
            throw new IllegalArgumentException("profesor can't be null");

        Profesor updated = em.merge(profesor);
        em.flush();

        return updated;
    }

    public boolean delete(Profesor profesor) {

        Profesor toDelete = em.find(Profesor.class,profesor.getId());
        em.remove(toDelete);

        return true;
    }

}
