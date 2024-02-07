package StoryWorld.AbstractClasses.Successors;

import StoryWorld.AbstractClasses.AnObject;
import StoryWorld.Alive.Person;
import StoryWorld.Enums.Emo;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Enums.Place;
import StoryWorld.Exceptions.LocationException;

import java.util.ArrayList;

public abstract class WildlifeObjects extends AnObject {

    public WildlifeObjects(String name, Place place) {
        super(name, place);
    }

    public abstract void setAge(int age) throws AgeException;

    public abstract void walk(WildlifeObjects to);

    public abstract void walk(InanimateObjects to);

    public abstract void sleep(Place place) throws LocationException;

    public abstract void say(Person object, String text) throws LocationException;

    public abstract void say(String text);
    public abstract void see(WildlifeObjects object) throws LocationException;
    public abstract void feel(ArrayList<Emo> emotion);
}