import java.util.List;

public class Customer extends User{

    public Customer(String name, String email, String password) {
        super(name, email, password);
    }

    private List<Ticket> bookingHistory;
    public void addToBookingHistory(Ticket ticket) {
        bookingHistory.add(ticket);
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

    public List<Ticket> getBookingHistory() {
        return bookingHistory;
    }
}
