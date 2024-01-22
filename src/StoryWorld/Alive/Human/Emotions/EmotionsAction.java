package StoryWorld.Alive.Human.Emotions;

import java.util.ArrayList;

public interface EmotionsAction {
    void feel(ArrayList<Emo> emotion);
    void show(ArrayList<Emo> emotions);
    void hide(ArrayList<Emo> emotion);
}