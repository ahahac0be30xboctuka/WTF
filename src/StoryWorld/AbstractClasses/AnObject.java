package StoryWorld.AbstractClasses;

import StoryWorld.Enums.Place;

import java.util.Objects;

public abstract class AnObject {
    private final String name;

    public String getName() {
        return name;
    }

    Coordinates coordinates = new Coordinates(
            Place.WORLD_DEFAULT.getX_coord(), Place.WORLD_DEFAULT.getY_coord());

    public static class Coordinates implements CoordinateDifference {
        private int x, y;

        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Coordinates that = (Coordinates) o;
            return x == that.x &&
                    y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public void dif(int x1, int y1, int x2, int y2) {
        }
    }

    public Coordinates getLocation() {
        return this.coordinates;
    }

    public void makeMovement(int x, int y) {
        int my_x = this.coordinates.x;
        int my_y = this.coordinates.y;
        int step_x = (my_x > x) ? -1 : 1;
        int step_y = (my_y > y) ? -1 : 1;

        while (my_x != x || my_y != y) {
            if (my_x != x) {
                my_x += step_x;
                this.coordinates.x = my_x;
            }
            if (my_y != y) {
                my_y += step_y;
                this.coordinates.y = my_y;
            }

            System.out.printf("[ Координаты объекта %s x, y = %d, %d,]%n", this.name,
                    this.coordinates.x, this.coordinates.y);
        }
    }

    public Place setLocation(Place location) {
        makeMovement(location.getX_coord(), location.getY_coord());
        System.out.printf("[ Локация объекта \"%s\", \"%s\" ]%n", this.name, location.getTitle());
        return location;
    }

    public void setLocation(Coordinates coordinates) {
        makeMovement(coordinates.x, coordinates.y);
        System.out.printf("[ Локация объекта \"%s\" x,y = %d,%d]%n",
                this.name, this.coordinates.x, this.coordinates.y);
    }

    public AnObject(String name) {
        this.name = name;
        System.out.printf("[ Создан объект \"%s\" типа \"%s\" ]%n", this.name, this.getClass().getName());
    }

    public AnObject(String name, Place location) {
        this.name = name;
        System.out.printf("[ Создан объект \"%s\" типа \"%s\" ]%n", this.name, this.getClass().getName());
        this.coordinates.x = location.getX_coord();
        this.coordinates.y = location.getY_coord();
    }

    public interface CoordinateDifference {
        void dif(int x1, int y1, int x2, int y2);
    }

    @Override
    public String toString() {
        return name;
    }
}