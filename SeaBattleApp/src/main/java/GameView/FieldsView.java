package GameView;

import Content.Ship;
import Game.GameOptions;

public class FieldsView {
    // TODO: подумать как gameOptions передать
    // [ ], [*], [#], [X] - вода, мимо, корабль, ранил соответственно
    public static void printStartFields() {
        printHorizontalLetters();
        for (int i = 0; i < 10; i++) {
            System.out.print(" " + i + " ");
            printLine(i, -1, -1);
        }
    }

    public static void printNewFields(Ship ship) { // TODO: Объединить методы printStartFields и printNewFields
        printHorizontalLetters();
        for (int i = 0; i < 10; i++) {
            if (ship.getY() + ship.getDy() >= i && i >= ship.getY()) {
                printLine(i, ship.getY(), ship.getDx());
            } else {
                printLine(i, -1, -1);
            }
            // TODO: по все коду проверить x и y. Перепутались оси. (?)
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

    private static void printLine(int i, int x, int dx) {  // TODO: подумать над методом printLine(...)
        // TODO: для юзера и бота отдельные методы отрисовки? или один...?
        System.out.print(" " + i + " ");
        for (int j = 0; j < 10; j++) {
            if (x + dx >= j && j >= x) {
                System.out.print("[#] ");
            } else {
                System.out.print("[ ] ");
            }
        }
        System.out.print("\t|  " + i + " ");
        for (int k = 0; k < 10; k++) {
            System.out.print("[ ] ");
        }
        System.out.println();
    }
    // TODO: Доделать enums ?
    // TODO: поработать с запуском
    // TODO: не забыть сделать очистку игрового поля
}
