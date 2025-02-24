import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private String email;
    private String name;
    private String password;
    private List<Ticket> bookingHistory;


    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
    // Method to display booking history
    public void displayBookingHistory() {
        if (bookingHistory.isEmpty()) {
            System.out.println("No bookings found.");
            return;
        }
        System.out.println("Booking History for " + getName() + ":");
        for (Ticket ticket : bookingHistory) {
            System.out.println(ticket.getDetails());
        }
    }
    public void addToBookingHistory(Ticket ticket) {
        bookingHistory.add(ticket);
    }

    public List<Ticket> getBookingHistory() {
        return bookingHistory;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin(){
        return false;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }
}
