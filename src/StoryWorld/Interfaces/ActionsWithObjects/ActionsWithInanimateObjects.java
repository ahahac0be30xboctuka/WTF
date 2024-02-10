package StoryWorld.Interfaces.ActionsWithObjects;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.Exceptions.LocationException;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.Paper;

public interface ActionsWithInanimateObjects {
    void hug(InanimateObjects object) throws LocationException;

    void take(InanimateObjects object) throws LocationException;

    void write(Paper paper, String text) throws LocationException;

    void attach(InanimateObjects object, InanimateObjects to) throws LocationException;

    void bring(InanimateObjects object) throws LocationException;

    void make(InanimateObjects object);

    void buy(InanimateObjects object, int cost) throws NotEnoughMoneyException;
}
