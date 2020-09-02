package GameLogic;

import Content.Board;
import Content.FieldState;
import Content.Ship;
import Game.GameOptions;

public class ShipArrangement {
    // TODO: допилить, додекомпозировать
    public static void putShip(Ship ship, Board board) {
        for (int i = ship.getX(); i <= ship.getX() + ship.getDx(); i++) {
            for (int j = ship.getY(); j <= ship.getY() + ship.getDy(); j++) {
                board.getGameBoard().get(i).get(j).setFieldState(FieldState.SHIP);
                board.getGameBoard().get(i).get(j).setShip(ship);
            }
        }
        for (int i = ship.getShipMinX(); i <= ship.getShipMaxX(); i++) {
            for (int j = ship.getShipMinY(); j <= ship.getShipMaxY(); j++) {
                if (board.getGameBoard().get(i).get(j).getFieldState() != FieldState.SHIP) {
                    board.getGameBoard().get(i).get(j).setFieldState(FieldState.SHIP_BORDER);
                }
            }
        }
    }


}
