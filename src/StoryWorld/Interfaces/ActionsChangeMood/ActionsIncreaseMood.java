package StoryWorld.Interfaces.ActionsChangeMood;

import StoryWorld.Enums.Emo;
import StoryWorld.Exceptions.MoodException;

public interface ActionsIncreaseMood {
    void laugh(Emo emo) throws MoodException;
}
