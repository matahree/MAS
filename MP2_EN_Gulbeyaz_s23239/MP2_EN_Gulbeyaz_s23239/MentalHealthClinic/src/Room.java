import java.io.Serializable;
import java.util.Collections;
import java.util.Set;

public class Room implements Serializable {
    private int id;
    private String name;
    private Integer capacity;

    private Set<Appointment> appoint;

    public Room(int id, String name, Integer capacity, Appointment appointment) {
        setId(id);
        setName(name);
        setCapacity(capacity);
        addAppointment(appointment);            // we will have at least one appointment when we crate a room
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id < 0){
            throw new IllegalArgumentException("Id can not be negative");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name can not be null and empty.");
        }
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        if(capacity == null) {
            throw new IllegalArgumentException("Capacity can not be null.");
        }
        this.capacity = capacity;
    }

    public Set<Appointment> getAppoint() {
        return Collections.unmodifiableSet(appoint);
    }

    public void addAppointment(Appointment e){
    if(e == null){
        throw new IllegalArgumentException("Appointment can not be null");
    }

    if(this.appoint.contains(e)){
        return;
    }
     this.appoint.add(e);
     e.setAssigns(this);
    }

    public void removeAppointment(Appointment e){
    if(this.appoint.size() < 2){
        throw new IllegalArgumentException("Can not remove the last Appointment");
    }
    if(!this.appoint.contains(e)){
        return;
    }
    this.appoint.remove(e);
    e.setAssigns(null);               // we should remove from both sides
    }



//     method to make the room available again after it has been reserved.
//     This method can be helpful when an appointment is completed or canceled. Talk about it with teacher.
//    public void releaseRoom() {
//        setAvailability(true);
//    }
}
