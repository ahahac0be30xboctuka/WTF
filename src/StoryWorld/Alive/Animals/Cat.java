package StoryWorld.Alive.Animals;

import StoryWorld.Alive.Animals.Emotions.Emo;
import StoryWorld.Alive.Animals.Emotions.Emotions;
import StoryWorld.Alive.Gender;
import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Places.Place;

import java.util.ArrayList;
import java.util.List;

public class Cat extends WildlifeObjects implements Emotions {
    private int age;
    private final Gender gender;
    int mood;
    int tiredness;

    public Cat(String name, int age, Gender gender, Place location) throws AgeException {
        super(name, location);
        this.age = age;
        this.gender = gender;
    }

    public void setAge(int age) throws AgeException {
        if (age < 0 || age > 20) throw new AgeException("Некорректный возраст животного age = " + age);
        this.age = age;
    }

    public void walk(WildlifeObjects to) {
        String verb = "подошел";
        setLocation(to.getLocation());
        this.tiredness += 5;
        System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verb, to.getName());
    }

    public void walk(InanimateObjects to) {
        String verb = "подошел";
        setLocation(to.getLocation());
        this.tiredness += 5;
        System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verb, to.getName());
    }

    public void sleep() {
        feel(new ArrayList<>(List.of(Emo.RELIEF)));
        if (aliveinteraction) {
            System.out.println(getName() + " спит");
        }
    }

    public void say(WildlifeObjects object, String text) {
        String verb = "мяукнул";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\" \"%s\"%n", getName(), object.getName(), text);
    }

    public void say(String text) {
        String verb = "мяукнул";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), text);
    }

    public void allowToCarryMe(WildlifeObjects object) {
        String verb = "позволил";
        feel(new ArrayList<>(List.of(Emo.HAPPINESS)));
        System.out.printf("\"%s\" %s \"%s\" таскать себя%n", getName(), verb, object.getName());
    }

    public void change() {
        String verb = "изменился";
        feel(new ArrayList<>(List.of(Emo.FEAR)));
        System.out.printf("\"%s\" %s%n", getName(), verb);
    }

    private void expressEmotions(String verb, ArrayList<StoryWorld.Alive.Animals.Emotions.Emo> emotion) {
        System.out.printf("%s %s ", this.getName(), verb);
        for (StoryWorld.Alive.Animals.Emotions.Emo emo : emotion) {
            this.mood = emo.getMood();
            this.tiredness = emo.getTiredness();
            System.out.printf("%s ", emo.getEmotion());
        }
        System.out.println();
    }

    @Override
    public void feel(ArrayList<StoryWorld.Alive.Animals.Emotions.Emo> emotion) {
        expressEmotions("почувствовал", emotion);
    }
}

