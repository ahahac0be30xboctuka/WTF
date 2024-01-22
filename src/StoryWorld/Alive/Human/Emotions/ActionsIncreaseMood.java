package StoryWorld.Alive.Human.Emotions;

import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.Inanimate.InanimateObjects;

public interface ActionsIncreaseMood {
    void hug(WildlifeObjects object);
    void hug(InanimateObjects object);
    void laugh();
    void kiss(WildlifeObjects object);
}
