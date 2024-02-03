package StoryWorld.Interfaces.WildlifeInterfaces;

import StoryWorld.AbstractClasses.Successors.WildlifeObjects;
import StoryWorld.AbstractClasses.Successors.InanimateObjects;

public interface ActionsIncreaseMood {
    void hug(WildlifeObjects object);
    void hug(InanimateObjects object);
    void laugh();
    void kiss(WildlifeObjects object);
}
