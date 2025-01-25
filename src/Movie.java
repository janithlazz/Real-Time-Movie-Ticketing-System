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

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
