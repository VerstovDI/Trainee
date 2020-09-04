package GameLogic;

import Content.Board;
import Content.FieldState;
import Content.Ship;
import Content.ShipState;
import DataInput.Input;

import java.util.Map;

import static java.lang.System.out;

public class Shot {
    public static boolean doShot(int xPos, int yPos, Board board, Map<Integer, Integer> shipsMap) {
        Board.Field field = board.getGameBoard().get(xPos).get(yPos);
        if (field.getFieldState() == FieldState.SHIP) {
            field.setFieldState(FieldState.HIT);
            Ship ship = field.getShip();
            ship.setHealth(field.getShip().getHealth() - 1);
            ship.setShipState(ShipState.DAMAGED);
            if (ship.getHealth() == 0) {
                ship.setShipState(ShipState.SUNK);
                for (int i = ship.getShipMinX(); i <= ship.getShipMaxX(); i++) {
                    for (int j = ship.getShipMinY(); j <= ship.getShipMaxY(); j++) {
                        if (board.getGameBoard().get(i).get(j).getFieldState()
                                != FieldState.HIT) {
                            board.getGameBoard().get(i).get(j).setFieldState(FieldState.MISSED);
                        }
                    }
                }
                int numberOfDecks = Math.abs(ship.getDx() - ship.getDy()) + 1;
                shipsMap.computeIfPresent(numberOfDecks, (k, v) -> v - 1);
                if (shipsMap.get(numberOfDecks) == 0) {
                    shipsMap.remove(numberOfDecks);
                }
            }
            return true;
        } else {
            field.setFieldState(FieldState.MISSED);
            return false;
        }
    }

    public static boolean playerShot(Board board, Map<Integer, Integer> shipsMap) {
        out.println("Enter field to shot, please.");
        out.print("\tEnter x: ");
        int x = Input.inputFieldCoordinate();
        out.print(("\tEnter y: "));
        int y = Input.inputFieldCoordinate();
        return Shot.doShot(x, y, board, shipsMap);
    }
}
