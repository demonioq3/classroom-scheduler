package cl.ciisa.crs.business;

import cl.ciisa.crs.business.dummy.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.util.List;

/**
 * Created by agustinsantiago on 6/10/17.
 */
@Singleton(name = "EventManagerEJB")
public class EventManager {

    final Logger LOGGER = LoggerFactory.getLogger(EventManager.class);

    private List<Event> getEvents(){
        // TODO: Aquí se obtendrán todos los eventos desde la base de datos.
        return null;
    }

    private Event createEvent(Event event){
        // TODO: Crear un evento.
        return null;
    }

    private boolean deleteEvent(Event event){
        // TODO: Para eliminar un evento.
        return false;
    }

    private Event getById(Long eventId){
        // TODO: Se obtendrá el evento por ID;
        return null;
    }

    private List<Event> getEventsByRUT(String rut){
        // TODO: Aquí se obtendrán todos los eventos desde un rut X.
        return null;
    }

}
