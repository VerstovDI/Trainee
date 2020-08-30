package GameLogic;

import Content.FieldState;
import Content.Ship;
import Game.GameOptions;

public class ShipArrangement {

    public static void putShip(Ship ship, GameOptions gameOptions) {
        gameOptions.getBoards()[0].getGameBoard().get(ship.getX()).get(ship.getY()).setFieldState(FieldState.SHIP);
        gameOptions.getBoards()[0].getGameBoard().get(ship.getY()).get(ship.getY()).setShip(ship);
    }
}
