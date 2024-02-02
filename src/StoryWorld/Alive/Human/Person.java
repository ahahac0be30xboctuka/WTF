package StoryWorld.Alive.Human;

import StoryWorld.Alive.Animals.Cat;
import StoryWorld.Alive.Human.Emotions.*;
import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.Alive.Gender;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.*;
import StoryWorld.Places.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person extends WildlifeObjects implements HandsActions, ActionsIncreaseMood, EmotionsAction, ActionsDicreaseMood {
    private int age;
    public final ArrayList<Person> children;
    private final Gender gender;
    int mood;
    int tiredness;
    private int money;


    public Person(String name, int age, Gender gender, Place location) throws AgeException {
        super(name, location);
        this.setAge(age);
        this.children = null;
        this.gender = gender;
    }

    public Person(String name, int age, Gender gender, Place location, ArrayList<Person> children) throws AgeException {
        super(name, location);
        this.setAge(age);
        this.children = children;
        this.gender = gender;
    }

    private String verbEnding(String verb) {
        if (!gender.equals(Gender.MALE)) {
            switch (verb) {
                case "подошел" -> verb = "подощла";
                case "сказал" -> verb = "сказала";
                case "обнял" -> verb = "обняла";
                case "прикрепил" -> verb = "прикрепила";
                case "сделал" -> verb = "сделала";
                case "купил" -> verb = "купила";
                case "захныкал" -> verb = "захныкала";
                case "написал" -> verb = "написала";
                case "смеялся" -> verb = "смеялась";
                case "почувствовал" -> verb = "почувствовала";
                case "показал" -> verb = "показала";
                case "скрыл" -> verb = "скрыла";
                case "взял" -> verb = "взяла";
                case "увидел" -> verb = "увидела";
            }
        }
        return verb;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setAge(int age) throws AgeException {
        if (age < 0 || age > 200) throw new AgeException("Некорректный возраст человека age = " + age);
        this.age = age;
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
        feel(new ArrayList<>(List.of(Emo.RELIEF)));
        System.out.println(getName() + " спит");
    }

    public void say(Person object, String text) {
        String verb = "сказал";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\" \"%s\"%n", getName(), verbEnding(verb), object.getName(), text);
        if(text.equals("слова выговора")){
            object.feel(new ArrayList<>(List.of(Emo.SADNESS)));
        }
        else if (text.equals("слова радости")){
            object.feel(new ArrayList<>(List.of(Emo.HAPPINESS)));
        }
        else
            System.out.println();
    }

    public void say(String text) {
        String verb = "сказал";
        this.tiredness += 1;
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), text);
    }
    public void see(WildlifeObjects object){
        String verb = "увидел";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
    }

    private boolean objectTaken = false;

    @Override
    public void put(WildlifeObjects object, InanimateObjects on) {
        String verb = "положил";
        if (!objectTaken) {
            throw new IllegalStateException("take method should be called before put");
        }
        System.out.printf("\"%s\" %s \"%s\" на \"%s\"%n", getName(), verbEnding(verb), object.getName(), on.getName());
        feel(new ArrayList<>(List.of(Emo.RELIEF)));
        objectTaken = false;
    }

    @Override
    public void take(InanimateObjects object) {
        String verb = "взял";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        objectTaken = true;
    }

    @Override
    public void take(WildlifeObjects object) {
        String verb = "взял";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        objectTaken = true;
    }

    @Override
    public void write(Paper paper, String text) {
        String verb = "написал";
        paper.text = text;
        System.out.printf("\"%s\" %s на \"%s\" \"%s\"%n", getName(), verbEnding(verb), paper.getName(), paper.text);
    }

    @Override
    public void attach(InanimateObjects object, InanimateObjects to) {
        if (!objectTaken) {
            throw new IllegalStateException("take method should be called before attach");
        }
        String verb = "прикрепил";
        to.attachedObjects.add(object);
        System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verbEnding(verb), to.getName());
        objectTaken = false;
    }

    @Override
    public void bring(InanimateObjects object) {
        if (!objectTaken) {
            throw new IllegalStateException("take method should be called before bring");
        }
        String verb = "принес";
        setLocation(object.setLocation(Place.HOME));
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        objectTaken = false;
    }

    @Override
    public void make(InanimateObjects object) {
        String verb = "сделал";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
    }

    @Override
    public void buy(InanimateObjects object, int cost) throws NotEnoughMoneyException {
        if (cost > this.money) throw new NotEnoughMoneyException("Не достаточно денег");
        String verb = "купил";
        this.money -= cost;
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
    }

    @Override
    public void hug(WildlifeObjects object) {
        String verb = "обнял";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS, Emo.LOVE)));
    }

    @Override
    public void hug(InanimateObjects object) {
        String verb = "обнял";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS, Emo.LOVE)));
    }

    @Override
    public void cry() {
        String verb = "захныкал";
        feel(new ArrayList<>(List.of(Emo.SADNESS)));
        System.out.printf("\"%s\" %s%n", getName(), verbEnding(verb));
    }

    @Override
    public void upset() {
        String verb = "опечалился";
        feel(new ArrayList<>(List.of(Emo.SADNESS)));
        System.out.printf("\"%s\" %s%n", getName(), verbEnding(verb));
    }

    @Override
    public void laugh() {
        String verb = "смеялся";
        System.out.printf("\"%s\" %s до слёз%n", getName(), verbEnding(verb));
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS, Emo.RELIEF)));
    }

    @Override
    public void kiss(WildlifeObjects object) {
        String verb = "поцеловал";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        feel(new ArrayList<>(Arrays.asList(Emo.LOVE, Emo.HAPPINESS)));
    }

    public void waitFor(WildlifeObjects object) {
        String verb = "ждет";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
    }

    public void expressEmotions(String verb, ArrayList<Emo> emotions) {
        System.out.printf("%s %s ", this.getName(), verbEnding(verb));
        for (Emo emo : emotions) {
            this.mood += emo.getMood();
            this.tiredness += emo.getTiredness();
            System.out.printf("%s ", emo.getEmotion());
        }
        System.out.println();
    }

    @Override
    public void tryToPull(Cat object) {
        String verb = "попытался подергать" + " " + object.getName() + " " + "за хвост";
        System.out.printf("\"%s\" %s%n", getName(), verbEnding(verb));
        object.feel(new ArrayList<>(List.of(StoryWorld.Alive.Animals.Emotions.Emo.ANGER)));
    }

    @Override
    public void feel(ArrayList<Emo> emotions) {
        expressEmotions("почувствовал", emotions);
    }
}