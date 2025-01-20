import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static BookingSystemManager bookingSystemManager = new BookingSystemManager();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

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
                        System.out.println("Login logic goes here.");
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

    private static User loginUser() {

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
    private static void registration(Scanner scanner){

        try {
            System.out.println("Welcome to user registration");
            System.out.println("Select user type:\n1. Admin\n2. Customer");

            int userInput = getUserType(scanner);
            System.out.print("Enter your email for registration: ");
            String email = scanner.nextLine();

            System.out.print("Enter your password for registration: ");
            String password = scanner.nextLine();

            User user = new User(email,password);

            if(userInput == 1){
                bookingSystemManager.registerAdmin(user);
            } else if (userInput == 2) {
                bookingSystemManager.registerCustomer(user);
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
                else {
                    scanner.nextLine();
                }
                System.out.println("Invalid input. Please enter 1 for Admin or 2 for Customer.");
            }

        }
    }
}





