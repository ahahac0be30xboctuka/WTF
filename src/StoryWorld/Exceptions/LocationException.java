package StoryWorld.Exceptions;

public class LocationException extends Exception{
    public LocationException() {
        super("Это действие может быть выполнено только в одной и той же локации");
    }
}
