import StoryWorld.Alive.Animals.Cat;
import StoryWorld.Alive.Human.Gender;
import StoryWorld.Alive.Human.Person;
import StoryWorld.Alive.WildlifeObjects;
import StoryWorld.AnObject;
import StoryWorld.AuthorsWords;
import StoryWorld.DateTime.DateTime;
import StoryWorld.DateTime.DayOfWeek;
import StoryWorld.DateTime.TimeOfDay;
import StoryWorld.DateTime.TimeOfYear;
import StoryWorld.Exceptions.AgeException;
import StoryWorld.Exceptions.NotEnoughMoneyException;
import StoryWorld.Inanimate.*;
import StoryWorld.Places.Place;

import java.util.ArrayList;


public class PetCemeteryStory {
    public static void main(String[] args) throws AgeException {
        AnObject.debug = false; // enable/disable explanations
        AuthorsWords.enable = false;// enable/disable author's words
        WildlifeObjects.aliveinteraction = true; // enable/disable wildlife objects interaction
        InanimateObjects.inanimateinteraction = true; // enable/disable wildlife objects interaction
        DateTime.datatime = false; //enable/disable datatime

        new DateTime(TimeOfYear.SUMMER, TimeOfDay.EVENING);

        AuthorsWords.writeText("Луис был прав");
        AuthorsWords.writeText("Крики Элли скоро перешли в сдавленные всхлилывания");

        Person ellie = new Person("Элли", 15, Gender.FEMALE, Place.ELLIES_ROOM);
        Person gage = new Person("Гэдж", 10, Gender.MALE, Place.HOME);

        ArrayList<Person> children = new ArrayList<>();
        children.add(gage);
        children.add(ellie);
        Person louis = new Person("Луис", 45, Gender.MALE, Place.HALL, children);
        Person rachel = new Person("Рэчел", 40, Gender.FEMALE, Place.BEDROOM, children);
        Cat cherch = new Cat("Черч", 7, Gender.MALE, Place.WORLD_DEFAULT);

        ellie.cry();

        AuthorsWords.writeText("Потом настала тишина.");
        InanimateObjects.Silence.come();

        AuthorsWords.writeText("Когда " + louis.getName() + " зашел к ней, она спала на полу, обняв кошачью " +
                "корзинку, " + "где " + cherch.getName() + " почти никогда и не спал.");
        louis.walk(ellie);
        InanimateObjects.CatBasket basket = new InanimateObjects.CatBasket("кошачья корзинка", Place.ELLIES_ROOM);
        ellie.hug(basket);
        ellie.sleep();

        AuthorsWords.writeText("Он взял ее на руки, перенес на кровать, бережно убрал с ее лба растрепавшиеся волосы" +
                " и поцеловал.");
        louis.take(ellie);
        louis.put(ellie, new InanimateObjects.Bed("Кровать Элли", Place.ELLIES_ROOM));
        louis.kiss(ellie);

        AuthorsWords.writeText("По внезапному наитию он прошел в комнату, взял листок бумаги, написал: " +
                "«Буду завтра, люблю, Черч» - и приладил листок к кошачьей корзинке.");
        InanimateObjects.Paper paper = new InanimateObjects.Paper("листок бумаги", Place.HALL);
        louis.take(paper);
        louis.write(paper, "Буду завтра, люблю, Черч");
        louis.attach(paper, basket);

        AuthorsWords.writeText("Потом он вернулся к Рэчел. Она ждала его. Они уснули в объятиях друг друга.");
        louis.walk(rachel);
        rachel.waitFor(louis);
        rachel.hug(louis);
        louis.hug(rachel);
        rachel.sleep();
        louis.sleep();

        AuthorsWords.writeText("Черч вернулся домой в пятницу, когда кончилась первая рабочая неделя Луиса;");
        new DateTime(TimeOfYear.SUMMER, DayOfWeek.FRIDAY, TimeOfDay.EVENING);
        cherch.walk(new InanimateObjects.Home(Place.HOME));

        AuthorsWords.writeText("Элли приготовила ему подарок, потратив часть денег, выдававшихся ей," +
                " на коробку кошачьих лакомств, и едва не отшлепала Гэджа за попытки подергать кота за хвост.");
        ellie.setMoney(100);
        InanimateObjects.Present present = new InanimateObjects.Present("подарок");
        present.setCost(25);
        try {
            ellie.buy(new InanimateObjects.CatGoodies("кошачьи лакомства"), present.getCost());
            ellie.make(present);
        } catch (NotEnoughMoneyException notEnoughMoney) {
            System.err.println("Похоже, что у Элли не хватает денег на покупку подарка");
        }

        AuthorsWords.writeText("Гэдж захныкал, но не очень недовольно - для него выговор Элли был равносилен" +
                " Божьему наказанию.");
        ellie.say(gage, "слова выговора");
        gage.cry();

        AuthorsWords.writeText("Вид Черча опечалил Луиса. От его былого проворства не осталось и следа. Он больше" +
                " не расхаживал с гордым видом; теперь его походка была медленной и осторожной, как у инвалида.");
        louis.upset();

        AuthorsWords.writeText("Он позволял Элли таскать себя на руках. Он не собирался выходить, даже в гараж." +
                " Он изменился. Может, это было и к лучшему.");
        cherch.allowToCarryMe(ellie);
        cherch.change();

        AuthorsWords.writeText("Ни Рэчел, ни Элли, казалось, ничего не заметили.");

        AuthorsWords.writeText("Бабье лето пришло и прошло.");
        InanimateObjects.IndianSummer indianSummer = new InanimateObjects.IndianSummer("Бабье лето");
        indianSummer.come();
        indianSummer.pass();

        AuthorsWords.writeText("Листья пожелтели, потом быстро пожухли. После одного холодного дождя в середине" +
                " октября они начали опадать.");
        new DateTime(TimeOfYear.AUTUMN, DayOfWeek.MONDAY, TimeOfDay.EVENING);
        InanimateObjects.Leaves leaves = new InanimateObjects.Leaves("Листья");
        leaves.yellowed();
        leaves.withered();
        leaves.fall();

        AuthorsWords.writeText("Элли начала приносить из садика украшения, которые они готовили к Хэллуину," +
                " и рассказывала Гэджу историю про Всадника без головы.");
        ellie.setLocation(Place.KINDERGARDEN);
        ellie.bring(new InanimateObjects.Decoration("украшения для Хелуина", Place.HOME));
        ellie.say(gage, "история про Всадника без головы");

        AuthorsWords.writeText("Гэдж радостно лопотал про какого-то Дядю Чихача, когда его укладывали спать.");
        gage.say("про дядю Чихача");

        AuthorsWords.writeText("Рэчел смеялась до слез.");
        rachel.laugh();

        AuthorsWords.writeText("Это было для них хорошее время");
    }
}
