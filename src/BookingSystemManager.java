import java.util.ArrayList;
import java.util.List;

public class BookingSystemManager {
    private List<User> adminUsers;
    private List<Movie> movies;
    private List<Theater> theaters;
    private List<Ticket> tickets;

    ArrayList<User> adminUserDataList = new ArrayList<>();
    ArrayList<User> customerUserDataList = new ArrayList<>();

    public void BookingSystem() {
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    public void registerAdmin(User user) {

        System.out.println("Admin User registered successfully!");
        adminUserDataList.add(user);
        System.out.println(adminUserDataList);
    }
    public void registerCustomer(User user) {
        customerUserDataList.add(user);
        System.out.println("Customer User registered successfully!");
    }
    public User loginUser(User user) {
        System.out.println("Attempting login for user: " + user.getEmail());
        if(adminUserDataList.contains(user)){
            System.out.println("Valid email or password.");
            return user;
        }else{
            System.out.println("Invalid email or password.");
            return null;
        }
    }

    // Movie Management
    public void addMovie(Movie movie) {

        System.out.println("Movie added: " + movie.getMovieName());
    }

    public List<Movie> searchMovies(String keyword) {
        List<Movie> result = new ArrayList<>();

        return result;
    }

    @Override
    public String toString() {
        return "BookingSystemManager{" +
                "adminUsers=" + adminUsers +
                ", movies=" + movies +
                ", theaters=" + theaters +
                ", tickets=" + tickets +
                ", adminUserDataList=" + adminUserDataList +
                ", customerUserDataList=" + customerUserDataList +
                '}';
    }
}
