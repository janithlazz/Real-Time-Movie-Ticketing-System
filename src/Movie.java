import java.util.List;

public class Movie {
    private String movieName;
    private String director;
    private  String genre;
    private  String language;
    private  String duration;
    private String Country;
    private List<String> cast;
    private String description;

    public Movie(String movieName, String director, String genre, String language, String duration, String country, List<String> cast, String description) {
        this.movieName = movieName;
        this.director = director;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        Country = country;
        this.cast = cast;
        this.description = description;
    }

    public String getMovieName() {
        return movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieName=" + movieName +
                ", director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", duration=" + duration +
                ", Country='" + Country + '\'' +
                ", cast=" + cast +
                ", description='" + description + '\'' +
                '}';
    }
}
