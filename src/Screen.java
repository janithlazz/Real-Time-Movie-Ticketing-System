import java.util.ArrayList;
import java.util.List;

public class Screen {
    private String screenId;
    private int capacity;
    private String screenType;
    private List<Show> shows;

    public Screen(String screenId, int capacity, String screenType, List<Show> shows) {
        this.screenId = screenId;
        this.capacity = capacity;
        this.screenType = screenType;
        this.shows = new ArrayList<>();
    }


}
