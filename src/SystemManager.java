import java.io.IOException;

public interface SystemManager {
    void registerAdmin(String name, String email, String password);
    void registerCustomer(String name, String email, String password);
    void removeUser(String userID);

    Admin loginAdmin(String name, String password);
    Customer loginCustomer(String name, String password);

    void  addEvent(Event event);
    void  deleteEvent(String movieName);
    void  addVenue(String theaterName, String location, int totalScreens);
    void  deleteVenue(String theaterName);
    void  displayVenue();
    Theater findVenueByName(String theaterName);
    Event findEventByName(String title);

    void displayEvent();
    void saveUser(String s) throws IOException;
    void readUser(String s) throws IOException;


}
