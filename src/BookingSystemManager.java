import java.util.ArrayList;
import java.util.List;

public class BookingSystemManager {
    private List<User> users;
    private List<Movie> movies;
    private List<Theater> theaters;
    private List<Ticket> tickets;

    public void BookingSystem() {
        this.users = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    public void registerUser(User user) {

        System.out.println("User registered successfully!");
    }
    public User loginUser(String email, String password) {

        System.out.println("Invalid email or password.");
        return null;
    }

    // Movie Management
    public void addMovie(Movie movie) {

        System.out.println("Movie added: " + movie.getMovieName());
    }

    public List<Movie> searchMovies(String keyword) {
        List<Movie> result = new ArrayList<>();

        return result;
    }

}
