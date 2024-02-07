package StoryWorld.Alive;

import StoryWorld.Enums.Gender;
import StoryWorld.AbstractClasses.Successors.WildlifeObjects;
import StoryWorld.Enums.Emo;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.Enums.Place;
import StoryWorld.Exceptions.LocationException;

import java.util.ArrayList;
import java.util.List;

public class Cat extends WildlifeObjects {
    private int age;
    private final Gender gender;
    private int mood;
    private int tiredness;

    public Cat(String name, int age, Gender gender, Place location) throws AgeException {
        super(name, location);
        this.setAge(age);
        this.gender = gender;
    }

    public void setAge(int age) throws AgeException {
        if (age < 0 || age > 20) throw new AgeException();
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

    public void sleep(Place place) throws LocationException {
        if (place.getTitle().equals(Place.BEDROOM)) {
            feel(new ArrayList<>(List.of(Emo.RELIEF)));
            System.out.println(getName() + " спит");
        } else {
            throw new LocationException();
        }
        feel(new ArrayList<>(List.of(Emo.RELIEF)));
        System.out.println(getName() + " спит");
    }

    public void say(Person object, String text) throws LocationException {
        if(getLocation() == object.getLocation()) throw new LocationException();
        String verb = "мяукнул";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\" \"%s\"%n", getName(), object.getName(),verb, text);
    }

    public void say(String text) {
        String verb = "мяукнул";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verb, text);
    }

    public void see(WildlifeObjects object) throws LocationException {
        if(getLocation() == object.getLocation()) throw new LocationException();
        String verb = "увидел";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verb, object.getName());
    }

    public void feel(ArrayList<Emo> emotion) {
        expressEmotions(emotion);
    }

    public void allowToCarryMe(WildlifeObjects object) throws LocationException {
        if (getLocation() == object.getLocation()) throw new LocationException();
        String verb = "позволил";
        feel(new ArrayList<>(List.of(Emo.HAPPINESS)));
        System.out.printf("\"%s\" %s \"%s\" таскать себя%n", getName(), verb, object.getName());
    }

    public void change() {
        String verb = "изменился";
        System.out.printf("\"%s\" %s%n", getName(), verb);
    }

    private void expressEmotions(ArrayList<Emo> emotion) {
        System.out.printf("%s %s ", this.getName(), "почувствовал");
        for (Emo emo : emotion) {
            this.mood = emo.getMood();
            this.tiredness = emo.getTiredness();
            System.out.printf("%s ", emo.getEmotion());
        }
        System.out.println();
    }
}

