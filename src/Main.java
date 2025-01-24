import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static BookingSystemManager bookingSystemManager = new BookingSystemManager();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        User loggedInUser = null;
        do {
            try {
                System.out.println("Welcome to the Movie Booking System");
                System.out.println("1. Login");
                System.out.println("2. Registration");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:  // Login option
                        loginUser();
                        break;
                    case 2:  // Registration option
                        registration(scanner);
                        System.out.println("User registered successfully!");
                        break;
                    case 3: // Exit option
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException letterIn) {
                System.out.println("Only the above given integers are allowed! Please try again.");
                scanner.nextLine(); // Clear the invalid input
            }
        } while (choice != 3); // Loop until the user chooses to exit

        scanner.close(); // Close the Scanner
    }

    private static void loginUser() {

        Scanner logUser = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = logUser.next();

        System.out.print("Enter your Email: ");
        String email = logUser.next();

        System.out.print("Enter your Password: ");
        String password = logUser.next();

        User user = new User(name,email,password);

        // Perform the login process (checking email and password)
        User loggedInUser = bookingSystemManager.loginUser(user);

        if (loggedInUser != null) {

            if (loggedInUser.isAdmin()) {
                System.out.println("Welcome, Admin!");
                System.out.println("Enter your choice (1 for Add movie, 2 for ): ");

            } else {
                System.out.println("Welcome, Customer!");
//                Customer customer = (Customer) loggedInUser;
            }

        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }
    private static void registration(Scanner scanner){

        try {
            System.out.println("Welcome to user registration");

            System.out.println("Select user type:\n1. Admin\n2. Customer");
            int userInput = getUserType(scanner);

            System.out.print("Enter your Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your email for registration: ");
            String email = scanner.nextLine();

            System.out.print("Enter your password for registration: ");
            String password = scanner.nextLine();


            if(userInput == 1){
                bookingSystemManager.registerUser(name,email,password,userInput);
            } else if (userInput == 2) {
                bookingSystemManager.registerUser(name,email,password,userInput);
            }else {
                System.out.println("Invalid user type selection. Registration aborted.");
            }
        }catch (Exception e){
            System.out.println("An error occurred during registration: " + e.getMessage());
        }
    }
    private static int getUserType(Scanner scanner){
        while (true){
            System.out.println("Enter your choice (1 for Admin, 2 for Customer): ");
            if(scanner.hasNextInt()){
                int choice = scanner.nextInt();
                scanner.nextLine();
                if(choice == 1 || choice == 2){
                    return choice;
                }
                System.out.println("Invalid input. Please enter 1 for Admin or 2 for Customer.");
            }else{
                System.out.println("Only numbers are allowed. Letters or special characters are not allowed.");
                scanner.next();
            }

        }
    }
    private static void addMovie(Scanner scanner){
        try {
            System.out.println("Welcome to admin movie manager");

            System.out.print("Enter movie Name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your email for registration: ");
            String email = scanner.nextLine();

            System.out.print("Enter your password for registration: ");
            String password = scanner.nextLine();


//            if(userInput == 1){
//                bookingSystemManager.registerUser(name,email,password,userInput);
//            } else if (userInput == 2) {
//                bookingSystemManager.registerUser(name,email,password,userInput);
//            }else {
//                System.out.println("Invalid user type selection. Registration aborted.");
//            }
        }catch (Exception e){
            System.out.println("An error occurred during registration: " + e.getMessage());
        }
    }
}


//    Movie movie = new Movie(movieName)
//    Movie movie = bookingSystemManager.addMovie(m);
////                Admin admin = (Admin) loggedInUser;


