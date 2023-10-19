package xor;

import java.util.ArrayList;
import java.util.List;

public class Court {
    private String name;
    private String address;
    private List<Lawyer> lawyers;

    public Court(String name, String address) {
        setName(name);
        setAddress(address);
        lawyers = new ArrayList<>();
    }

    public void addLawyer(Lawyer lawyer) {
        if (lawyers.contains(lawyer)) {
            return;
        }
        for (Lawyer l : lawyers) {
            if (l.getEmployerLawFirm() == lawyer.getEmployerLawFirm()) {
                throw new IllegalArgumentException("This lawyer is already assigned to a law firm.");
            }
        }
        lawyers.add(lawyer);
        lawyer.assignToCourt(this);
    }

    public void removeLawyer(Lawyer lawyer) {
        if (lawyers.contains(lawyer)) {
            lawyers.remove(lawyer);
            lawyer.removeFromCourt();
        }
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be null and empty!");
        }
        this.name = name;
    }

    public void setAddress(String address) {
        if (address == null || address.isEmpty()){
            throw new IllegalArgumentException("Address cannot be null and empty!");
        }
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<Lawyer> getLawyers() {
        return new ArrayList<>(lawyers);
    }
}