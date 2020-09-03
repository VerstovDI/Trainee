package DataInput;

import Content.Board;
import Content.Ship;
import Game.GameOptions;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    public static Ship getShip(GameOptions gameOptions) {
        Scanner sc = new Scanner(System.in);
        System.out.print("| Ships arrangement:\n\t# of decks = ");
        int[] coordinates = new int[4];
        if (sc.hasNextInt()) {
            int numberOfDeck = sc.nextInt();
            gameOptions.getCurrentNumberOfShips().computeIfPresent(numberOfDeck, (k, v) -> v + 1);
            if (gameOptions.getShipsConfig().get(numberOfDeck) < gameOptions.getCurrentNumberOfShips().get(numberOfDeck)) {
                throw new IllegalArgumentException("Too more ships with this number of decks");
            }
            // TODO: сделать проверку!! Класс inputChecker
            // TODO: подумать про передачу GameOptions
            // TODO: если # of decks = 1, не вводить дважды координаты
            System.out.println("\t| Now, point out ship's cape and after that ship's stern:");
            System.out.println("\t   Ship:\n\t\t Cape:");
            System.out.print("\t\t  x = ");
            coordinates[0] = sc.nextInt();
            System.out.print("\t\t  y = ");
            coordinates[1] = sc.nextInt();
            if (numberOfDeck == 1) {
                return new Ship (coordinates[0], coordinates[1]);
            } else {
                System.out.println("\t\t Stern:");
                System.out.print("\t\t  x = ");
                coordinates[2] = sc.nextInt();
                System.out.print("\t\t  y = ");
                coordinates[3] = sc.nextInt();
            }
            if ((coordinates[2] - coordinates[0] + 1) != numberOfDeck) {
                if ((coordinates[3] - coordinates[1] + 1) != numberOfDeck) {
                    throw new IllegalArgumentException("Number of decks isn't equals to the coordinates!");
                } // TODO: вынести все проверки в input checker
            }

            // Проверка верности расстановки. Отдельный метод InputChecker
            // Если поле занято кораблём или рядом корабль, или неверные координаты, то...
        } else {
            System.out.println("Вы ввели не целое число");
        }
        int dx = coordinates[2] - coordinates[0];
        int dy = coordinates[3] - coordinates[1];
        return new Ship(coordinates[0], coordinates[1], dx, dy, Math.abs(dx - dy));
    }

    public static int inputFieldCoordinate() {
        return sc.nextInt();
    }
}
