import java.io.IOException;
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
                System.out.println("3. Save User Details");
                System.out.println("4. Read User Details");
                System.out.println("5. Now Showing");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Clear the newline character

                    switch (choice) {
                        case 1: // Login option
                            loginUserToSystem();
                            break;
                        case 2: // Registration option
                            registration(scanner);
                            System.out.println("User registered successfully!");
                            break;
                        case 3: // Registration option
                            fileWrite();
                            System.out.println("Save user successfully!");
                            break;
                        case 4: // Registration option
                            fileRead();
                            System.out.println(" Load user data successfully!");
                            break;
                        case 5: // Show currently showing films on theaters option
                            nowShowingMovies();
                            break;
                        case 0: // Exit option
                            System.out.println("Goodbye!");
                            break;
                        default:
                            System.out.println("Invalid choice. Please try again.");
                    }
                }
            } catch (InputMismatchException | IOException letterIn) {
                System.out.println("Only the above given integers are allowed! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void loginUserToSystem() {

        Scanner logUser = new Scanner(System.in);

        System.out.print("Enter your Name: ");
        String name = logUser.next();

        System.out.print("Enter your Password: ");
        String password = logUser.next();



        User loggedInUser = bookingSystemManager.loginUser(name,password);
        if (loggedInUser != null) {
            if (loggedInUser instanceof Admin) {
                System.out.println("Welcome, Admin!");
                Scanner scanner = new Scanner(System.in);
                int choice = -1;
                while (choice != 0){
                    System.out.println("\n--- Admin Menu ---");
                    System.out.println("1. Add Movie");
                    System.out.println("2. Delete Movie");
                    System.out.println("3. Add Theater");
                    System.out.println("4. Delete Theater");
                    System.out.println("5. Add Screen to Theater");
                    System.out.println("6. Add Show to Theater screen");
                    System.out.println("0. Main manu");
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
                            case 5:
                                addScreenToTheater();
                                break;
                            case 6:
                                addShowToScreen();
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

            } else if (loggedInUser instanceof Customer){
                System.out.println("Welcome, Customer!");
                Scanner scanner = new Scanner(System.in);
                int choice = -1;
                while (choice != 0){
                    System.out.println("\n--- Customer Menu ---");
                    System.out.println("1. Book Ticket");
                    System.out.println("0. Main manu");
                    try {
                        choice = scanner.nextInt();
                        scanner.nextLine();
                        switch (choice) {
                            case 1:
//                                bookTicket(user);
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

            }

        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }
    private static void registration(Scanner scanner) {

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

    //Movie
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

                Movie movie = new Movie(movieName,director,genre,language,duration,country,cast,description);
                bookingSystemManager.addEvent(movie);
                bookingSystemManager.displayEvent();

            }catch (Exception e){
                System.out.println("An error occurred during registration: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    private  static void deleteMovie(Scanner movieName){
        System.out.print("Please enter movie name for delete : ");
        String deleteMovieName = movieName.nextLine();
        bookingSystemManager.deleteEvent(deleteMovieName);
    }

    //Theater
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
                String theaterName = scanner.nextLine();

                System.out.print("Enter location of the theater : ");
                String theaterLocation = scanner.nextLine();

                System.out.print("How many screen are there in the theater: ");
                int numOfScreens = scanner.nextInt();
                scanner.nextLine();
                bookingSystemManager.addVenue(theaterName,theaterLocation,numOfScreens);
                //display Theater
                bookingSystemManager.displayVenue();
            }catch (Exception e){
                System.out.println("An error occurred during registration: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }
    private  static void deleteTheater(Scanner theaterName){
        System.out.print("Please enter theater name for delete : ");
        String deleteTheaterName = theaterName.nextLine();
        bookingSystemManager.deleteVenue(deleteTheaterName);
    }
    private static void addScreenToTheater() {
        Scanner scanner = new Scanner(System.in);
        Theater theater = getTheaterByName(scanner);
        if (theater == null) return;

        String screenId = getInput(scanner, "Enter screen ID: ");
        int capacity = Integer.parseInt(getInput(scanner, "Enter screen capacity: "));
        String screenType = getInput(scanner, "Enter screen type (e.g., IMAX, Standard): ");

        Screen screen = new Screen(screenId, capacity, screenType);
        theater.addScreen(screen);
        System.out.println("Screen added successfully!");
    }

    private static void addShowToScreen() {
        Scanner scanner = new Scanner(System.in);
        Theater theater = getTheaterByName(scanner);
        if (theater == null) return;

        String screenId = getInput(scanner, "Enter screen ID: ");
        Screen screen = theater.findScreenById(screenId);
        if (screen == null) {
            System.out.println("Screen not found.");
            return;
        }

        String movieTitle = getInput(scanner, "Enter movie title: ");
        Movie movie = bookingSystemManager.findEventByName(movieTitle);
        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }
        String showTime = getInput(scanner, "Enter show time (e.g., 2:00 PM): ");
        Show show = new Show(movie, screen, showTime);
        theater.addMovieShow(movie, show);
        System.out.println("Show added successfully!");
    }

    // Helper Methods
    private static Theater getTheaterByName(Scanner scanner) {
        String theaterName = getInput(scanner, "Please Enter Theater name: ");
        Theater theater = bookingSystemManager.findVenueByName(theaterName);
        if (theater == null) {
            System.out.println("Theater not found.");
        }
        return theater;
    }

    public  static void nowShowingMovies(){
        bookingSystemManager.displayEvent();
    }

    private static String getInput(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void fileWrite() throws IOException {
        bookingSystemManager.saveUser("userLogins.txt");

    }
    public static void fileRead() throws IOException {
        bookingSystemManager.readUser("userLogins.txt");

    }

    public static void bookTicket(User user) {
        System.out.println("Welcome to the Ticket Booking System");
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get movie details
        String movieTitle = getInput(scanner, "🎬 Please Enter Movie Name: ");
        Movie movie = bookingSystemManager.findEventByName(movieTitle);

        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }

        // Step 2: Get theater details
        Theater theater = getTheaterByName(scanner);
        if (theater == null) {
            System.out.println("Theater not found.");
            return;
        }

        // Step 3: Get screen details
        String screenName = getInput(scanner, "📺 Enter Screen Name: ");
        Screen screen = theater.findScreenById(screenName);
        if (screen == null) {
            System.out.println("Screen not found.");
            return;
        }

        // Step 4: Select show time
        System.out.println("Available Showtimes:");
        List<Show> availableShows = theater.getShowsForMovie(movie);
        if (availableShows.isEmpty()) {
            System.out.println("No available shows for this movie.");
            return;
        }

        for (Show show : availableShows) {
            System.out.println("- " + show.getTime());
        }

        String showTime = getInput(scanner, "Enter Show Time: ");
        Show selectedShow = null;

        for (Show show : availableShows) {
            if (show.getTime().equals(showTime)) {
                selectedShow = show;
                break;
            }
        }

        if (selectedShow == null) {
            System.out.println("No matching show found.");
            return;
        }

        // Step 5: Enter number of seats
        int numberOfSeats;
        while (true) {
            try {
                System.out.print("Enter Number of Seats: ");
                numberOfSeats = Integer.parseInt(scanner.nextLine());
                if (numberOfSeats <= 0) {
                    System.out.println("Please enter a valid number.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        // Step 6: Try to book the ticket
        boolean success = selectedShow.bookSeats(numberOfSeats);
        if (success) {
            Ticket ticket = new Ticket(user, movie, selectedShow, numberOfSeats);
            user.addToBookingHistory(ticket); // Store in user booking history
            System.out.println("Booking Successful! Your Ticket is Confirmed.");
            System.out.println(ticket.getDetails());
        } else {
            System.out.println("Booking Failed! Not enough seats available.");
        }
    }

}
