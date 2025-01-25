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

    public List<Show> getShowsForMovie(Movie movie) {
        return movieShows.getOrDefault(movie, new ArrayList<>());
    }

    public void addMovieShow(Movie movie, Show show) {
        movieShows.putIfAbsent(movie, new ArrayList<>());
        movieShows.get(movie).add(show);
    }

    public void displayMoviesAndShows() {
        System.out.println("Theater: " + name + " - Location: " + location);

    }



}
