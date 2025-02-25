public class Show {
    private Movie movie; // Reference to Movie
    private String time; // Time of the show
    private int availableSeats;
    private Screen screen;

    public Show( Movie movie, String time, int availableSeats) {

        this.movie = movie;
        this.time = time;
        this.availableSeats = availableSeats;
    }

    public Show(Movie movie, Screen screen, String time) {
        this.movie = movie;
        this.time = time;
        this.availableSeats = screen.getCapacity();
        this.screen = screen;
    }

    public Movie getMovie() {
        return movie;
    }

    public String getTime() {
        return time;
    }

    public Screen getScreen() {
        return screen;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeats(int numSeats) {
        if (availableSeats >= numSeats) {
            availableSeats -= numSeats;
            return true;
        }
        return false;
    }
}