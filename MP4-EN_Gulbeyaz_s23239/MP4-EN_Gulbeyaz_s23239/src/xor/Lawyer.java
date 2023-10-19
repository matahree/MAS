package xor;

public class Lawyer {
    private String name;
    private LawFirm employerLawFirm;
    private Court employerCourt;

    public Lawyer(String name) {
        setName(name);
    }

    public void assignToLawFirm(LawFirm lawFirm) {
        if (employerCourt != null) {
            throw new IllegalArgumentException("This lawyer is already assigned to a court.");
        }
        employerLawFirm = lawFirm;
        lawFirm.addLawyer(this);
    }

    public void assignToCourt(Court court) {
        if (employerLawFirm != null) {
            throw new IllegalArgumentException("This lawyer is already assigned to a law firm.");
        }
        employerCourt = court;
        court.addLawyer(this);
    }
    public void removeFromLawFirm() {
        if (employerLawFirm != null) {
            employerLawFirm.removeLawyer(this);
            employerLawFirm = null;
        }
    }

    public void removeFromCourt() {
        if (employerCourt != null) {
            employerCourt.removeLawyer(this);
            employerCourt = null;
        }
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null and empty!");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LawFirm getEmployerLawFirm() {
        return employerLawFirm;
    }

    public Court getEmployerCourt() {
        return employerCourt;
    }
}