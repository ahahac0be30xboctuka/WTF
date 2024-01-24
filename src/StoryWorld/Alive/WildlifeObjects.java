package StoryWorld.Alive;

import StoryWorld.AnObject;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Places.Place;

public abstract class WildlifeObjects extends AnObject {
    public static boolean aliveinteraction = true;

    public WildlifeObjects(String name, Place place) {
        super(name, place);
    }

    public abstract void setAge(int age) throws AgeException;

    public abstract void walk(WildlifeObjects to);

    public abstract void walk(InanimateObjects to);

    public abstract void sleep();

    public abstract void say(WildlifeObjects object, String text);

    public abstract void say(String text);
}