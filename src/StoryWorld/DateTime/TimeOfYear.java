package StoryWorld.DateTime;

public enum TimeOfYear {
    WINTER("Зима"),
    SPRING("Весна"),
    SUMMER("Лето"),
    AUTUMN("Осень");
    private final String timeOfYear;

    TimeOfYear(String timeOfYear) {
        this.timeOfYear = timeOfYear;
    }

    @Override
    public String toString() {
        return timeOfYear;
    }
}
