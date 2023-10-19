package multi_inheritance;

import java.time.LocalDate;

public class InternTherapist extends Therapist implements IMedical {

    private String diagnosePatient;

    public InternTherapist(String certificationNumber, LocalDate certificationDate, String therapyType, String diagnosePatient) {
        super(certificationNumber, certificationDate, therapyType);
        setDiagnosePatient(diagnosePatient);
    }

    @Override
    public String getDiagnosePatient() {
        return diagnosePatient;
    }

    @Override
    public void setDiagnosePatient(String diagnosePatient) {
        if(diagnosePatient == null || diagnosePatient.isEmpty()){
            throw new IllegalArgumentException("Diagnose patient can not be null and empty!");
        }
        this.diagnosePatient = diagnosePatient;
    }
}
