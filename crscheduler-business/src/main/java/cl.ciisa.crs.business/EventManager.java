package cl.ciisa.crs.business;

import cl.ciisa.crs.business.dummy.DateComparator;
import cl.ciisa.crs.business.dummy.Event;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.util.*;

/**
 * Created by agustinsantiago on 6/10/17.
 */
@Singleton(name = "EventManagerEJB")
public class EventManager {

    final Logger LOGGER = LoggerFactory.getLogger(EventManager.class);

    public List<Event> getEvents(){
        // TODO: Aquí se obtendrán todos los eventos desde la base de datos.
        return null;
    }

    public Event createEvent(Event event){
        // TODO: Crear un evento.
        return null;
    }

    public boolean deleteEvent(Event event){
        // TODO: Para eliminar un evento.
        return false;
    }

    public Event getById(Long eventId){
        // TODO: Se obtendrá el evento por ID;
        return null;
    }

    public List<Event> getEventsByRUT(String rut){
        // TODO: Aquí se obtendrán todos los eventos desde un rut X.
        return null;
    }

    /**
     * This method check if 2 ranges of dates is overlaped.
     * @param start1 of interval 1.
     * @param end1 of interval 1.
     * @param events is a list of events in calendar.
     * @return true if is overlaped, false otherwise.
     */
    public boolean isOverLaped(Date start1, Date end1, List<Event> events) {
        DateTime start1time = new DateTime(start1);
        DateTime end1time = new DateTime(end1);

        Interval interval = new Interval(start1time, end1time);

        for (Event event : events) {
            DateTime start2time = new DateTime(event.getFechaDesde());
            DateTime end2time = new DateTime(event.getFechaHasta());

            Interval interval2 = new Interval(start2time, end2time);

            if(interval.overlaps(interval2))
                return true;
        }

        return false;
    }

    public DateComparator getDatesByBloque(String bloque, Date startDate) {
        DateComparator dateComparator = new DateComparator();

        int option = Integer.valueOf(bloque);
        Date currentSelectedDate = startDate;

        Calendar calFrom = Calendar.getInstance();
        calFrom.setTime(currentSelectedDate);

        Calendar calTo = Calendar.getInstance();
        calTo.setTime(currentSelectedDate);

        switch (option) {
            case 1:
                calFrom.set(Calendar.HOUR, 8);
                calFrom.set(Calendar.MINUTE, 15);

                calTo.set(Calendar.HOUR, 9);
                calTo.set(Calendar.MINUTE, 45);
                break;
            case 2:
                calFrom.set(Calendar.HOUR, 10);
                calFrom.set(Calendar.MINUTE, 00);

                calTo.set(Calendar.HOUR, 11);
                calTo.set(Calendar.MINUTE, 30);
                break;
            case 3:
                calFrom.set(Calendar.HOUR, 11);
                calFrom.set(Calendar.MINUTE, 45);

                calTo.set(Calendar.HOUR, 13);
                calTo.set(Calendar.MINUTE, 15);
                break;
            case 4:
                calFrom.set(Calendar.HOUR, 14);
                calFrom.set(Calendar.MINUTE, 00);

                calTo.set(Calendar.HOUR, 15);
                calTo.set(Calendar.MINUTE, 30);
                break;
            case 5:
                calFrom.set(Calendar.HOUR, 15);
                calFrom.set(Calendar.MINUTE, 40);

                calTo.set(Calendar.HOUR, 17);
                calTo.set(Calendar.MINUTE, 10);
                break;
            case 6:
                calFrom.set(Calendar.HOUR, 17);
                calFrom.set(Calendar.MINUTE, 20);

                calTo.set(Calendar.HOUR, 18);
                calTo.set(Calendar.MINUTE, 50);
                break;
            case 7:
                calFrom.set(Calendar.HOUR, 18);
                calFrom.set(Calendar.MINUTE, 50);

                calTo.set(Calendar.HOUR, 20);
                calTo.set(Calendar.MINUTE, 10);
                break;
            case 8:
                calFrom.set(Calendar.HOUR, 20);
                calFrom.set(Calendar.MINUTE, 10);

                calTo.set(Calendar.HOUR, 21);
                calTo.set(Calendar.MINUTE, 45);
                break;
            case 9:
                calFrom.set(Calendar.HOUR, 21);
                calFrom.set(Calendar.MINUTE, 45);

                calTo.set(Calendar.HOUR, 22);
                calTo.set(Calendar.MINUTE, 30);
                break;
        }

        dateComparator.setDate1(calFrom.getTime());
        dateComparator.setDate2(calTo.getTime());

        return dateComparator;
    }

    public String getBloqueByDates(Date startDate, Date endDate) {
        Calendar startCalendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        startCalendar.setTime(startDate);   // assigns calendar to given date
        int hourFrom = startCalendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        int minutesFrom = startCalendar.get(Calendar.MINUTE);

        Calendar endCalendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        endCalendar.setTime(endDate);   // assigns calendar to given date
        int hourTo = endCalendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        int minutesTo = endCalendar.get(Calendar.MINUTE);

        if(hourFrom == 8 && minutesFrom == 15 && hourTo == 9 && minutesTo == 45){
            return "1";
        } else if(hourFrom == 10 && minutesFrom == 0 && hourTo == 11 && minutesTo == 30) {
            return "2";
        } else if(hourFrom == 11 && minutesFrom == 45 && hourTo == 13 && minutesTo == 15) {
            return "3";
        } else if(hourFrom == 14 && minutesFrom == 0 && hourTo == 15 && minutesTo == 30) {
            return "4";
        } else if(hourFrom == 15 && minutesFrom == 40 && hourTo == 17 && minutesTo == 10) {
            return "5";
        } else if(hourFrom == 17 && minutesFrom == 20 && hourTo == 18 && minutesTo == 50) {
            return "6";
        } else if(hourFrom == 18 && minutesFrom == 50 && hourTo == 20 && minutesTo == 10) {
            return "7";
        } else if(hourFrom == 20 && minutesFrom == 10 && hourTo == 21 && minutesTo == 45) {
            return "8";
        } else if(hourFrom == 21 && minutesFrom == 45 && hourTo == 22 && minutesTo == 30) {
            return "9";
        }

        return "0";
    }
}
