package subset.NEWone;

import java.util.HashSet;
import java.util.Set;

public class MedicalRecord {
    private int recordId;

    private final Set<Patient> accessedBy = new HashSet<>();
    private final Set<Patient> markedAsImportantFor = new HashSet<>();

    public MedicalRecord(int recordId) {
        setRecordId(recordId);
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        if (recordId < 0) {
            throw new IllegalArgumentException("Record ID cannot be negative");
        }
        this.recordId = recordId;
    }

    public void addAccessedFor(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        if (!accessedBy.contains(patient)) {
            accessedBy.add(patient);
            patient.grantAccessToMedicalRecord(this);
        }
    }

    public void removeAccessedBy(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        if (markedAsImportantFor.contains(patient)) {
            unmarkAsImportantFor(patient);
        }
        if (accessedBy.contains(patient)) {
            accessedBy.remove(patient);
            patient.revokeAccessToMedicalRecord(this);
        }
    }

    public void markAsImportantFor(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        if (!accessedBy.contains(patient)) {
            throw new IllegalArgumentException("Patient cannot mark an inaccessible medical record as important");
        }
        if (!markedAsImportantFor.contains(patient)) {
            markedAsImportantFor.add(patient);
            patient.markAsImportant(this);
        }
    }

    public void unmarkAsImportantFor(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        if (markedAsImportantFor.contains(patient)) {
            markedAsImportantFor.remove(patient);
            patient.unmarkAsImportant(this);
        }
    }
}
