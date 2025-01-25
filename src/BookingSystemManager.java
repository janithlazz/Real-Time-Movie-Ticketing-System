import java.util.ArrayList;
import java.util.List;

public class BookingSystemManager {
    private List<User> adminUsers;
    private List<Movie> movies;
    private List<Theater> theaters;
    private List<Ticket> tickets;

    ArrayList<User> userDataList = new ArrayList<>();
    ArrayList<Movie> movieDataList = new ArrayList<>();

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

public User loginUser(User user) {
    System.out.println("Attempting login for user: " + user.getEmail());

    for (User existingUser : userDataList) {
        if (existingUser.getEmail().equalsIgnoreCase(user.getEmail()) && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        }
    }
    System.out.println("Invalid email or password.");
    return null;
}

    // Movie Management
    public void addMovie(String movieName, String director, String genre, String language, String duration,String country,List<String>cast,String description) {
        Movie movie = new Movie(movieName,director,genre,language,duration,country,cast,description);
        movieDataList.add(movie);
        System.out.println("Movie added: " + movieName);
    }

    public void deleteMovie(String movieName) {
        boolean isRemoved = movieDataList.removeIf(deleteMovie -> deleteMovie.getMovieName().toLowerCase().contains(movieName.toLowerCase()));
        if(isRemoved){
            System.out.println("Movie Removed: " + movieName);
        }else{
            System.out.println("Invalid Movie Name");
        }
    }

    public List<Movie> searchMovies(String keyword) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie:movieDataList) {
            if(movie.getMovieName().toLowerCase().contains(keyword.toLowerCase())){
                result.add(movie);
            }
        }

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
