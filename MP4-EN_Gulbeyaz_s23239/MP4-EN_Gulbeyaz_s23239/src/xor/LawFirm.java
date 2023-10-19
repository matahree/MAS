package xor;

import java.util.ArrayList;
import java.util.List;

public class LawFirm {
    private String name;
    private String companyNumber;
    private List<Lawyer> lawyers;
    // USE SETTER METHODS IN CONTROCTOR

    public LawFirm(String name, String companyNumber) {
        setName(name);
        setCompanyNumber(companyNumber);
        lawyers = new ArrayList<>();
    }

    public void addLawyer(Lawyer lawyer) {
        if (lawyers.contains(lawyer)) {
            return;
        }
        for (Lawyer l : lawyers) {
            if (l.getEmployerCourt() == lawyer.getEmployerCourt()) {
                throw new IllegalArgumentException("This lawyer is already assigned to a court.");
            }
        }
        lawyers.add(lawyer);
        lawyer.assignToLawFirm(this);
    }

    public void removeLawyer(Lawyer lawyer) {
        if (lawyers.contains(lawyer)) {
            lawyers.remove(lawyer);
            lawyer.removeFromLawFirm();
        }
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null and empty!");
        }
        this.name = name;
    }

    public void setCompanyNumber(String companyNumber) {
        if (companyNumber == null || companyNumber.isEmpty()){
            throw new IllegalArgumentException("Company number cannot be null and empty!");
        }
        this.companyNumber = companyNumber;
    }

    public String getName() {
        return name;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public List<Lawyer> getLawyers() {
        return new ArrayList<>(lawyers);
    }
}