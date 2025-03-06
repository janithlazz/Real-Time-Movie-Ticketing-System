import java.io.FileNotFoundException;
import java.io.IOException;

public interface SystemManager {
    void registerUser(String name, String email, String password, int userInputType);
    void removeUser(String userID);
    User loginUser (String userID , String password);
    void  addEvent(Movie movie);
    void  deleteEvent(String movieName);
    void  addVenue(String theaterName, String location, int totalScreens);
    void  deleteVenue(String theaterName);
    void  displayVenue();
    Theater findVenueByName(String theaterName);
    Movie findEventByName(String title);

    void displayEvent();
    void saveUser(String s) throws IOException;
    void readUser(String s) throws IOException;


}
