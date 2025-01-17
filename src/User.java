public class User {
    private String userId;
    private String name;
    private String email;
    private int phoneNumber;
    private String password;

    public User(String userId, String name, String email, int phoneNumber, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public boolean loginUser(String email, String password){
        if(email == null || password == null){
            return false;
        }
        return this.email.equals(email) && this.password.equals(password);
    }
}
