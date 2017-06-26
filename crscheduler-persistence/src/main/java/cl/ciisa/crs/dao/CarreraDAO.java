package cl.ciisa.crs.dao;

import cl.ciisa.crscheduler.domain.Carrera;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class CarreraDAO implements Serializable {

    @PersistenceContext(unitName = "CRPUnit")
    private EntityManager em;

    public Carrera getById(Long id) {
        Carrera carrera = em.find(Carrera.class, id);

        return carrera;
    }

    public List<Carrera> findAll() {
        return em.createQuery("select i from Carrera i ORDER BY i.id asc").getResultList();
    }

    public Carrera create(Carrera carrera) {

        em.persist(carrera);

        em.flush();

        return carrera;
    }

    public Carrera update(Carrera carrera) {
        if ( carrera == null )
            throw new IllegalArgumentException("carrera can't be null");

        Carrera updated = em.merge(carrera);
        em.flush();

        return updated;
    }

    public boolean delete(Carrera carrera) {

        Carrera toDelete = em.find(Carrera.class,carrera.getId());
        em.remove(toDelete);

        return true;
    }

}
