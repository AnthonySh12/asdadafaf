package DataAccessComponent.DTO;

public class CitaDTO {
    private Integer idCita;
    private String personaDoctor;
    private String personaPaciente;
    private String fechaCita;
    private String horaCita;
    private String observacion;
    private String estadoCita;
    private String fechaCreacion;
    private String fechaModificacion;

    public CitaDTO(){}

    public CitaDTO(String personaDoctor, String personaPaciente, String fechaCita, 
                   String horacita, String observacion, String estadoCita) {
        setPersonaDoctor(personaDoctor);
        setPersonaPaciente(personaPaciente);
        setFechaCita(fechaCita);
        setHoraCita(horacita);
        setObservacion(observacion);
        setEstadoCita(estadoCita);
    }

    public CitaDTO(Integer idCita, String personaDoctor, String personaPaciente, String fechaCita, 
                   String horacita, String observacion, String estadoCita, 
                   String fechaCreacion, String fechaModificacion) {
        setIdCita(idCita);
        setPersonaDoctor(personaDoctor);
        setPersonaPaciente(personaPaciente);
        setFechaCita(fechaCita);
        setHoraCita(horacita);
        setObservacion(observacion);
        setEstadoCita(estadoCita);
        setFechaCreacion(fechaCreacion);
        setFechaModificacion(fechaModificacion);
    }
    public Integer getIdCita() {
        return idCita;
    }
    public void setIdCita(Integer idCita) {
        this.idCita = idCita;
    }
    public String getPersonaDoctor() {
        return personaDoctor;
    }
    public void setPersonaDoctor(String personaDoctor) {
        this.personaDoctor = personaDoctor;
    }
    public String getPersonaPaciente() {
        return personaPaciente;
    }
    public void setPersonaPaciente(String personaPaciente) {
        this.personaPaciente = personaPaciente;
    }
    public String getFechaCita() {
        return fechaCita;
    }
    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }
    public String getHoraCita() {
        return horaCita;
    }
    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getEstadoCita() {
        return estadoCita;
    }
    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }
    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getFechaModificacion() {
        return fechaModificacion;
    }
    public void setFechaModificacion(String fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String toString(){
        return getClass().getName() 
        + "\n idCita             : "+ getIdCita           ()
        + "\n Doctor             : "+ getPersonaDoctor    ()          
        + "\n Paciente           : "+ getPersonaPaciente  ()             
        + "\n Fecha de la cita   : "+ getFechaCita        ()
        + "\n Hora de la cita    : "+ getHoraCita         ()
        + "\n Observación        : "+ getObservacion      ()
        + "\n Estado de la cita  : "+ getEstadoCita       ()
        + "\n FechaCreacion      : "+ getFechaCreacion    ()
        + "\n FechaModificacion  : "+ getFechaModificacion();
    }
}
