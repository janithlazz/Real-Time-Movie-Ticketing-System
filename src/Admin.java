public class Admin extends User<User> {


    public int employeeNumber;
    public Admin(String email, String name, String password) {
        super(email, name, password);
    }

    public boolean isAdmin(){
        return  true;
    }
}
