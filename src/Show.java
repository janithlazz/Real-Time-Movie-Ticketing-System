public class Show {
    private String id;
    private Movie movie; // Reference to Movie
    private String time; // Time of the show
    private int availableSeats;

    public Show(String id, Movie movie, String time, int availableSeats) {
        this.id = id;
        this.movie = movie;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public boolean bookSeats(int numSeats) {
        if (availableSeats >= numSeats) {
            availableSeats -= numSeats;
            return true;
        }
        return false;
    }
}
