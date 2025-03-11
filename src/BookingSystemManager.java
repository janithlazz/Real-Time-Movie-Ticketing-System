import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookingSystemManager implements SystemManager {
    private List<Theater> theaters;

    ArrayList<Admin> AdminDataList = new ArrayList<Admin>();
    ArrayList<Customer> customerDataList = new ArrayList<Customer>();
    ArrayList<Event> movieDataList = new ArrayList<>();
    ArrayList<Theater> theatersDataList = new ArrayList<>();

    public BookingSystemManager() {
        // Initialize the list to avoid null pointer exceptions
        theaters = new ArrayList<>();
    }

    @Override
    public void registerAdmin(String name, String email, String password) {
        for(Admin adminUser : AdminDataList){
            if(adminUser.getName().equals(name) && adminUser.getEmail().equals(email)){
                System.out.println("Registration failed, email already exists");
                return;
            }
        }
        AdminDataList.add(new Admin(name,email,password));
    }

    @Override
    public void registerCustomer(String name, String email, String password) {
        for(Customer CustomerUser : customerDataList){
            if(CustomerUser.getName().equals(name) && CustomerUser.getEmail().equals(email)){
                System.out.println("Registration failed, email already exists");
                return;
            }
        }
        customerDataList.add(new Customer(name,email,password));
    }

    @Override
    public void removeUser(String userID) {

    }

    @Override
    public Admin loginAdmin(String name, String password) {
        for (Admin existingAdmin : AdminDataList) {
            if (existingAdmin.getName().equals(name) && existingAdmin.getPassword().equals(password))
            {
                existingAdmin.login();
                return existingAdmin;
            }
        }
        System.out.println("Invalid email or password.");
        return null;
    }

    @Override
    public Customer loginCustomer(String name, String password) {
        for (Customer existingCustomer : customerDataList) {
            if (existingCustomer.getName().equals(name) && existingCustomer.getPassword().equals(password))
            {
                existingCustomer.login();
                return existingCustomer;
            }
        }
        System.out.println("Invalid email or password.");
        return null;
    }


    @Override
    public void addEvent(Event movie) {
        movieDataList.add(movie);
        System.out.println("Movie added: " + movie.getEventName());
    }

    @Override
    public void deleteEvent(String movieName) {
        boolean isRemoved = movieDataList.removeIf(deleteMovie -> deleteMovie.getEventName().toLowerCase().contains(movieName.toLowerCase()));
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
    public Event findEventByName(String title) {
        for (Event movie:movieDataList) {
            if(movie.getEventName().toLowerCase().contains(title.toLowerCase())){
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
        for (User<User> user:userDataList) {
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
                User<User> user = (User<User>) out.readObject();
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
