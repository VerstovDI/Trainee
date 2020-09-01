package DataInput;

public class InputChecker {
    public static boolean isCoordinatesCorrect(int x, int y) {
        return (x >= 0) && (y >= 0) && (x <= 9) && (y <= 9);
    }
}
