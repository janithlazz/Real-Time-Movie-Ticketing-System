public class Admin extends User{

    public Admin(String email, String name, String password) {
        super(email, name, password);
    }

    public boolean isAdmin(){
        return  true;
    }


}
