package bag;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
// CREATE AN ADD AND REMOVE METHODS FOR EACH CLASS ALWAYS
// IT WILL INCLUDE NULL CHECK AND BACK REFERENCES, ALSO WE SHOULD CHECK IF ITS EXIST BEFORE ALL THE TIME.
public class Appointment {
    private LocalDateTime dateTime;
    private String description;
    private Set<Prescription> prescriptions = new HashSet<>();

    public Appointment(LocalDateTime dateTime, String description) {
        setDateTime(dateTime);
        setDescription(description);
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        if(dateTime == null) {
            throw new IllegalArgumentException("DateTime cannot be null.");
        }
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description == null || description.isEmpty()){
            throw new IllegalArgumentException("Description can not be null and empty");
        }
        this.description = description;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void addPrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Prescription cannot be null.");
        }
//        if (prescriptions.contains(prescription)) {
//            throw new IllegalArgumentException("Prescription already exists.");
//        }

        prescriptions.add(prescription);
        prescription.setAppointment(this);
    }

    public void removePrescription(Prescription prescription) {
        if (prescription == null) {
            throw new IllegalArgumentException("Prescription cannot be null");
        }
        prescriptions.remove(prescription);
        prescription.setAppointment(null);
    }
}