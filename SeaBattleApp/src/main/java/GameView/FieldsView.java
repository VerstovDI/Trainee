package GameView;

import Content.Board;
import Content.FieldState;

import java.util.HashMap;

public class FieldsView {
    private static final HashMap<FieldState, String> viewDict = new HashMap<>();
    static {
        viewDict.put(FieldState.SHIP, "[#]");
        viewDict.put(FieldState.WATER, "[ ]");
        viewDict.put(FieldState.SHIP_BORDER, "[ ]");
        viewDict.put(FieldState.HIT, "[X]");
        viewDict.put(FieldState.MISSED, "[*]");
    }  // [ ], [*], [#], [X] - вода, мимо, корабль, ранил соответственно

    public static void printStartFields() {
        printHorizontalLetters();
        for (int i = 0; i < 10; i++) {
            printLine(i);
        }
    }

    public static void printNewFields(Board userBoard, Board opponentBoard) {
        printHorizontalLetters();
        for (int i = 0; i < userBoard.getGameBoard().size(); i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < userBoard.getGameBoard().size(); j++) {
                printField(i, j, userBoard);
                }
            System.out.print("\t|  " + i + " ");
            for (int k = 0; k < opponentBoard.getGameBoard().size(); k++) {
                printField(i, k, opponentBoard);
            }
            System.out.println();
        }
    }

    private static void printField(int i, int j, Board board) {
        System.out.print(viewDict.get(board.getGameBoard().get(i).get(j)
                .getFieldState()) + " ");
    }

    private static void printHorizontalLetters() {
        char y = 'А';
        for (int q = 0; q < 10; q++) {
            if (q != 9) {
                System.out.print("\t" + y++);
            } else {
                System.out.print("\t" + 'К' + "\t|");
            }
        }
        y = 'А';
        for (int q = 0; q < 10; q++) {
            if (q != 9) {
                System.out.print("\t  " + y++);
            } else {
                System.out.println("\t  " + 'К');
            }
        }
    }

    private static void printLine(int i) { // TODO:подумать над методом printLine(...)
        System.out.print(" " + i + " ");
        for (int j = 0; j < 10; j++) {
            System.out.print("[ ] ");
        }
        System.out.print("\t|  " + i + " ");
        for (int k = 0; k < 10; k++) {
            System.out.print("[ ] ");
        }
        System.out.println();
    }
    // TODO: поработать с запуском
    // TODO: не забыть сделать очистку игрового поля
}
