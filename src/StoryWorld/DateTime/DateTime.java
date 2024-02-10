package StoryWorld.DateTime;

import StoryWorld.Enums.Time.DayOfWeek;
import StoryWorld.Enums.Time.TimeOfDay;
import StoryWorld.Enums.Time.TimeOfYear;

public final class DateTime {
    private final TimeOfYear timeOfYear;
    private DayOfWeek dayOfWeek;
    private final TimeOfDay timeOfDay;
    public DateTime(TimeOfYear timeOfYear, TimeOfDay timeOfDay) {
        this.timeOfYear = timeOfYear;
        this.timeOfDay = timeOfDay;
        System.out.printf("%s %s%n", timeOfYear.toString(), timeOfDay.toString());
    }
    public DateTime(TimeOfYear timeOfYear, DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        this.timeOfYear = timeOfYear;
        this.dayOfWeek = dayOfWeek;
        this.timeOfDay = timeOfDay;
        System.out.printf("%s %s %s%n", timeOfYear.toString(), dayOfWeek.toString(), timeOfDay.toString());
    }

    public TimeOfYear getTimeOfYear() {
        return timeOfYear;
    }
}
