package StoryWorld.Alive;

import StoryWorld.Alive.Human.Emotions.Emo;
import StoryWorld.Alive.Human.Person;
import StoryWorld.AnObject;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Places.Place;

import java.util.ArrayList;

public abstract class WildlifeObjects extends AnObject {

    public WildlifeObjects(String name, Place place) {
        super(name, place);
    }

    public abstract void setAge(int age) throws AgeException;

    public abstract void walk(WildlifeObjects to);

    public abstract void walk(InanimateObjects to);

    public abstract void sleep();

    public abstract void say(Person object, String text);

    public abstract void say(String text);
    public abstract void see(WildlifeObjects object);
}