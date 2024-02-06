package StoryWorld.Interfaces.WildlifeInterfaces;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.AbstractClasses.Successors.WildlifeObjects;
import StoryWorld.Enums.Emo;
import StoryWorld.Enums.Place;
import StoryWorld.Exceptions.LocationException;
import StoryWorld.Exceptions.MoodException;

public interface ActionsIncreaseMood {
    void hug(WildlifeObjects object);
    void hug(InanimateObjects object);
    void laugh(Emo emo) throws MoodException;
    void kiss(WildlifeObjects object) throws LocationException;
}
