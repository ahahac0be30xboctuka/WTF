package StoryWorld.Alive.Animals;

import StoryWorld.Alive.Animals.Emotions.Emo;
import StoryWorld.Alive.Animals.Emotions.Emotions;
import StoryWorld.Alive.Gender;
import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Places.Place;

import java.util.ArrayList;
import java.util.Arrays;

public class Cat extends WildlifeObjects implements Emotions {
    private int age;
    public String name;
    public ArrayList<Cat> children = new ArrayList<>();
    private Gender gender;
    private int mood;
    private int tiredness;
    private ArrayList<WildlifeObjects> allowedList = new ArrayList<>();

    public Cat(String name) {
        super(name);
        this.setAge(age);
    }

    public Cat(String name, int age, Gender gender) {
        super(name);
        this.setAge(age);
        this.children = null;
        this.gender = gender;
    }

    public Cat(String name, int age, Gender gender, Place location) {
        super(name, location);
        this.age = age;
        this.children = null;
        this.gender = gender;
    }

    public Cat(String name, int age, Gender gender, Place location, ArrayList<Cat> children) {
        super(name, location);
        this.age = age;
        this.children = children;
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String verbEnding(String verb) {
        if (!gender.equals(Gender.MALE)) {
            switch (verb) {
                case "подошел":
                    verb = "подощла";
                    break;
                case "мяукнул":
                    verb = "мяукнула";
                    break;
                case "позволил":
                    verb = "позволила";
                    break;
                case "изменился":
                    verb = "изменилась";
                    break;
            }
        }
        return verb;
    }

    public void walk(WildlifeObjects to) {
        String verb = "подошел";
        setLocation(to.getLocation());
        this.tiredness += 5;
        System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verbEnding(verb), to.getName());
    }

    public void walk(InanimateObjects to) {
        String verb = "подошел";
        setLocation(to.getLocation());
        this.tiredness += 5;
        System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verbEnding(verb), to.getName());
    }

    public void sleep() {
        System.out.println(name + "спит");
    }

    public void say(WildlifeObjects object, String text) {
        String verb = "мяукнул";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\" \"%s\"%n", getName(), verbEnding(verb), object.getName(), text);
    }

    public void say(String text) {
        String verb = "мяукнул";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), text);
    }

    public void allowToCarryMe(WildlifeObjects object) {
        String verb = "позволил";
        this.allowedList.add(object);
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS)));
        System.out.printf("\"%s\" %s \"%s\" таскать себя%n", getName(), verbEnding(verb), object.getName());
    }

    public void disallowToCarryMe() {
        this.allowedList.clear();
        feel(new ArrayList<>(Arrays.asList(Emo.ANGER)));
        System.out.printf("\"%s\" не даёт таскать себя%n", getName());
    }

    public void change() {
        String verb = "изменился";
        this.tiredness = 100;
        this.mood = 100;
        System.out.printf("\"%s\" %s%n", getName(), verbEnding(verb));
    }

    private void expressEmotions(String verb, ArrayList<StoryWorld.Alive.Animals.Emotions.Emo> emotion) {
        System.out.printf("%s %s ", this.getName(), verbEnding(verb));
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

    @Override
    public void show(ArrayList<Emo> emotion) {
        expressEmotions("показал", emotion);
    }
    @Override
    public void hide(ArrayList<Emo> emotion) {
        expressEmotions("cкрыл", emotion);
    }
}
