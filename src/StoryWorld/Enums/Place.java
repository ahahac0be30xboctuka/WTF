package StoryWorld.Enums;

public enum Place {
    WORLD_DEFAULT("Мир кладбища домашних животных", 0, 0),
    HOME("Дом семьи Крид", 5, 5),
    ELLIES_ROOM("Комната Элли", 4, 4),
    BEDROOM("Спальная комната", 3, 3),
    HALL("Зал", 2, 2),
    KINDERGARDEN("Детский садик", 14, 17);

    private final String title;
    private final int x_coord;
    private final int y_coord;

    Place(String title, int x, int y) {
        this.title = title;
        x_coord = x;
        y_coord = y;
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
}