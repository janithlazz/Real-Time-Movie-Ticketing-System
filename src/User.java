import java.io.Serializable;
import java.util.List;


abstract class User<A extends User> implements Serializable{
    protected String name;
    protected String email;
    protected String password;
//    protected boolean isLoggedIn;
    protected List<Ticket> bookingHistory;


    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
//        this.isLoggedIn = false;
    }


    public void addToBookingHistory(Ticket ticket) {
        bookingHistory.add(ticket);
    }

//    public void login(){
//        System.out.println(name + "logged in successfully.");
//        isLoggedIn = true;
//    }
//    public void logout(){
//        System.out.println(name + "logout out successfully.");
//        isLoggedIn = false;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public boolean authenticate(String name, String password) {
//        return this.userId.equals(name) && this.password.equals(password);
//    }
    public boolean authenticate(String email) {
        return  this.email.equals(email);
    }


}
