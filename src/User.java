public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    public boolean isAdmin(){
        return false;
    }

    public boolean loginUser(String email, String password){
        if(email == null || password == null){
            return false;
        }
        return this.email.equals(email) && this.password.equals(password);
    }
}
