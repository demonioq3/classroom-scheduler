package cl.ciisa.cr.beans;

import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import cl.ciisa.crs.business.BloqueHorarioManager;
import cl.ciisa.crs.business.ProfesorManager;
import cl.ciisa.crs.business.SalaManager;
import cl.ciisa.crs.business.dummy.DateComparator;
import cl.ciisa.crs.business.dummy.Event;
import cl.ciisa.crscheduler.domain.BloqueHorario;
import cl.ciisa.crscheduler.domain.Sala;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@ManagedBean
@ViewScoped
public class ScheduleView extends BaseBean implements Serializable {

    private ScheduleModel eventModel;

    private ScheduleEvent event = new DefaultScheduleEvent();

    private Event selectedEvent;

    private List<BloqueHorario> bloques;

    public boolean withRange = true;

    @EJB
    public BloqueHorarioManager bloqueHorarioManager;

    @EJB
    public ProfesorManager profesorManager;

    @EJB
    public SalaManager salaManager;

    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();

        List<BloqueHorario> bloques = bloqueHorarioManager.getBloquesHorario();

        for (BloqueHorario bloque : bloques) {
            eventModel.addEvent(new DefaultScheduleEvent(bloque.getSala().getCodigo() + " \n Profesor asignado: " + bloque.getProfesor().getNombre() + " " + bloque.getProfesor().getAprellidos(), bloque.getHoraInicio(), bloque.getHoraFin()));
        }

        selectedEvent = new Event();
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    private Calendar today() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE), 0, 0, 0);

        return calendar;
    }

    public void deleteEvent(){
        eventModel.deleteEvent(event);
    }

    private Date previousDay8Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 8);

        return t.getTime();
    }

    private Date previousDay11Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) - 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date today1Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 1);

        return t.getTime();
    }

    private Date theDayAfter3Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 2);
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    private Date today6Pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.HOUR, 6);

        return t.getTime();
    }

    private Date nextDay9Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 9);

        return t.getTime();
    }

    private Date nextDay11Am() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.AM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 1);
        t.set(Calendar.HOUR, 11);

        return t.getTime();
    }

    private Date fourDaysLater3pm() {
        Calendar t = (Calendar) today().clone();
        t.set(Calendar.AM_PM, Calendar.PM);
        t.set(Calendar.DATE, t.get(Calendar.DATE) + 4);
        t.set(Calendar.HOUR, 3);

        return t.getTime();
    }

    public List<Sala> getAllSalas(){
        return salaManager.findAll();
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent(ActionEvent actionEvent) {
        HashMap<String, List<Event>> freshEventList = getFreshEventList(eventModel);

        if(!withRange){
            DateComparator dateComparator = bloqueHorarioManager.getDatesByBloque(selectedEvent.getBloque(), event.getStartDate());

            selectedEvent.setFechaDesde(dateComparator.getDate1());
            selectedEvent.setFechaHasta(dateComparator.getDate2());
        }

        if(event.getId() == null){
            if(bloqueHorarioManager.isOverLaped(selectedEvent.getFechaDesde(), selectedEvent.getFechaHasta(), freshEventList.get(selectedEvent.getSala()))){
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al solicitar", "La sala está ocupada en ése rango horario.");

                addMessage(message);
                return;
            }

            if(!withRange){
                DateComparator datesToAdd = bloqueHorarioManager.getDatesByBloque(this.selectedEvent.getBloque(), event.getStartDate());

                eventModel.addEvent(new DefaultScheduleEvent(selectedEvent.getSala() + " \n Profesor asignado: " + selectedEvent.getProfesor(), datesToAdd.getDate1(), datesToAdd.getDate2()));
            } else {
                eventModel.addEvent(new DefaultScheduleEvent(selectedEvent.getSala() + " \n Profesor asignado: " + selectedEvent.getProfesor(), selectedEvent.getFechaDesde(), selectedEvent.getFechaHasta()));
            }
        }
        else {
            DefaultScheduleEvent defaultScheduleEvent = (DefaultScheduleEvent) event;

            defaultScheduleEvent.setTitle(selectedEvent.getSala() + " \n Profesor asignado: " + selectedEvent.getProfesor());
            ((DefaultScheduleEvent) event).setStartDate(selectedEvent.getFechaDesde());
            ((DefaultScheduleEvent) event).setEndDate(selectedEvent.getFechaHasta());

            eventModel.updateEvent(event);
        }

        event = new DefaultScheduleEvent();
    }

    private HashMap<String, List<Event>> getFreshEventList(ScheduleModel eventModel) {
        List<Event> freshEvents = new ArrayList<Event>();
        HashMap<String, List<Event>> eventsBySala = new HashMap<String, List<Event>>();

        for (ScheduleEvent scheduleEvent : eventModel.getEvents()) {
            String sala = scheduleEvent.getTitle().split("\\n")[0].substring(0, scheduleEvent.getTitle().split("\\n")[0].length() -1);
            List<Event> eventList = new ArrayList<Event>();

            if(!eventsBySala.containsKey(sala)){
                Event event = new Event();
                event.setFechaDesde(scheduleEvent.getStartDate());
                event.setFechaHasta(scheduleEvent.getEndDate());

                eventList.add(event);

                eventsBySala.put(sala, eventList);
            } else {
                List<Event> eventFromHash = eventsBySala.get(sala);

                Event event = new Event();
                event.setFechaDesde(scheduleEvent.getStartDate());
                event.setFechaHasta(scheduleEvent.getEndDate());

                eventFromHash.add(event);
            }
        }

        return eventsBySala;
    }

    public void onEventSelect(SelectEvent selectEvent) {
        event = (ScheduleEvent) selectEvent.getObject();
        selectedEvent.setSala(event.getTitle().split("\\n")[0].substring(0, event.getTitle().split("\\n")[0].length() - 1));
        selectedEvent.setProfesor(event.getTitle().split("\\n")[1].replace(" Profesor asignado: ", ""));
        selectedEvent.setBloque(bloqueHorarioManager.getBloqueByDates((Date) ((ScheduleEvent) selectEvent.getObject()).getStartDate(), (Date) ((ScheduleEvent) selectEvent.getObject()).getEndDate()));
        selectedEvent.setFechaDesde((Date) ((ScheduleEvent) selectEvent.getObject()).getStartDate());
        selectedEvent.setFechaHasta((Date) ((ScheduleEvent) selectEvent.getObject()).getEndDate());
    }

    public void onDateSelect(SelectEvent selectEvent) {
        event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        selectedEvent.setProfesor("");
        selectedEvent.setSala("");
        selectedEvent.setFechaDesde((Date) selectEvent.getObject());
        selectedEvent.setFechaHasta((Date) selectEvent.getObject());
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio exitoso", "Dia:" + event.getDayDelta() + ", Minuto:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cambio exitoso", "Dia:" + event.getDayDelta() + ", Minuto:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public List<String> completeText(String query) {
        List<String> byName = profesorManager.findByName(query.toUpperCase());

        return byName;
    }


    public Event getSelectedEvent() {
        return selectedEvent;
    }

    public void setSelectedEvent(Event selectedEvent) {
        this.selectedEvent = selectedEvent;
    }

    public boolean isWithRange() {
        return withRange;
    }

    public void setWithRange(boolean withRange) {
        this.withRange = withRange;
    }

    public void lol(){

    }

    public List<BloqueHorario> getBloques() {
        return bloques;
    }

    public void setBloques(List<BloqueHorario> bloques) {
        this.bloques = bloques;
    }
}