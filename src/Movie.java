import java.util.List;
import java.util.Objects;

public class Movie extends Event {
    private String director;
    private  String genre;
    private  String language;
    private  String duration;
    private String country;
    private List<String> cast;
    private String description;

    public Movie(String name, String director, String genre, String language, String duration, String country, List<String> cast, String description) {
        super(name);
        this.director = director;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
        this.country = country;
        this.cast = cast;
        this.description = description;
    }

    public Movie() {
        super();
        this.director = "";
        this.genre = "";
        this.language = "";
        this.duration = "";
        this.country = "";
        this.cast = List.of(); // Avoids null cast list
        this.description = "";
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public String getLanguage() {
        return language;
    }

    public String getDuration() {
        return duration;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getCast() {
        return cast;
    }

    public String getDescription() {
        return description;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "director='" + director + '\'' +
                ", genre='" + genre + '\'' +
                ", language='" + language + '\'' +
                ", duration='" + duration + '\'' +
                ", Country='" + country + '\'' +
                ", cast=" + cast +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie movie)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getDirector(), movie.getDirector()) && Objects.equals(getGenre(), movie.getGenre()) && Objects.equals(getLanguage(), movie.getLanguage()) && Objects.equals(getDuration(), movie.getDuration()) && Objects.equals(getCountry(), movie.getCountry()) && Objects.equals(getCast(), movie.getCast()) && Objects.equals(getDescription(), movie.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDirector(), getGenre(), getLanguage(), getDuration(), getCountry(), getCast(), getDescription());
    }
}
