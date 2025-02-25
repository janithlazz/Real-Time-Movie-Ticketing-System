import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {
    private String email;
    private String name;
    private String password;
    private List<Ticket> bookingHistory;


    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public void addToBookingHistory(Ticket ticket) {
        bookingHistory.add(ticket);
    }


    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin(){
        return false;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getEmail(), user.getEmail()) && Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPassword());
    }
}
