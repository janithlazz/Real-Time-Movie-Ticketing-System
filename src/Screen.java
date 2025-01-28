import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String screenId;
    private int capacity;
    private String screenType;
    private List<Show> shows;

    public Screen(String screenId, int capacity, String screenType) {
        this.screenId = screenId;
        this.capacity = capacity;
        this.screenType = screenType;
        this.shows = new ArrayList<>();
    }

    public String getScreenId() {
        return screenId;
    }

    public void setScreenId(String screenId) {
        this.screenId = screenId;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
