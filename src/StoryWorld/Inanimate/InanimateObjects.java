package StoryWorld.Inanimate;

import StoryWorld.AnObject;
import StoryWorld.Places.Place;

import java.util.ArrayList;

public abstract class InanimateObjects extends AnObject {
    public static boolean inanimateinteraction = true;
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public static class Home extends InanimateObjects {
        public Home(Place place) {
            super(place.getTitle(), place);
        }
    }

    public static class Present extends InanimateObjects {
        public Present(String name) {
            super(name);
        }
    }

    public static class Decoration extends InanimateObjects {
        public Decoration(String name, Place location) {
            super(name, location);
        }
    }

    public static class Silence extends InanimateObjects {
        public Silence() {
            super("Тишина");
        }

        static Silence silence = new Silence();

        public static void come() {
            if (inanimateinteraction) {
                System.out.println(silence.getName() + " пришла");
            }
        }
    }

    public static class Leaves extends InanimateObjects implements LeavesActions {
        private String color;

        public Leaves(String name) {
            super(name);
        }

        @Override
        public void yellowed() {
            this.color = "Жёлтые";
            if (inanimateinteraction) {
            }
            if (debug) System.out.printf("[ Цвет листьев = %s ]%n", this.color);
            System.out.println(getName() + " пожелтели");
        }

        @Override
        public void withered() {
            this.color = "Коричнево-серые";
            if (inanimateinteraction) {
            }
            if (debug) System.out.printf("[ Цвет листьев = %s ]%n", this.color);
            System.out.println(getName() + " пожухли");
        }

        @Override
        public void fall() {
            if (inanimateinteraction) {
                System.out.println(getName() + " опали");
            }
        }
    }

    public static class IndianSummer extends InanimateObjects implements IndianSummerActions {
        public IndianSummer(String name) {
            super(name);
        }

        @Override
        public void come() {
            if (inanimateinteraction) {
                System.out.println(getName() + " пришло");
            }
        }

        @Override
        public void pass() {
            if (inanimateinteraction) {
                System.out.println(getName() + " прошло");
            }
        }
    }

    public static class CatGoodies extends InanimateObjects {
        public CatGoodies(String name) {
            super(name);
        }
    }

    public static class Paper extends InanimateObjects {
        public String text;

        public Paper(String name, Place location) {
            super(name, location);
        }
    }

    public static class CatBasket extends InanimateObjects {
        public CatBasket(String name, Place location) {
            super(name, location);
        }
    }

    public static class Bed extends InanimateObjects {
        public Bed(String name, Place place) {
            super(name, place);
        }
    }

    public ArrayList<InanimateObjects> attachedObjects = new ArrayList<>();

    public InanimateObjects(String name) {
        super(name);
    }

    public InanimateObjects(String name, Place place) {
        super(name, place);
    }
}
