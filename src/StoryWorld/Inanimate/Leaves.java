package StoryWorld.Inanimate;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.DateTime.DateTime;
import StoryWorld.Enums.Time.TimeOfYear;
import StoryWorld.Interfaces.WeatherObjectInterfaces.LeavesActions;

public class Leaves extends InanimateObjects implements LeavesActions {
    private String color;
    private final DateTime currentTimeOfYear;

    public Leaves(String name, DateTime currentTimeOfYear) {
        super(name);
        this.currentTimeOfYear = currentTimeOfYear;
    }

    @Override
    public void yellowed() {
        this.color = "Жёлтые";
        if (currentTimeOfYear.getTimeOfYear() != TimeOfYear.AUTUMN) {
            throw new IllegalStateException("Метод yellowed() может быть вызван только в осень.");
        }
        System.out.println(getName() + " пожелтели");
        System.out.printf("[ Цвет листьев = %s ]%n", this.color);
    }

    @Override
    public void withered() {
        this.color = "Коричнево-серые";
        if (currentTimeOfYear.getTimeOfYear() != TimeOfYear.AUTUMN) {
            throw new IllegalStateException("Метод yellowed() может быть вызван только в осень.");
        }
        System.out.println(getName() + " пожухли");
        System.out.printf("[ Цвет листьев = %s ]%n", this.color);
    }

    @Override
    public void fall() {
        if (currentTimeOfYear.getTimeOfYear() != TimeOfYear.AUTUMN) {
            throw new IllegalStateException("Метод yellowed() может быть вызван только в осень.");
        }
        System.out.println(getName() + " опали");
    }
}
