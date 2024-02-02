import StoryWorld.Alive.Animals.Cat;
import StoryWorld.Alive.Gender;
import StoryWorld.Alive.Human.Emotions.Emo;
import StoryWorld.Alive.Human.Person;
import StoryWorld.CoordinateDifference;
import StoryWorld.DateTime.DateTime;
import StoryWorld.DateTime.DayOfWeek;
import StoryWorld.DateTime.TimeOfDay;
import StoryWorld.DateTime.TimeOfYear;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.*;
import StoryWorld.Inanimate.Buildings.Home;
import StoryWorld.Places.Place;

import java.util.ArrayList;
import java.util.List;


public class PetCemeteryStory {
    public static void main(String[] args) throws AgeException {

        new DateTime(TimeOfYear.SUMMER, DayOfWeek.MONDAY, TimeOfDay.EVENING);

        Person ellie = new Person("Элли", 15, Gender.FEMALE, Place.ELLIES_ROOM);
        Person gage = new Person("Гэдж", 10, Gender.MALE, Place.HOME);

        ArrayList<Person> children = new ArrayList<>();
        children.add(gage);
        children.add(ellie);
        Person louis = new Person("Луис", 45, Gender.MALE, Place.HALL, children);
        Person rachel = new Person("Рэчел", 40, Gender.FEMALE, Place.BEDROOM, children);
        Cat cherch = new Cat("Черч", 7, Gender.MALE, Place.WORLD_DEFAULT);

        ellie.cry();
        Silence.come();

        louis.walk(ellie);
        CatBasket basket = new CatBasket("кошачья корзинка", Place.ELLIES_ROOM);
        ellie.hug(basket);
        ellie.sleep();

        louis.take(ellie);
        louis.put(ellie, new Bed("Кровать Элли", Place.ELLIES_ROOM));
        louis.kiss(ellie);

        Paper paper = new Paper("листок бумаги", Place.HALL);
        louis.take(paper);
        louis.write(paper, "Буду завтра, люблю, Черч");
        louis.attach(paper, basket);

        rachel.waitFor(louis);
        louis.walk(rachel);
        rachel.hug(louis);
        louis.hug(rachel);
        rachel.sleep();
        louis.sleep();

        new DateTime(TimeOfYear.SUMMER, DayOfWeek.FRIDAY, TimeOfDay.EVENING);
        cherch.walk(new Home(Place.HOME));

        ellie.setMoney(100);
        Present present = new Present("подарок");
        present.setCost(25);
        try {
            ellie.buy(new CatGoodies("кошачьи лакомства"), present.getCost());
            ellie.make(present);
        } catch (NotEnoughMoneyException notEnoughMoney) {
            System.out.println("Похоже, что у Элли не хватает денег на покупку подарка");
        }

        gage.tryToPull(cherch);
        ellie.feel(new ArrayList<>(List.of(Emo.ANGER)));
        ellie.say(gage, "слова выговора");
        gage.cry();

        louis.see(cherch);
        louis.upset();

        cherch.allowToCarryMe(ellie);
        cherch.change();

        DateTime dateTime = new DateTime(TimeOfYear.AUTUMN, TimeOfDay.EVENING);
        IndianSummer indianSummer = new IndianSummer(dateTime);
        indianSummer.come();
        indianSummer.pass();

        Leaves leaves = new Leaves("Листья",dateTime);
        leaves.yellowed();
        leaves.withered();
        leaves.fall();


        ellie.setLocation(Place.KINDERGARDEN);
        Decoration decoration = new Decoration("украшения для Хелуина", Place.KINDERGARDEN);
        ellie.take(decoration);
        ellie.bring(decoration);

        ellie.say(gage, "история про Всадника без головы");

        gage.say("про дядю Чихача");
        rachel.laugh();

        try {
            System.out.println(ellie.children.get(0).getName());
        } catch (NullPointerException exception) {
            System.out.println("Unchecked ошибка " + exception);
        }

        CoordinateDifference coordinates = (x1, y1, z1, x2, y2, z2) ->
                System.out.printf("%d, %d, %d", x1 - x2, y1 - y2, z1 - z2);
        coordinates.dif(5, 5, 5, 4, 4, 4);
    }
}
