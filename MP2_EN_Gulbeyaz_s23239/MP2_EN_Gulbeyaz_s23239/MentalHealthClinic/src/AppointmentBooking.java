import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AppointmentBooking {

    private Appointment appointment;
    private Patient patient;

    private LocalDate startDate;
    private LocalDate endDate;

    private static List<AppointmentBooking> extent = new ArrayList<>();

    public AppointmentBooking(LocalDate startDate, LocalDate endDate, Appointment appointment, Patient patient) {
        setStartDate(startDate);
        setEndDate(endDate);
        setAppointment(appointment);
        setPatient(patient);
        if(appointmentBookingAlreadyExist(patient, appointment)){
            throw new IllegalArgumentException("Can not duplicate association");

        }
        extent.add(this);
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        if(startDate == null){
            throw new IllegalArgumentException("Start Date can not be null");
        }
        if (startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Start date cannot be in the future.");
        }
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        if (endDate == null) {
            throw new IllegalArgumentException("End date cannot be null.");
        }
        if (endDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("End date cannot be in the future.");
        }
        this.endDate = endDate;
    }


    public Appointment getAppointment() {
        return appointment;
    }
    // IT WILL BE PRIVATE
    private void setAppointment(Appointment appointment) {
        if(appointment == null){
            throw new IllegalArgumentException("Appointment can not be null");
        }
        this.appointment = appointment;
        appointment.setAppointmentBooking(this);
    }

    public Patient getPatient() {
        return patient;
    }

    // CHECK IF ITS NULL OR NOT TOO.
    private void setPatient(Patient patient) {
        if(appointment == null){
            throw new IllegalArgumentException("Patient can not be null");
        }
        this.patient = patient;
        patient.setAppointmentBooking(this);
    }
        // REMOVE FROM 4 REFERENCES
    public void remove(){
        if(this.appointment != null) {
            Appointment var = this.appointment;
            this.appointment = null;
            var.setAppointmentBooking(null);
        }
        if(this.patient != null) {
            Patient var = this.patient;
            this.patient = null;
            var.removeAppointmentBooking(this);
        }
    }

    private static boolean appointmentBookingAlreadyExist(Patient p, Appointment a){
       long count = extent.stream()
                .filter(app -> app.appointment == a && app.patient == p)
                .count();
       return count > 0;
    }
}
