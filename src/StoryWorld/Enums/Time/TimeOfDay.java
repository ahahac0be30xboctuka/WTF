package StoryWorld.Enums.Time;

public enum TimeOfDay {
    MORNING("Утро"),
    AFTERNOON("День"),
    EVENING("Вечер"),
    NIGHT("Ночь");
    private final String timeOfDay;

    TimeOfDay(String timeOfDay) {
        this.timeOfDay = timeOfDay;
    }

    @Override
    public String toString() {
        return timeOfDay;
    }
}

