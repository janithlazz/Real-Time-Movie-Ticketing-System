import java.util.List;

public class Ticket {
    private String ticketId;
    private Show show; // Reference to the Show
    private int seatNumber;
    private String customerId;
    private double price;

    public Ticket(String ticketId, Show show, int seatNumber, String customerId, double price) {
        this.ticketId = ticketId;
        this.show = show;
        this.seatNumber = seatNumber;
        this.customerId = customerId;
        this.price = price;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Show getShow() {
        return show;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getPrice() {
        return price;
    }

    public String getDetails() {
        return "Ticket ID: " + ticketId +
                "\nMovie: " + show.getMovie().getMovieName() +
                "\nTime: " + show.getTime() +
                "\nSeat: " + seatNumber +
                "\nPrice: $" + price;
    }
}
