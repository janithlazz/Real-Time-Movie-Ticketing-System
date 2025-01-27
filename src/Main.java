import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character

                    switch (choice) {
                        case 1: // Login option
                            loginUser();
                            break;
                        case 2: // Registration option
                            registration(scanner);
                            System.out.println("User registered successfully!");
                            break;
                        case 3: // Exit option
                            System.out.println("Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                } else {
                    System.out.println("Only the above given integers are allowed! Please try again.");
                    scanner.nextLine(); // Clear invalid input
                }
            } catch (InputMismatchException letterIn) {
                System.out.println("Only the above given integers are allowed! Please try again.");
                scanner.nextLine();
            }
        } while (choice != 3);

        scanner.close();
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

        User loggedInUser = bookingSystemManager.loginUser(user);

        if (loggedInUser != null) {

            if (loggedInUser.isAdmin()) {
                System.out.println("Welcome, Admin!");
                Scanner scanner = new Scanner(System.in);
                int choice = -1;
                while (choice != 0){
                    System.out.println("Enter your choice (1 for Add movie, 2 for delete movie, 3 for add new theater,4 for delete theater 0 for Main menu): ");
                    try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
                                addMovie(scanner);
                                break;
                            case 2:
                                deleteMovie(scanner);
                                break;
                            case 3:
                                addTheater(scanner);
                                break;
                            case 4:
                                deleteTheater(scanner);
                                break;
                            case 0:
                                System.out.println("Returning to the main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    catch (Exception e){
                        System.out.println("An error occurred during process: " + e.getMessage());
                    }
                }

            } else {
                System.out.println("Welcome, Customer!");
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


            if(userInput == 1 || userInput == 2) {
                bookingSystemManager.registerUser(name, email, password, userInput);
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
        System.out.println("Welcome to admin movie manager");
        System.out.println("How many movies do you want to add?");

        int numberOfMovies = 0;

        while(true){
            if(scanner.hasNextInt()){
                numberOfMovies = scanner.nextInt();
                scanner.nextLine();
                break;
            }else{
                System.out.println("Invalid input. Please enter a valid number:");
                scanner.nextLine();
            }
        }
        for(int i = 0; i < numberOfMovies; i++){
            try {
                System.out.print("Enter movie Name : ");
                String movieName = scanner.nextLine();

                System.out.print("Enter director of the movie : ");
                String director = scanner.nextLine();

                System.out.print("Enter genre of the movie: ");
                String genre = scanner.nextLine();

                System.out.print("Enter language of the movie: ");
                String language = scanner.nextLine();

                System.out.print("Enter duration of the movie: ");
                String duration = scanner.nextLine();

                System.out.print("Enter country of the movie: ");
                String country = scanner.nextLine();

                System.out.print("Cast (comma-separated): ");
                String castInput = scanner.nextLine();
                List<String> cast = new ArrayList<>();
                for (String actor : castInput.split(",")) {
                    cast.add(actor.trim());
                }
                System.out.print("Please enter Description of the movie: ");
                String description = scanner.nextLine();

                bookingSystemManager.addMovie(movieName,director,genre,language,duration,country,cast,description);

            }catch (Exception e){
                System.out.println("An error occurred during registration: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }

    private  static void deleteMovie(Scanner movieName){
        System.out.print("Please enter movie name for delete : ");
        String deleteMovieName = movieName.nextLine();
        bookingSystemManager.deleteMovie(deleteMovieName);
    }
    private  static void addTheater(Scanner scanner){
        System.out.println("Welcome to admin theater manager");
        System.out.println("How many theaters do you want to add?");

        int numberOfTheater = 0;

        while(true){
            if(scanner.hasNextInt()){
                numberOfTheater = scanner.nextInt();
                scanner.nextLine();
                break;
            }else{
                System.out.println("Invalid input. Please enter a valid number:");
                scanner.nextLine();
            }
        }
        for(int i = 0; i < numberOfTheater; i++){
            try {
                System.out.print("Enter Theater Name : ");
                String movieName = scanner.nextLine();

                System.out.print("Enter location of the theater : ");
                String director = scanner.nextLine();

                System.out.print("How many screen are there in the theater: ");
                int numOfScreens = scanner.nextInt();
                bookingSystemManager.addTheater(movieName,director,numOfScreens);
            }catch (Exception e){
                System.out.println("An error occurred during registration: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    private  static void deleteTheater(Scanner theaterName){
        System.out.print("Please enter theater name for delete : ");
        String deleteTheaterName = theaterName.nextLine();
        bookingSystemManager.deleteTheater(deleteTheaterName);
    }
}
