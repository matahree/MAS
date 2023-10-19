import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

public class Appointment implements Serializable {
    private int id;
    private Time startTime;
    private Time endTime;
    private Date startDate;
    private Date endDate;
    private String status;
    private Patient patient;
    private MentalHealthProfessional professional;  // instance variable  that represents the mental health professional involved in the appointment

    public Appointment(int id, Time startTime, Time endTime, Date startDate, Date endDate, String status, Patient patient, MentalHealthProfessional professional) {
        setId(id);
        setStartTime(startTime);
        setEndTime(endTime);
        setStartDate(startDate);
        setEndDate(endDate);
        setStatus(status);
        setPatient(patient);
        setProfessional(professional);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public MentalHealthProfessional getProfessional() {
        return professional;
    }

    public void setProfessional(MentalHealthProfessional professional) {
        this.professional = professional;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.trim().isEmpty()) {
            throw new IllegalArgumentException("Status cannot be null or empty");
        }
        if (!("Scheduled".equals(status) || "Completed".equals(status) || "Cancelled".equals(status))) {
            throw new IllegalArgumentException("Invalid status value");
        }
        this.status = status;
    }

    public void rescheduleAppointment(Time newStartTime, Time newEndTime, Date newStartDate, Date newEndDate) {
        setStartTime(newStartTime);
        setEndTime(newEndTime);
        setStartDate(newStartDate);
        setEndDate(newEndDate);
    }

    public void cancelAppointment() {
        setStatus("Cancelled");
    }

    public String getAppointmentStatus() {
        return getStatus();
    }

    public boolean isAppointmentOnDate(Date date) {
        if (date == null) {
            return false;
        }
        return date.equals(startDate);
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + getId() +
                ", startTime=" + getStartTime() +
                ", endTime=" + getEndTime() +
                ", startDate=" + getStartDate() +
                ", endDate=" + getEndDate() +
                ", status='" + getStatus() + '\'' +
                ", patient=" + getPatient() +
                '}';
    }



}
