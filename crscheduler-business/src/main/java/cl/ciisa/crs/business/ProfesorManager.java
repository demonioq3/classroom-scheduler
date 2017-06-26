package cl.ciisa.crs.business;

import cl.ciisa.crs.dao.BloqueHorarioDAO;
import cl.ciisa.crs.dao.ProfesorDAO;
import cl.ciisa.crscheduler.domain.BloqueHorario;
import cl.ciisa.crscheduler.domain.Profesor;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by agustinsantiago on 6/10/17.
 */
@Singleton(name = "ProfesorManagerEJB")
public class ProfesorManager {

    final Logger LOGGER = LoggerFactory.getLogger(ProfesorManager.class);

    @EJB
    public ProfesorDAO profesorDAO;

    public List<String> findByName(String name){
        List<String> profesores = profesorDAO.findByName(name);
        return profesores;
    }

}
