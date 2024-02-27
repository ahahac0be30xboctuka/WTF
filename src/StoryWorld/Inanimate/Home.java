package StoryWorld.Inanimate;

import StoryWorld.AbstractClasses.Successors.InanimateObjects;
import StoryWorld.Enums.Place;

public class Home extends InanimateObjects {
    public Home() {
        super("Дом", Place.HALL);
    }
    public void createAdress(){
        class Street{
            final String streetName = "Улица разбитых фонарей";
            final int houseNumber = hashCode();
            public void printAdress(){
                System.out.println("Улица: " + streetName);
                System.out.println("Номер дома: " + houseNumber);
            }
        }
        Street street = new Street();
        street.printAdress();
    }
}
