import java.util.Objects;

public class Event {
    private String eventName;

    public Event(String name) {
        this.eventName = name;
    }

    public Event() {
        this.eventName = "";
    }

    public String getEventName() {
        return eventName;
    }

    public void setName(String name) {
        this.eventName = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Event event)) return false;
        return Objects.equals(getEventName(), event.getEventName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEventName());
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                '}';
    }
}
