package StoryWorld.Inanimate;

import StoryWorld.AnObject;
import StoryWorld.Places.Place;

import java.util.ArrayList;

public abstract class InanimateObjects extends AnObject {
    public static boolean inanimateinteraction = true;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public ArrayList<InanimateObjects> attachedObjects = new ArrayList<>();

    public InanimateObjects(String name) {
        super(name);
    }

    public InanimateObjects(String name, Place place) {
        super(name, place);
    }
}
