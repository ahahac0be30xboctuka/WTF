package StoryWorld.DateTime;

public class DateTime {
    public static boolean datatime = true;
    public DateTime(TimeOfYear timeOfYear, DayOfWeek dayOfWeek, TimeOfDay timeOfDay) {
        if (datatime) {
            System.out.printf("%s %s %s%n", timeOfYear.toString(), dayOfWeek.toString(), timeOfDay.toString());
        }
    }
    public DateTime(TimeOfYear timeOfYear, TimeOfDay timeOfDay) {
        if (datatime) {
            System.out.printf("%s %s%n", timeOfYear.toString(), timeOfDay.toString());
        }
    }
}
