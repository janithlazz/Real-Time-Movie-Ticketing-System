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

    public int getCapacity() {
        return capacity;
    }

    public String getScreenType() {
        return screenType;
    }


}
