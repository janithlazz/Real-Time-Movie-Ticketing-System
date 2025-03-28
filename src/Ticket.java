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

    public Ticket(User<User> user, Event event, Show show, int numSeats) {
    }



    public String getDetails() {
        return "Ticket ID: " + ticketId +
                "\nMovie: " + show.getMovie().getEventName() +
                "\nTime: " + show.getTime() +
                "\nSeat: " + seatNumber +
                "\nPrice: $" + price;
    }
}
