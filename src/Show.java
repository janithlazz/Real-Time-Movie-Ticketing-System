public class Show {
    private String id;
    private Movie movie; // Reference to Movie
    private String time; // Time of the show
    private int availableSeats;
    private Screen screen;

    public Show(String id, Movie movie, String time, int availableSeats) {
        this.id = id;
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



//    addSceeenTo theater part add to the inside of the add theater class. like ask qustion how many screen have this thater, asnwer is 2, then first scren name is laux dolby sound screen, that have 200 seats, secon screern is imax screen, lke that
//
//        PVR theater have two scrren call