package StoryWorld.Enums.Time;

public enum DayOfWeek {
    SUNDAY("Воскресенье"),
    MONDAY("Понедельик"),
    TUESDAY("Вторник"),
    WEDNESDAY("Среда"),
    THURSDAY("Четверг"),
    FRIDAY("Пятница"),
    SATURDAY("Суббота");

    private final String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    @Override
    public String toString() {
        return dayOfWeek;
    }
}
