package StoryWorld.Alive.Human;

import StoryWorld.Alive.Gender;
import StoryWorld.Alive.Human.Emotions.ActionsDicreaseMood;
import StoryWorld.Alive.Human.Emotions.Emo;
import StoryWorld.Alive.Human.Emotions.EmotionsAction;
import StoryWorld.Alive.Human.Emotions.ActionsIncreaseMood;
import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.InanimateObjects;
import StoryWorld.Inanimate.Paper;
import StoryWorld.Places.Place;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Person extends WildlifeObjects implements HandsActions, ActionsIncreaseMood, EmotionsAction, ActionsDicreaseMood {
    private int age;
    private ArrayList<Person> children = new ArrayList<>();
    private Gender gender;
    private int mood;
    private int tiredness;
    private int money;

    public void setAge(int age) throws AgeException {
        if (age < 0 || age > 200) throw new AgeException("Некорректный возраст человека age = " + age);
        this.age = age;
    } 

    public void setMoney(int money){
        return this.money = money;
    }
    
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
                case "подошел":
                    verb = "подощла";
                    break;
                case "сказал":
                    verb = "сказала";
                    break;
                case "обнял":
                    verb = "обняла";
                    break;
                case "прикрепил":
                    verb = "прикрепила";
                    break;
                case "сделал":
                    verb = "сделала";
                    break;
                case "купил":
                    verb = "купила";
                    break;
                case "захныкал":
                    verb = "захныкала";
                    break;
                case "написал":
                    verb = "написала";
                    break;
                case "смеялся":
                    verb = "смеялась";
                    break;
                case "почувствовал":
                    verb = "почувствовала";
                    break;
                case "показал":
                    verb = "показала";
                    break;
                case "скрыл":
                    verb = "скрыла";
                    break;
            }
        }
        return verb;
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
        feel(new ArrayList<>(Arrays.asList(Emo.RELIEF)));
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
    public void put(InanimateObjects object, InanimateObjects on) {
        String verb = "положил";
        setLocation(object.getLocation());
        setLocation(on.getLocation());
        if (aliveinteraction) {
            System.out.printf("\"%s\" %s \"%s\" на \"%s\"%n", getName(), verbEnding(verb), object.getName(), on.getName());
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
    public void make(WildlifeObjects object) {
        String verb = "сделал";
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
    public void buy(WildlifeObjects object, int cost) throws NotEnoughMoneyException {
        String verb = "купил";
        if (cost > this.money) throw new NotEnoughMoneyException("Не достаточно денег");
        this.money -= cost;
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
        feel(new ArrayList<>(Arrays.asList(Emo.SADNESS)));
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

    private void expressEmotions(String verb, ArrayList<Emo> emotions) {
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

    @Override
    public void show(ArrayList<Emo> emotions) {
        expressEmotions("показал", emotions);
    }

    @Override
    public void hide(ArrayList<Emo> emotions) {
        expressEmotions("скрыл", emotions);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Person person = (Person) object;
        return getName().equals(person.getName()) &&
                age == person.age &&
                Objects.equals(children, person.children) &&
                gender == person.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), age, children, gender);
    }
}
