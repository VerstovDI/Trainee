package DataInput;

import Content.Board;
import Content.FieldState;
import Content.Ship;
import Game.GameOptions;

public class InputChecker {
    public static boolean isCoordinatesCorrect(Ship ship) {
        return (ship.getX() >= 0) && (ship.getY() >= 0)
                && (ship.getX() <= GameOptions.fieldSize)
                && (ship.getY() <= GameOptions.fieldSize);
    }

    public static boolean isShipInField(Ship ship) {
        if (ship.getDx() >= ship.getDy()) {
            return ship.getX() + ship.getDx() < GameOptions.fieldSize;
        } else {
            return ship.getY() + ship.getDy() < GameOptions.fieldSize;
        }
    }

    // TODO: допилить
    public static boolean checkFieldsAroundShip(Board board, Ship ship) {
        int minX = ship.getShipMinX();
        int minY = ship.getShipMinY();
        int maxX = ship.getShipMaxX();
        int maxY = ship.getShipMaxY();

        for (int i = ship.getX(); i <= ship.getX() + ship.getDx(); i++) {
            for (int j = ship.getY(); j <= ship.getY() + ship.getDy(); j++) {
                if ((board.getGameBoard().get(i).get(j).getFieldState() == FieldState.SHIP)
                        || (board.getGameBoard().get(i).get(j).getFieldState() == FieldState.SHIP_BORDER)) {
                    return false;
                }
            }
        }
        /*for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if ((board.getGameBoard().get(x).get(y).getFieldState() == FieldState.SHIP)
                    || (board.getGameBoard().get(x).get(y).getFieldState() == FieldState.SHIP_BORDER)) {
                    return false;
                }
            }
        }*/
        return true;
    }

    public static boolean checkPlace(Board board, Ship ship) {
        return (isCoordinatesCorrect(ship))
                && (isShipInField(ship))
                && (checkFieldsAroundShip(board, ship));
    }
}
