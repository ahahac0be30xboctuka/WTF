package StoryWorld.Interfaces.ActionsChangeMood;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.AbstractClasses.Successors.WildlifeObjects;
import StoryWorld.Enums.Emo;
import StoryWorld.Enums.Place;
import StoryWorld.Exceptions.LocationException;
import StoryWorld.Exceptions.MoodException;

public interface ActionsIncreaseMood {
    void laugh(Emo emo) throws MoodException;
}
