package cl.ciisa.crs.dao;

import cl.ciisa.crscheduler.domain.Institucion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class InstitucionDAO implements Serializable {

    @PersistenceContext(unitName = "CRPUnit")
    private EntityManager em;

    public Institucion getById(Long id) {
        Institucion institucion = em.find(Institucion.class, id);

        return institucion;
    }

    public List<Institucion> findAll() {
        return em.createQuery("select i from Institucion i ORDER BY i.id asc").getResultList();
    }

    public Institucion create(Institucion institucion) {

        em.persist(institucion);

        em.flush();

        return institucion;
    }

    public Institucion update(Institucion institucion) {
        if ( institucion == null )
            throw new IllegalArgumentException("institucion can't be null");

        Institucion updated = em.merge(institucion);
        em.flush();

        return updated;
    }

    public boolean delete(Institucion institucion) {

        Institucion toDelete = em.find(Institucion.class,institucion.getId());
        em.remove(toDelete);

        return true;
    }

}
