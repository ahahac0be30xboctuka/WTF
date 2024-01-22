package StoryWorld.Inanimate;

public class Silence extends InanimateObjects {

    public Silence() {
        super("Тишина");
    }

    static Silence silence = new Silence();

    public static void come() {
        if (inanimateinteraction) {
            System.out.println(silence.getName() + " пришла");
        }
    }
}