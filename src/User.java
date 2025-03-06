import java.io.Serializable;
import java.util.List;
import java.util.Objects;


abstract class User implements Serializable{
    protected String userId;
    protected String name;
    protected String email;
    protected String password;
    protected boolean isLoggedIn;
    protected List<Ticket> bookingHistory;


    public User(String userId, String name, String email, String password, boolean isLoggedIn) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.isLoggedIn = false;
    }

    public void addToBookingHistory(Ticket ticket) {
        bookingHistory.add(ticket);
    }

    public void login(){
        System.out.println(name + "logged in successfully.");
        isLoggedIn = true;
    }
    public void logout(){
        System.out.println(name + "logout out successfully.");
        isLoggedIn = false;
    }

    public boolean authenticate(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }
    public boolean authenticate(String email) {
        return  this.email.equals(email);
    }


}
