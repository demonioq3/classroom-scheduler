package cl.ciisa.crs.persistence.dao;

import cl.ciisa.crs.domain.BloqueHorario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class BloqueHorarioDAO implements Serializable {

    @PersistenceContext(unitName = "crPersistenceUnit")
    private EntityManager em;

    public BloqueHorario getById(Long id) {
        BloqueHorario bloqueHorario = em.find(BloqueHorario.class, id);

        em.detach(bloqueHorario);
        return bloqueHorario;
    }

    public List<BloqueHorario> findAll() {
        return em.createQuery("select i from BloqueHorario i ORDER BY i.id asc").getResultList();
    }

    public BloqueHorario create(BloqueHorario bloqueHorario) {

        em.persist(bloqueHorario);

        em.flush();

        return bloqueHorario;
    }

    public BloqueHorario update(BloqueHorario bloqueHorario) {
        if ( bloqueHorario == null )
            throw new IllegalArgumentException("bloqueHorario can't be null");

        BloqueHorario updated = em.merge(bloqueHorario);
        em.flush();

        return updated;
    }

    public boolean delete(BloqueHorario bloqueHorario) {

        BloqueHorario toDelete = em.find(BloqueHorario.class,bloqueHorario.getId());
        em.remove(toDelete);

        return true;
    }

}
