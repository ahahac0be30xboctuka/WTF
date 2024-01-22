package StoryWorld.Places;

public enum Place {
    WORLD_DEFAULT("Мир кладбища домашних животных", 0, 0, 0),
    HOME("Дом семьи Крид", 5, 5, 1),
    ELLIES_ROOM("Комната Элли", 4, 4, 2),
    BEDROOM("Спальная комната", 3, 3, 2),
    HALL("Зал", 2, 2, 1),
    KINDERGARDEN("Детский садик", 14, 17, 1);

    private final String title;
    private int x_coord;
    private int y_coord;
    private int z_coord;

    Place(String title, int x, int y, int z) {
        this.title = title;
        x_coord = x;
        y_coord = y;
        z_coord = z;
    }

    public String getTitle() {
        return title;
    }

    public int getX_coord() {
        return x_coord;
    }

    public int getY_coord() {
        return y_coord;
    }

    public int getZ_coord() {
        return z_coord;
    }

    /*@Override
    public String toString() {
        return title;
    } */
}