package StoryWorld.Inanimate;

import StoryWorld.Inanimate.Interfaces.LeavesActions;

public class Leaves extends InanimateObjects implements LeavesActions {
    private String color;

    public Leaves(String name) {
        super(name);
    }
    @Override
    public void yellowed() {
        this.color = "Жёлтые";
        if (inanimateinteraction) {
        }
        if (debug) System.out.printf("[ Цвет листьев = %s ]%n", this.color);
        System.out.println(getName() + " пожелтели");
    }

    @Override
    public void withered() {
        this.color = "Коричнево-серые";
        if (inanimateinteraction) {
        }
        if (debug) System.out.printf("[ Цвет листьев = %s ]%n", this.color);
        System.out.println(getName() + " пожухли");
    }

    @Override
    public void fall() {
        if (inanimateinteraction) {
            System.out.println(getName() + " опали");
        }
    }
}
