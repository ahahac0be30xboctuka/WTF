package StoryWorld.Interfaces.WildlifeInterfaces;

import StoryWorld.Enums.Emo;
import StoryWorld.Exceptions.MoodException;

public interface ActionsDicreaseMood {
    void cry(Emo emo) throws MoodException;
    void upset(Emo emo) throws MoodException;
}
