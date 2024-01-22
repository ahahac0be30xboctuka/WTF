package StoryWorld;

public class AuthorsWords {
    public static boolean enable = true;

    public static void writeText(String text) {
        if (enable) System.out.printf("* %s * %n", text);
    }
}
