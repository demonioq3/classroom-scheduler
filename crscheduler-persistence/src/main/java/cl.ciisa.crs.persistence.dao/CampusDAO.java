package cl.ciisa.crs.persistence.dao;

import cl.ciisa.crs.domain.BloqueHorario;
import cl.ciisa.crs.domain.Campus;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class CampusDAO implements Serializable {

    @PersistenceContext(unitName = "crPersistenceUnit")
    private EntityManager em;

    public Campus getById(Long id) {
        Campus campus = em.find(Campus.class, id);

        em.detach(campus);
        return campus;
    }

    public List<Campus> findAll() {
        return em.createQuery("select i from Campus i ORDER BY i.id asc").getResultList();
    }

    public Campus create(Campus campus) {

        em.persist(campus);

        em.flush();

        return campus;
    }

    public Campus update(Campus campus) {
        if ( campus == null )
            throw new IllegalArgumentException("campus can't be null");

        Campus updated = em.merge(campus);
        em.flush();

        return updated;
    }

    public boolean delete(Campus campus) {

        Campus toDelete = em.find(Campus.class,campus.getId());
        em.remove(toDelete);

        return true;
    }

}
