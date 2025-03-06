import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BookingSystemManager implements SystemManager {
    private List<Theater> theaters;

    ArrayList<User> userDataList = new ArrayList<>();
    ArrayList<Movie> movieDataList = new ArrayList<>();
    ArrayList<Theater> theatersDataList = new ArrayList<>();

    public BookingSystemManager() {
        // Initialize the list to avoid null pointer exceptions
        theaters = new ArrayList<>();
    }

    @Override
    public void registerUser(String name, String email, String password, int userInputType) {
        for(User user : userDataList){
            if(user.authenticate(email)){
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

    @Override
    public void removeUser(String userID) {

    }

    public User loginUser(String userID , String password) {
        for (User existingUser : userDataList) {
            if (existingUser.authenticate(userID,password)) {
                existingUser.login();
                return existingUser;
            }
        }
        System.out.println("Invalid email or password.");
        return null;
    }

    @Override
    public void addEvent(Movie movie) {
        movieDataList.add(movie);
        System.out.println("Movie added: " + movie.getMovieName());
    }

    @Override
    public void deleteEvent(String movieName) {
        boolean isRemoved = movieDataList.removeIf(deleteMovie -> deleteMovie.getMovieName().toLowerCase().contains(movieName.toLowerCase()));
        if(isRemoved){
            System.out.println("Movie Removed: " + movieName);
        }else{
            System.out.println("Invalid Movie Name");
        }
    }

    @Override
    public void addVenue(String theaterName, String location, int totalScreens) {
        Theater theater = new Theater(theaterName,location,totalScreens);
        theatersDataList.add(theater);
        System.out.println("Theater added: " + theaterName);
    }

    @Override
    public void deleteVenue(String theaterName) {
        boolean isRemoved = theatersDataList.removeIf(deleteTheater -> deleteTheater.getName().toLowerCase().contains(theaterName.toLowerCase()));
        if(isRemoved){
            System.out.println("Movie Removed: " + theaterName);
        }else{
            System.out.println("Invalid Movie Name");
        }
    }

    @Override
    public void displayVenue() {
        System.out.println("\nTheaters in the list:");
        for (Theater theater:theatersDataList) {
            System.out.println(theater);
        }
    }

    @Override
    public Theater findVenueByName(String theaterName) {
        System.out.println("Attempting add for screen for : " + theaterName);
        for (Theater theater:theatersDataList) {
            if(theater.getName().toLowerCase().contains(theaterName.toLowerCase())){
                return theater;
            }
        }

        return null;
    }

    @Override
    public Movie findEventByName(String title) {
        for (Movie movie:movieDataList) {
            if(movie.getMovieName().toLowerCase().contains(title.toLowerCase())){
                return movie;
            }
        }
        return null;
    }

    @Override
    public void displayEvent() {
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
            System.out.println(user.name+" User name save successfully");
            out.writeObject(user);
        }
        out.flush();
        f_out.close();
        out.close();
    }

    public void readUser(String s) throws IOException {
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
