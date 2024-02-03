package StoryWorld.AbstractClasses.Successors;

import StoryWorld.AbstractClasses.AnObject;
import StoryWorld.Enums.Place;

import java.util.ArrayList;

public abstract class InanimateObjects extends AnObject {
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public InanimateObjects(String name) {
        super(name);
    }

    public InanimateObjects(String name, Place place) {
        super(name, place);
    }
}
