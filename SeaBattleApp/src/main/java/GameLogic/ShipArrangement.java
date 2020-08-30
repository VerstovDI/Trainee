package GameLogic;

import Content.FieldState;
import Content.Ship;
import Game.GameOptions;

public class ShipArrangement {

    public static void putShip(Ship ship, GameOptions gameOptions) {
        for (int i = ship.getX(); i <= ship.getX() + ship.getDx(); i++) {
            for (int j = ship.getY(); j <= ship.getY() + ship.getDy(); j++) {
                gameOptions.getBoards()[0].getGameBoard().get(i).get(j).setFieldState(FieldState.SHIP);
                gameOptions.getBoards()[0].getGameBoard().get(i).get(j).setShip(ship);
            }
        }
    }
}
