import StoryWorld.AbstractClasses.AnObject;
import StoryWorld.Alive.Cat;
import StoryWorld.Alive.Person;
import StoryWorld.DateTime.DateTime;
import StoryWorld.Enums.Emo;
import StoryWorld.Enums.Gender;
import StoryWorld.Enums.Place;
import StoryWorld.Enums.Time.DayOfWeek;
import StoryWorld.Enums.Time.TimeOfDay;
import StoryWorld.Enums.Time.TimeOfYear;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Exceptions.LocationException;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Exceptions.MoodException;
import StoryWorld.Inanimate.*;
import StoryWorld.Interfaces.StartStory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void execute(StartStory startStory) {
        startStory.begin();
    }

    public static void main(String[] args) throws AgeException, MoodException, LocationException {

        execute(() -> System.out.println("\"Человек есть то, что он читает\"" + " " + "(Иосиф Бродский)"));

        new DateTime(TimeOfYear.SUMMER, DayOfWeek.MONDAY, TimeOfDay.EVENING);

        Person ellie = new Person("Элли", 15, Gender.FEMALE, Place.ELLIES_ROOM);
        Person gage = new Person("Гэдж", 10, Gender.MALE, Place.HOME);

        ArrayList<Person> children = new ArrayList<>();
        children.add(gage);
        children.add(ellie);

        Person louis = new Person("Луис", 45, Gender.MALE, Place.HALL, children);
        Person rachel = new Person("Рэчел", 40, Gender.FEMALE, Place.BEDROOM, children);
        Cat cherch = new Cat("Черч", 7, Gender.MALE, Place.WORLD_DEFAULT);
        Home home = new Home();

        ellie.cry(Emo.SADNESS);
        System.out.println("Наступила тишина");

        louis.walk(ellie);
        CatBasket basket = new CatBasket("кошачья корзинка", Place.ELLIES_ROOM);

        ellie.hug(basket);
        ellie.sleep(Place.ELLIES_ROOM);

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
        rachel.sleep(Place.BEDROOM);
        louis.sleep(Place.BEDROOM);

        new DateTime(TimeOfYear.SUMMER, DayOfWeek.FRIDAY, TimeOfDay.EVENING);
        cherch.walk(home);

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
        gage.cry(Emo.SADNESS);

        louis.see(cherch);
        louis.upset(Emo.SADNESS);

        cherch.allowToCarryMe(ellie);
        cherch.change();

        DateTime dateTime = new DateTime(TimeOfYear.AUTUMN, TimeOfDay.EVENING);
        IndianSummer indianSummer = new IndianSummer(dateTime);
        indianSummer.come();
        indianSummer.pass();

        Leaves leaves = new Leaves("Листья", dateTime);
        leaves.yellowed();
        leaves.withered();
        leaves.fall();

        ellie.setLocation(Place.KINDERGARDEN);
        Decoration decoration = new Decoration("украшения для Хелуина", Place.KINDERGARDEN);

        ellie.take(decoration);
        ellie.bring(decoration);

        ellie.say(gage, "история про Всадника без головы");
        gage.say("про дядю Чихача");
        rachel.laugh(Emo.HAPPINESS);

        try {
            System.out.println(ellie.children.get(0).getName());
        } catch (NullPointerException exception) {
            System.out.println("Unchecked ошибка " + exception);
        }

        System.out.println("Это было для них хорошее время");

        if (ellie.equals(gage)) {
            System.out.println("объекты равны");
        } else {
            System.out.println("объекты не равны");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Хотите посчитать перемещение? (да/нет)");

        String answer = sc.nextLine();

        if ("да".equalsIgnoreCase(answer)) {
            System.out.println("Введите координаты места 1 (x1, y1, z1):");
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int z1 = sc.nextInt();

            System.out.println("Введите координаты места 2 (x2, y2, z2):");
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int z2 = sc.nextInt();

            AnObject.CoordinateDifference coordinates = (x, y, z, a, b, c) ->
                    System.out.printf("Разница: %d, %d, %d", Math.abs(x - a), Math.abs(y - b), Math.abs(z - c));
            coordinates.dif(x1, y1, z1, x2, y2, z2);
        } else {
            System.out.println("Ну, не хочешь - как хочешь");
        }
    }
}