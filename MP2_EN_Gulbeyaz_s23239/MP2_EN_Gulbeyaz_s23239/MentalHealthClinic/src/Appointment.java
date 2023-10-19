import java.io.Serializable;


public class Appointment implements Serializable {
    private int id;
    private String name;

    private Room assigns;
    private AppointmentBooking appointmentBooking;

    public Appointment(int id, String name, Room assigns, AppointmentBooking appointmentBooking) {
        setId(id);
        setName(name);
        setAssigns(assigns);
        setAppointmentBooking(appointmentBooking);
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
        this.name =name;
    }

    public Room getAssigns() {
        return assigns;
    }

    public void setAssigns(Room assigns) {
        if(this.assigns == assigns){
            return;
        }
        if (assigns != null) {
            this.assigns = assigns;
            assigns.addAppointment(this);
        }
        else if (this.assigns != null) {
            Room oldAssigns = this.assigns;
            this.assigns = null;
            oldAssigns.removeAppointment(this);
        }
        this.assigns = assigns;
    }


    public AppointmentBooking getAppointmentBooking() {
        return appointmentBooking;
    }

    public void setAppointmentBooking(AppointmentBooking appointmentBooking) {
        if(this.appointmentBooking == appointmentBooking){
            return;
        }
        if(this.appointmentBooking == null && appointmentBooking != null){
            if(appointmentBooking.getAppointment() != this){
                throw new IllegalArgumentException("Appointment Booking is not related with this appointment.");
            }
        this.appointmentBooking = appointmentBooking;
        } else if(this.appointmentBooking != null && appointmentBooking == null){
            AppointmentBooking var = this.appointmentBooking;
            this.appointmentBooking = null;
            var.remove();  // REMOVE FROM ALL REFERENCES
        }

    }
}
