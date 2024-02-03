package StoryWorld.Interfaces.WildlifeInterfaces;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.Alive.Cat;
import StoryWorld.AbstractClasses.Successors.WildlifeObjects;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.*;

public interface HandsActions {
    void put(WildlifeObjects object, InanimateObjects on);

    void take(InanimateObjects object);

    void take(WildlifeObjects object);

    void write(Paper paper, String text);

    void attach(InanimateObjects object, InanimateObjects to);

    void bring(InanimateObjects object);

    void make(InanimateObjects object);

    void buy(InanimateObjects object, int cost) throws NotEnoughMoneyException;
    void tryToPull(Cat object);
}
