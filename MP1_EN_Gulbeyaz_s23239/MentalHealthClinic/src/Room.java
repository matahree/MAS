import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {
    private int id;
    private String name;
    private int capacity;
    private boolean availability;
    private List<String> typeOfRoom = new ArrayList<>();
    private static List<Room> rooms = new ArrayList<>();

    public Room(int id, String name, int capacity, boolean availability, List<String> typeOfRoom) {
        this.id = id;
        setName(name);                      // this.name = name;
        setCapacity(capacity);              //this.capacity = capacity;
        setAvailability(availability);      //this.availability = availability;
        setTypeOfRoom(typeOfRoom);
        rooms.add(this);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public List<String> getTypeOfRoom() {
        return new ArrayList<>(typeOfRoom);
    }

    public void setTypeOfRoom(List<String> typeOfRoom) {
        if (typeOfRoom == null || typeOfRoom.isEmpty()) {
            throw new IllegalArgumentException("Type of room cannot be null or empty");
        }
        this.typeOfRoom = new ArrayList<>(typeOfRoom);
    }

    public void reserveRoom() {
        if (!availability) {
            throw new IllegalStateException("Room is not available");
        }
        setAvailability(false);
    }

    // method to make the room available again after it has been reserved.
    // This method can be helpful when an appointment is completed or canceled. Talk about it with teacher.
    public void releaseRoom() {
        setAvailability(true);
    }
}
