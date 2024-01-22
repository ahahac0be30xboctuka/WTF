package StoryWorld.Inanimate;

import StoryWorld.Inanimate.Interfaces.IndianSummerActions;

public class IndianSummer extends InanimateObjects implements IndianSummerActions {

    public IndianSummer() {
        super("Бабье лето");
    }
    static IndianSummer indianSummer = new IndianSummer();
    public void come() {
        if (inanimateinteraction) {
            System.out.println(indianSummer.getName() + " пришло");
        }
    }
    public void pass() {
        if (inanimateinteraction) {
            System.out.println(indianSummer.getName() + " прошло");
        }
    }
}
