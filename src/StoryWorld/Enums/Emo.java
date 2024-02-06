package StoryWorld.Enums;

public enum Emo {
    HAPPINESS("счастье", 10, -5),
    SADNESS("печаль", -10, 5),
    ANGER("злость", -15, 10),
    LOVE("любовь", 20, -10),
    RELIEF("облегчение", 5, -20);

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