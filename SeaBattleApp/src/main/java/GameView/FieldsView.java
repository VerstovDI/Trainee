package GameView;

import Content.Board;
import Content.FieldState;
import Game.GameOptions;

import java.util.HashMap;

public class FieldsView {
    private static final HashMap<FieldState, String> viewDict = new HashMap<>();
    static {
        viewDict.put(FieldState.SHIP, "[#]");
        viewDict.put(FieldState.WATER, "[ ]");
        viewDict.put(FieldState.SHIP_BORDER, "[ ]");
        viewDict.put(FieldState.HIT, "[X]");
        viewDict.put(FieldState.MISSED, "[*]");
    }  // [ ], [*], [#], [X] - WATER/SHIP_BORDER, MISSED, SHIP, DAMAGED respectively

    public static void printNewFields(Board userBoard, Board opponentBoard) {
        printHorizontalLetters();
        for (int i = 0; i < userBoard.getGameBoard().size(); i++) {
            System.out.print(" " + i + " ");
            for (int j = 0; j < userBoard.getGameBoard().size(); j++) {
                printField(i, j, userBoard);
                }
            System.out.print("\t|  " + i + " ");
            for (int k = 0; k < opponentBoard.getGameBoard().size(); k++) {
                printOpponentsField(i, k, opponentBoard);
            }
            System.out.println();
        }
    }

    private static void printField(int i, int j, Board board) {
        System.out.print(viewDict.get(board.getGameBoard().get(i).get(j)
                .getFieldState()) + " ");
    }

    private static void printOpponentsField(int i, int j, Board board) {
        FieldState fieldState = board.getGameBoard().get(i).get(j)
                .getFieldState();
        if (fieldState == FieldState.SHIP) {
            System.out.print(viewDict.get(FieldState.WATER) + " ");
        } else {
            printField(i, j, board);
        }
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
}
