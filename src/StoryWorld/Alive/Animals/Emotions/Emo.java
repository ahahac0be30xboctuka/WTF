package StoryWorld.Alive.Animals.Emotions;

public enum Emo {
    HAPPINESS("счастье", 10, -15),
    SADNESS("печаль", -10, 5),
    FEAR("страх", -10, 10),
    ANGER("злость", -15, 12),
    LOVE("любовь", 70, -10),
    RELIEF("облегчение", 25, -30);

    private final String emotion;
    private final int mood;
    private final int tiredness;

    public String getEmotion() {
        return emotion;
    }

    public int getMood() {
        return mood;
    }

    public int getTiredness() {
        return tiredness;
    }


    Emo(String emotion, int mood, int tiredness) {
        this.emotion = emotion;
        this.mood = mood;
        this.tiredness = tiredness;
    }
}
