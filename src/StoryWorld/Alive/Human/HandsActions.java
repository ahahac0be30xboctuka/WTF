package StoryWorld.Alive.Human;

import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Inanimate.Paper;

public interface HandsActions {
    void put(InanimateObjects object, InanimateObjects on);
    void put(WildlifeObjects object, InanimateObjects on);

    void take(InanimateObjects object);

    void take(WildlifeObjects object);

    void write(Paper on, String text);

    void attach(InanimateObjects object, InanimateObjects to);
    void bring(InanimateObjects object);
    void make(WildlifeObjects object);
    void make(InanimateObjects object);
    void buy(WildlifeObjects object, int cost) throws NotEnoughMoneyException;
    void buy(InanimateObjects object, int cost) throws NotEnoughMoneyException;
}
