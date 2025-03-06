import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Theater {
    private  String name;
    private String location;
    private int totalScreens;
    private List<Screen>screens;
    private Map<Movie,List<Show>> movieShows; //each movie have multiple show times

    public Theater( String name, String location, int totalScreens) {

        this.name = name;
        this.location = location;
        this.totalScreens = totalScreens;
        this.screens = new ArrayList<>();
        this.movieShows = new HashMap<>();
    }

    public void addScreen(Screen screen){
        if(screens.size() < totalScreens){
            screens.add(screen);
        }else{
            System.out.println("Cannot add more screens. Theater capacity reached.");
        }
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getTotalScreens() {
        return totalScreens;
    }

    public List<Show> getShowsForMovie(Event movie) {
        return movieShows.getOrDefault(movie, new ArrayList<>());
    }
    public void addMovieShow(Movie movie, Show show) { // is this corret  change Movie movie to Event movie
        movieShows.putIfAbsent(movie, new ArrayList<>());
        movieShows.get(movie).add(show);
    }
    public void displayMoviesAndShows() {
        if(movieShows == null || movieShows.isEmpty()){
            System.out.println("No movies or shows available.");
            return;
        }
        // Display all shows for each movie
        System.out.println("\nMovies and Showtimes:");
        for (Map.Entry<Movie, List<Show>> entry : movieShows.entrySet()) {
            Movie movie = entry.getKey();
            List<Show> shows = entry.getValue();

            System.out.println("Movie: " + movie.getEventName());
            for (Show show : shows) {
                System.out.println("    Screen: " + show.getScreen().getScreenId() +
                        ", Time: " + show.getTime() +
                        ", Available Seats: " + show.getAvailableSeats());
            }
        }
    }

    public Screen findScreenById(String screenId) {
        for (Screen screen : screens) {
            if (screen.getScreenId().equalsIgnoreCase(screenId)) {
                return screen;
            }
        }
        return null; // Return null if no screen is found with the given ID
    }

    @Override
    public String toString() {
        return "Theater{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", totalScreens=" + totalScreens +
                ", screens=" + screens +
                ", movieShows=" + movieShows +
                '}';
    }
}
