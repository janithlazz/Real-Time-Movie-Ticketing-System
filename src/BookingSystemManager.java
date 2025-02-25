import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingSystemManager {
    private List<Theater> theaters;

    ArrayList<User> userDataList = new ArrayList<>();
    ArrayList<Movie> movieDataList = new ArrayList<>();
    ArrayList<Theater> theatersDataList = new ArrayList<>();

    public BookingSystemManager() {
        // Initialize the list to avoid null pointer exceptions
        theaters = new ArrayList<>();
    }

    public void registerUser(String name, String email, String password, int userInputType) {
        for(User user : userDataList){
            if(user.getEmail().equalsIgnoreCase(email)){
                System.out.println("Registration failed, email already exists");
                return;
            }
        }
        if(userInputType == 1){
            userDataList.add(new Admin(name,email,password));
        } else if (userInputType == 2) {
            userDataList.add(new Customer(name,email,password));
        }
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
    // Admin Movie Management
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
    public void addTheater(String theaterName, String location, int totalScreens) {
        Theater theater = new Theater(theaterName,location,totalScreens);
        theatersDataList.add(theater);
        System.out.println("Theater added: " + theaterName);
    }
    public void deleteTheater(String theaterName) {
        boolean isRemoved = theatersDataList.removeIf(deleteTheater -> deleteTheater.getName().toLowerCase().contains(theaterName.toLowerCase()));
        if(isRemoved){
            System.out.println("Movie Removed: " + theaterName);
        }else{
            System.out.println("Invalid Movie Name");
        }
    }

    //Customer controls
    public Movie findMovieByTitle(String title){
        for (Movie movie:movieDataList) {
            if(movie.getMovieName().toLowerCase().contains(title.toLowerCase())){
                return movie;
            }
        }
        return null;
    }
    public void displayMovie(){
        System.out.println("\nMovies in the list:");
        for(Movie movie:movieDataList) {
            System.out.println(movie);
        }
    }
    public void displayTheater(){
        System.out.println("\nTheaters in the list:");
        for (Theater theater:theatersDataList) {
            System.out.println(theater);
        }
    }
    public Theater findTheaterByName(String theaterName){
        System.out.println("Attempting add for screen for : " + theaterName);
        for (Theater theater:theatersDataList) {
            if(theater.getName().toLowerCase().contains(theaterName.toLowerCase())){
                return theater;
            }
        }

        return null;
    }
    public void displayMoviesAndShows() {
        // Display all screens
        System.out.println("--- Theaters in the System ---");
        for (Theater theater:theatersDataList) {
            System.out.println("Name: " + theater.getName());
            System.out.println("Location: " + theater.getLocation());
            System.out.println("Total Screens: " + theater.getTotalScreens());

            System.out.println("Screens:");
            for (Screen screen : theater.getScreens()) {
                System.out.println("    Screen ID: " + screen.getScreenId() +
                        ", Capacity: " + screen.getCapacity() +
                        ", Type: " + screen.getScreenType());
            }
            theater.displayMoviesAndShows();
        }

    }
    public void saveUser(String s) throws IOException {
        FileOutputStream f_out = new FileOutputStream("userLogins.txt");
        ObjectOutputStream out = new ObjectOutputStream(f_out);
        for (User user:userDataList) {
            System.out.println(user.getName()+" User name save successfully");
            out.writeObject(user);
        }
        out.flush();
        f_out.close();
        out.close();
    }

    public void readUser(String s) throws IOException{
        FileInputStream f_input = new FileInputStream("userLogins.txt");
        ObjectInputStream out = new ObjectInputStream(f_input);
        for(; ;){
            try {
                User user = (User) out.readObject();
                userDataList.add(user);
                System.out.println(user);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "BookingSystemManager{" +
                ", theaters=" + theaters +
                ", userDataList=" + userDataList +
                '}';
    }

}
