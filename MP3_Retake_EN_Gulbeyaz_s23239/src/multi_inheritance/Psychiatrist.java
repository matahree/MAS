package multi_inheritance;

import java.time.LocalDate;

public class Psychiatrist extends MentalHealthProfessional implements IMedical {

    private String diagnosePatient;

    public Psychiatrist(String certificationNumber, LocalDate certificationDate, String diagnosePatient) {
        super(certificationNumber, certificationDate);
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
