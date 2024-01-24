package StoryWorld.Alive.Human;

import StoryWorld.Alive.Human.Emotions.ActionsDicreaseMood;
import StoryWorld.Alive.Human.Emotions.ActionsIncreaseMood;
import StoryWorld.Alive.Human.Emotions.Emo;
import StoryWorld.Alive.Human.Emotions.EmotionsAction;
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
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verbEnding(verb), to.getName());
        }
    }

    public void walk(InanimateObjects to) {
        String verb = "подошел";
        setLocation(to.getLocation());
        this.tiredness += 5;
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verbEnding(verb), to.getName());
        }
    }

    public void sleep() {
        feel(new ArrayList<>(List.of(Emo.RELIEF)));
        if (aliveinteraction) {
            System.out.println(getName() + " спит");
        }
    }

    public void say(WildlifeObjects object, String text) {
        String verb = "сказал";
        this.tiredness += 1;
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\" \"%s\"%n", getName(), verbEnding(verb), object.getName(), text);
        }
    }

    public void say(String text) {
        String verb = "сказал";
        this.tiredness += 1;
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), text);
        }
    }

    @Override
    public void put(WildlifeObjects object, InanimateObjects on) {
        String verb = "положил";
        setLocation(object.getLocation());
        setLocation(on.getLocation());
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\" на \"%s\"%n", getName(), verbEnding(verb), object.getName(), on.getName());
        }
    }

    @Override
    public void take(WildlifeObjects object) {
        String verb = "взял";
        setLocation(object.getLocation());
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void take(InanimateObjects object) {
        String verb = "взял";
        setLocation(object.getLocation());
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void write(Paper paper, String text) {
        String verb = "написал";
        paper.text = text;
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s на \"%s\" \"%s\"%n", getName(), verbEnding(verb), paper.getName(), paper.text);
        }
    }

    @Override
    public void attach(InanimateObjects object, InanimateObjects to) {
        String verb = "прикрепил";
        to.attachedObjects.add(object);
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s к \"%s\"%n", getName(), verbEnding(verb), to.getName());
        }
    }

    @Override
    public void bring(InanimateObjects object) {
        String verb = "принес";
        setLocation(object.getLocation());
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void make(InanimateObjects object) {
        String verb = "сделал";
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void buy(InanimateObjects object, int cost) throws NotEnoughMoneyException {
        if (cost > this.money) throw new NotEnoughMoneyException("Не достаточно денег");
        String verb = "купил";
        this.money -= cost;
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void hug(WildlifeObjects object) {
        String verb = "обнял";
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS, Emo.LOVE)));
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void hug(InanimateObjects object) {
        String verb = "обнял";
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS, Emo.LOVE)));
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    @Override
    public void cry() {
        String verb = "захныкал";
        ArrayList<Emo> list = new ArrayList<>();
        list.add(Emo.SADNESS);
        list.add(Emo.ANGER);
        feel(list);
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s%n", getName(), verbEnding(verb));
        }
    }

    @Override
    public void upset() {
        String verb = "опечалился";
        feel(new ArrayList<>(List.of(Emo.SADNESS)));
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s%n", getName(), verbEnding(verb));
        }
    }

    @Override
    public void laugh() {
        String verb = "смеялся";
        feel(new ArrayList<>(Arrays.asList(Emo.HAPPINESS, Emo.RELIEF)));
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s до слёз%n", getName(), verbEnding(verb));
        }
    }

    @Override
    public void kiss(WildlifeObjects object) {
        String verb = "поцеловал";
        feel(new ArrayList<>(Arrays.asList(Emo.LOVE, Emo.HAPPINESS, Emo.RELIEF)));
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
        }
    }

    public void waitFor(WildlifeObjects object) {
        String verb = "ждет";
        System.out.printf("\"%s\" %s \"%s\"%n", getName(), verbEnding(verb), object.getName());
    }

    public void expressEmotions(String verb, ArrayList<Emo> emotions) {
        if (aliveinteraction) {
            System.out.printf("%s %s ", this.getName(), verbEnding(verb));
            for (Emo emo : emotions) {
                this.mood += emo.getMood();
                this.tiredness += emo.getTiredness();
                System.out.printf("%s ", emo.getEmotion());
            }
            System.out.println();
        }
    }

    @Override
    public void feel(ArrayList<Emo> emotions) {
        expressEmotions("почувствовал", emotions);
    }
}