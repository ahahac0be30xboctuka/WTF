package StoryWorld.Inanimate;

import StoryWorld.DateTime.DateTime;
import StoryWorld.DateTime.TimeOfYear;
import StoryWorld.Inanimate.Interfaces.IndianSummerActions;

public class IndianSummer extends InanimateObjects implements IndianSummerActions {
    private final DateTime currentTimeOfYear;

    public IndianSummer(DateTime currentTimeOfYear) {
        super("Бабье лето");
        this.currentTimeOfYear = currentTimeOfYear;
    }

    @Override
    public void come() {
        if (currentTimeOfYear.getTimeOfYear() != TimeOfYear.AUTUMN) {
            throw new IllegalStateException("Метод come() может быть вызван только в осень.");
        }
        System.out.println(getName() + " пришло");
    }
    @Override
    public void pass() {
        if (currentTimeOfYear.getTimeOfYear() != TimeOfYear.AUTUMN) {
            throw new IllegalStateException("Метод pass() может быть вызван только в осень.");
        }
        System.out.println(getName() + " прошло");
    }
}
