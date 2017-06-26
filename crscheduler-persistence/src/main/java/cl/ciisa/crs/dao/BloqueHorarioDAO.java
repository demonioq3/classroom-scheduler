package cl.ciisa.crs.dao;

import cl.ciisa.crscheduler.domain.BloqueHorario;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by agustinsantiago on 6/18/17.
 */
@Stateless
public class BloqueHorarioDAO implements Serializable {

    @PersistenceContext(unitName = "CRPUnit")
    private EntityManager em;

    public BloqueHorario getById(Long id) {
        BloqueHorario bloqueHorario = em.find(BloqueHorario.class, id);

        return bloqueHorario;
    }

    public List<BloqueHorario> findAll() {
        List<BloqueHorario> resultList = em.createQuery("select i from BloqueHorario i ORDER BY i.id asc", BloqueHorario.class).getResultList();
        return cleanList(resultList);
    }

    private List<BloqueHorario> cleanList(List<BloqueHorario> bloqueHorarios) {
        List<BloqueHorario> cleanList = new ArrayList<BloqueHorario>();

        for (BloqueHorario bloqueHorario : bloqueHorarios) {
            em.detach(bloqueHorario);
        }

        cleanList.addAll(bloqueHorarios);

        return cleanList;
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

    public List<BloqueHorario> findByRut(String rut) {
        return em.createQuery("select i from BloqueHorario i where i.profesor.rut =:rut ORDER BY i.id asc", BloqueHorario.class)
                .setParameter("rut", rut).getResultList();
    }
}
