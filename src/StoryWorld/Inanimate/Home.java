package StoryWorld.Inanimate;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.Enums.Place;

public class Home extends InanimateObjects {
    public Home() {
        super(Place.HALL.getTitle(), Place.HALL);
    }
}
