package StoryWorld.Interfaces.ActionsWithObjects;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.AbstractClasses.Successors.WildlifeObjects;
import StoryWorld.Alive.Cat;
import StoryWorld.Exceptions.LocationException;

public interface ActionsWithWildlifeObjects {
    void hug(WildlifeObjects object) throws LocationException;

    void put(WildlifeObjects object, InanimateObjects on) throws LocationException;

    void take(WildlifeObjects object) throws LocationException;

    void tryToPull(Cat object) throws LocationException;
}
