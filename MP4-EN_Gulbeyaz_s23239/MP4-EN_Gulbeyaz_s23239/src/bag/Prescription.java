package bag;
public class Prescription {
    private Appointment appointment;
    private Medication medication;
    private int dosage;

    public Prescription(Appointment appointment, Medication medication, int dosage) {
        setAppointment(appointment);
        setMedication(medication);
        setDosage(dosage);
    }

    public void setDosage(int dosage) {
        if (dosage < 0) {
            throw new IllegalArgumentException("Dosage cannot be negative.");
        }
        this.dosage = dosage;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null.");
        }

        if (this.appointment != null && this.appointment != appointment) {
            throw new IllegalStateException("Prescription already has an associated appointment.");
        }

        this.appointment = appointment;
        appointment.getPrescriptions().add(this);
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        if (medication == null) {
            throw new IllegalArgumentException("Medication cannot be null.");
        }

        if (this.medication != null && this.medication != medication) {
            throw new IllegalStateException("Prescription already has an associated medication.");
        }

        this.medication = medication;
        medication.getPrescriptions().add(this);
    }

    public int getDosage() {
        return dosage;
    }

    public void removeAssociation() {
        // remove from appointment
        if (appointment != null) {
            appointment.getPrescriptions().remove(this);
            appointment = null;
        }
        // remove from medication
        if (medication != null) {
            medication.getPrescriptions().remove(this);
            medication = null;
        }
    }
}
