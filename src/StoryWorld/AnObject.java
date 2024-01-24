package StoryWorld;

import StoryWorld.Places.Place;

public abstract class AnObject {
    private final String name;
    Coordinates coordinates = new Coordinates(
            Place.WORLD_DEFAULT.getX_coord(), Place.WORLD_DEFAULT.getY_coord(), Place.WORLD_DEFAULT.getZ_coord());

    public static class Coordinates implements CoordinateDifference {
        private int x, y, z;

        public Coordinates(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public void dif(int x1, int y1, int z1, int x2, int y2, int z2){}
    }

    public static boolean debug = true;

    public String getName() {
        return name;
    }

    public Coordinates getLocation() {
        return this.coordinates;
    }

    public void makeMovement(int x, int y, int z) {
        int my_x = this.coordinates.x;
        int my_y = this.coordinates.y;
        int my_z = this.coordinates.z;
        int step_x = (my_x > x) ? -1 : 1;
        int step_y = (my_y > y) ? -1 : 1;
        int step_z = (my_z > z) ? -1 : 1;

        while (my_x != x || my_y != y || my_z != z) {
            if (my_x != x) {
                my_x += step_x;
                this.coordinates.x = my_x;
            }
            if (my_y != y) {
                my_y += step_y;
                this.coordinates.y = my_y;
            }
            if (my_z != z) {
                my_z += step_z;
                this.coordinates.z = my_z;
            }
            if (debug)
                System.out.printf("[ Координаты объекта %s x, y, z = %d, %d, %d ]%n", this.name,
                        this.coordinates.x, this.coordinates.y, this.coordinates.z);
        }
    }

    public void setLocation(Place location) {
        makeMovement(location.getX_coord(), location.getY_coord(), location.getZ_coord());
        if (debug) {
            System.out.printf("[ Локация объекта \"%s\", \"%s\" ]%n", this.name, location.getTitle());
        }
    }

    public void setLocation(Coordinates coordinates) {
        makeMovement(coordinates.x, coordinates.y, coordinates.z);
        if (debug) {
            System.out.printf("[ Локация объекта \"%s\" x,y,z = %d,%d,%d ]%n",
                    this.name, this.coordinates.x, this.coordinates.y, this.coordinates.z);
        }
    }

    public AnObject(String name) {
        this.name = name;
        if (debug) {
            System.out.printf("[ Создан объект \"%s\" типа \"%s\" ]%n", this.name, this.getClass().getName());
        }
    }

    public AnObject(String name, Place location) {
        this.name = name;
        if (debug) {
            System.out.printf("[ Создан объект \"%s\" типа \"%s\" ]%n", this.name, this.getClass().getName());
        }
        this.coordinates.x = location.getX_coord();
        this.coordinates.y = location.getY_coord();
        this.coordinates.z = location.getZ_coord();
    }

    @Override
    public String toString() {
        return name;
    }
}