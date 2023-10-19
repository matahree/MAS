package multi_inheritance;

import java.time.LocalDate;

public class MentalHealthProfessional {

    private String certificationNumber;
    private LocalDate certificationDate;

    public MentalHealthProfessional(String certificationNumber, LocalDate certificationDate) {
        setCertificationNumber(certificationNumber);
        setCertificationDate(certificationDate);
    }

    public String getCertificationNumber() {
        return certificationNumber;
    }

    public void setCertificationNumber(String certificationNumber) {
        if(certificationNumber == null || certificationNumber.isEmpty()){
            throw new IllegalArgumentException("Certification number can not be null and empty!");
        }
        this.certificationNumber = certificationNumber;
    }

    public LocalDate getCertificationDate() {
        return certificationDate;
    }

    public void setCertificationDate(LocalDate certificationDate) {
        if(certificationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Certification date value cannot be from the future.");
        }
        this.certificationDate = certificationDate;
    }
}
