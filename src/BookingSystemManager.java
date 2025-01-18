import java.util.ArrayList;
import java.util.List;

public class BookingSystemManager {
    private List<User> adminUsers;
    private List<User> customerUsers;
    private List<Movie> movies;
    private List<Theater> theaters;
    private List<Ticket> tickets;

    ArrayList<User> adminUserDataList = new ArrayList<>()

    public void BookingSystem() {
        this.adminUsers = new ArrayList<>();
        this.customerUsers = new ArrayList<>();
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    public void registerAdmin(User user) {

        System.out.println("Admin User registered successfully!");
        adminUsers.add(user);
    }
    public void registerCustomer(User user) {

        System.out.println("Customer User registered successfully!");
        customerUsers.add(user);
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
