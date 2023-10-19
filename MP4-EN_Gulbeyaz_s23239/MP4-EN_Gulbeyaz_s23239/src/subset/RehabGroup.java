package subset;

import java.time.LocalDateTime;

public class RehabGroup extends ObjectPlus4 {

    // IF I WANT TO USE OBJECTPLUS FIRST I HAVE TO USE THAT METHOD IN A CLASS, MAYBE HERE OR IN PATIENT.
    // I CREATED SOME roleOrganizedBy STUFF BUT DIDN'T USE THEM ANYWHERE
    // BASICALLY I NEED TO GENERATE A METHOD AND IN THIS METHOD I NEED TO USE OBJECT PLUS

    // I CAN ALSO USE MANUAL IMPLEMENTATION WHICH IS SO MUCH EASIER TO DO. I DONT NEED TO USE OBJECTPLUS 4
    // ITS WRITTEN HOW TO USE MANUL REGULAR CHECKS IN HIS WEBSITE. SAME AS  REGULAR CHECKS FOR PREVOUIS METHODS
    private String name;
    private LocalDateTime startTime, endTime;

    public RehabGroup(String name, LocalDateTime startTime, LocalDateTime endTime) {
        setName(name);
        setStartTime(startTime);
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null nor empty.");
        }
        this.name = name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null.");
        } else if (startTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Upload date cannot be from the future.");
        }
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        if (endTime == null) {
            throw new IllegalArgumentException("End time cannot be null.");
        } else if (endTime.isBefore(this.startTime)) {
            throw new IllegalArgumentException("Upload date cannot be from the future.");
        }
        this.endTime = endTime;
    }

    public static final String roleParticipantsOf = "participants of";
    public static final String roleOrganizedBy = "organized by";

    @Override
    public String toString() {
        return "RehabGroup{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}