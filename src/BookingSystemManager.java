import java.util.ArrayList;
import java.util.List;

public class BookingSystemManager {
    private List<User> adminUsers;
    private List<Movie> movies;
    private List<Theater> theaters;
    private List<Ticket> tickets;

    ArrayList<User> userDataList = new ArrayList<>();
//    ArrayList<User> customerUserDataList = new ArrayList<>();

    public void BookingSystem() {
        this.movies = new ArrayList<>();
        this.theaters = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }
    public boolean registerUser(String name, String email, String password, int userInputType){
        for(User user : userDataList){
            if(user.getEmail().equalsIgnoreCase(email)){
                System.out.println("Registration failed, email already exists");
                return false;
            }
        }
        if(userInputType == 1){
            userDataList.add(new Admin(name,email,password));
        } else if (userInputType == 2) {
            userDataList.add(new Customer(name,email,password));
        }else {
            return false;
        }
        return true;
    }
//    public void registerAdmin(User user) {
//
//        System.out.println("Admin User registered successfully!");
//        adminUserDataList.add(user);
//        System.out.println(adminUserDataList);
//    }
//    public void registerCustomer(User user) {
//        customerUserDataList.add(user);
//        System.out.println("Customer User registered successfully!");
//    }
public User loginUser(User user) {
    System.out.println("Attempting login for user: " + user.getEmail());

    for (User existingUser : userDataList) {
        if (existingUser.getEmail().equalsIgnoreCase(user.getEmail()) && existingUser.getPassword().equals(user.getPassword())) {
            System.out.println("Login successful!");
            return existingUser;
        }
    }

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

    @Override
    public String toString() {
        return "BookingSystemManager{" +
                "adminUsers=" + adminUsers +
                ", movies=" + movies +
                ", theaters=" + theaters +
                ", tickets=" + tickets +
                ", userDataList=" + userDataList +
                '}';
    }
}
