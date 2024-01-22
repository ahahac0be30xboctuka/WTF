package StoryWorld.Inanimate.Buildings;


import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Places.Place;

public class Home extends InanimateObjects {
    public Home(Place place) {
        super(place.getTitle(), place);
    }

    public Home(String name) {
        super(name);
    }
}
