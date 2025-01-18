import java.util.Scanner;

public class Main {
    BookingSystemManager bookingSystemManager = new BookingSystemManager();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        User loggedInUser = null; // To store the logged-in user

        do {
            System.out.println("Welcome to the Movie Booking System");
            System.out.println("1. Login");
            System.out.println("2. Registration");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:  // Login option
                    loggedInUser = loginUser();
                    if (loggedInUser != null) {
                        if (loggedInUser.isAdmin()) {
                            System.out.println("Welcome, Admin!");
                            System.out.println("1. Add Movie = 1 \\n2.  Delete Movie  = 2\\n3. Add Theater = 3\\n4.  Delete Theater  = 4 \\n5.  Schedule Show = 5");
                        } else {
                            System.out.println("Welcome, Customer!");
                        }
                    }
                    break;

                case 2: // Exit option
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 2); // Loop until the user chooses to exit
    }
    private static User loginUser() {
        BookingSystemManager bookingSystemManager = new BookingSystemManager();
        Scanner logUser = new Scanner(System.in);

        System.out.print("Enter your email: ");
        String email = logUser.next();

        System.out.print("Enter your password: ");
        String password = logUser.next();

        // Perform the login process (checking email and password)
        User loggedInUser = bookingSystemManager.loginUser(email, password);

        // Check if login was successful
        if (loggedInUser != null) {
            System.out.println("Login successful.");

            // Check the role of the logged-in user (Admin or Customer)
            if (loggedInUser.isAdmin()) {
                System.out.println("Welcome, Admin!");
                Admin admin = (Admin) loggedInUser;
            } else {
                System.out.println("Welcome, Customer!");
                Customer customer = (Customer) loggedInUser;
            }

            return loggedInUser;  // Return the logged-in user object
        } else {
            System.out.println("Invalid email or password. Please try again.");
            return null;  // Return null if login failed
        }
    }





}




























//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Welcome to the BOOK_MY_SHOW");
//        // Main Menu
//        System.out.println("1. Login");
//        System.out.println("2. Register New User");
//        System.out.print("Choose an option: ");
//        int choice = scanner.nextInt();
//        if(choice == 1){
//            System.out.print("Enter your email: ");
//            String email = scanner.nextLine();
//            System.out.print("Enter your password: ");
//            String password = scanner.nextLine();
//            User loggedInUser = bookingSystemManager.loginUser(email,password);
//            if(loggedInUser == null){
//                System.out.println("Invalid credentials! Please try again.");
//                return;
//            }
//            if(loggedInUser.isAdmin()){
//                System.out.println("Welcome, Admin!");
//                Admin admin = (Admin) loggedInUser;
//
//            }
//        }else {
//
//        }
//
//        private static  void User loginUser(){
//            Scanner logUser = new Scanner(System.in);
//            System.out.print("Enter your email: ");
//            String email = logUser.next();
//            System.out.print("Enter your password: ");
//            String password = logUser.next();
//        }
//
//
//
//
//    }