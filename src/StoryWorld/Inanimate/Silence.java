package StoryWorld.Inanimate;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;

public class Silence extends InanimateObjects {

    public Silence() {
        super("Тишина");
    }

    static Silence silence = new Silence();

    public static void come() {
        System.out.println(silence.getName() + " пришла");
    }
}