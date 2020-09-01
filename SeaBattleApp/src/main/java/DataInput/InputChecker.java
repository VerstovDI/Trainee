package DataInput;

import Content.Board;
import Content.FieldState;
import Content.Ship;
import Game.GameOptions;

public class InputChecker {
    // Проверка правильности координат поля
    public static boolean isCoordinatesCorrect(Ship ship) {
        return (ship.getX() >= 0) && (ship.getY() >= 0)
                && (ship.getX() <= GameOptions.fieldSize)
                && (ship.getY() <= GameOptions.fieldSize);
    }

    public static boolean isShipInField(Ship ship) {
        if (ship.getDx() >= ship.getDy()) {
            return ship.getX() + ship.getDx() < 10;
        } else {
            return ship.getY() + ship.getDy() < 10;
        }
    }

    // TODO: допилить
    public static boolean checkFieldsAroundShip(Board board, Ship ship) {
        int minX = Math.max(0, ship.getX() - 1);
        int minY = Math.max(0, ship.getY() - 1); // ПРОВЕРИТЬ!!!
        int maxX = Math.min(GameOptions.fieldSize - 1,
                ship.getX()
                        + 1
                        + (ship.getDx() > ship.getDy() ? 0 : ship.getDy() - ship.getDx()));
        int maxY = Math.min(GameOptions.fieldSize - 1,
                ship.getY()
                        + 1
                        + (ship.getDx() > ship.getDy() ? ship.getDx() - ship.getDy() : 0));
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (board.getGameBoard().get(x).get(y).getFieldState() != FieldState.WATER) {
                    return false;
                }
            }
        }
        return true;
    }
}
