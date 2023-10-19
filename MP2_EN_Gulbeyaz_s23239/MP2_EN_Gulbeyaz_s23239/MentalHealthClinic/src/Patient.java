import java.io.Serializable;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Patient extends Person implements Serializable {
    private MedicalHistory medicalHistory;

    private Set<AppointmentBooking> appointmentBooking = new HashSet<>();

    public Patient(Integer id, String firstName, String lastName, LocalDate dateOfBirth, MedicalHistory medicalHistory, Set<AppointmentBooking> appointmentBooking) {
        super(id, firstName, lastName, dateOfBirth);
        setMedicalHistory(medicalHistory);
        setAppointmentBooking(appointmentBooking);
    }

    public MedicalHistory getMedicalHistory() {
        return medicalHistory;
    }

    
    public void setMedicalHistory(MedicalHistory medicalHistory) {
        if (medicalHistory == null) {
            throw new IllegalArgumentException("Medical history cannot be null.");
        }

        if (!isValidMedicalHistory(medicalHistory)) {
            throw new IllegalArgumentException("Invalid medical history.");
        }
        this.medicalHistory = medicalHistory;
    }

    private boolean isValidMedicalHistory(MedicalHistory medicalHistory) {
        if (medicalHistory == null) {
            return false;
        }
        return true;
    }

    // UNMODIFIABLE AND COPY
    public Set<AppointmentBooking> getAppointmentBooking() {
        return Collections.unmodifiableSet(appointmentBooking);
    }

    public void addAppointmentBooking(AppointmentBooking e){
        if(e == null){
            throw new IllegalArgumentException("Appointment booking can not be null");
        }
        if(this.appointmentBooking.contains(e)){
            return;
        }
        if(e.getPatient() != this){
            throw new IllegalArgumentException("Appointment booking is not related to patient");
        }
        this.appointmentBooking.add(e);
    }

    public void removeAppointmentBooking(AppointmentBooking e){
        if(this.appointmentBooking.contains(e)){
            return;
        }
        this.appointmentBooking.remove(e);
        e.remove();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", middleName='" + getMiddleName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", dateOfBirth=" + getDateOfBirth() +
                ", medicalHistory='" + getMedicalHistory() + '\'' +
                '}';
    }



    public void setAppointmentBooking(Object o) {
        if (this.appointmentBooking == o) {
            return;
        }
        if (o != null) {
            this.appointmentBooking = (Set<AppointmentBooking>) o;
        }
        else if (this.appointmentBooking != null) {
            this.appointmentBooking = null;
        }
    }
}
