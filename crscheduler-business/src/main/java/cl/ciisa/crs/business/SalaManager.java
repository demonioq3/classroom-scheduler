package cl.ciisa.crs.business;

import cl.ciisa.crs.dao.ProfesorDAO;
import cl.ciisa.crs.dao.SalaDAO;
import cl.ciisa.crscheduler.domain.Sala;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.List;

/**
 * Created by agustinsantiago on 6/10/17.
 */
@Singleton(name = "SalaManagerEJB")
public class SalaManager {

    final Logger LOGGER = LoggerFactory.getLogger(SalaManager.class);

    @EJB
    public SalaDAO salaDAO;

    public List<Sala> findAll(){
        return salaDAO.findAll();
    }

}
