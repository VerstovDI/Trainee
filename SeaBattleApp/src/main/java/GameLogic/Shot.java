package GameLogic;

import Content.Board;
import Content.FieldState;
import Content.Ship;
import Content.ShipState;
import Game.GameOptions;

public class Shot {
    public static boolean doShot(int xPos, int yPos, Board board) {
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
                /*int numberOfDecks = Math.abs(ship.getDx() - ship.getDy());
                GameOptions.currentNumberOfShips
                        .computeIfPresent(numberOfDecks, (k, v) -> v - 1);
                if (GameOptions.currentNumberOfShips.get(numberOfDecks) == 0) {
                    GameOptions.currentNumberOfShips.remove(numberOfDecks);
                }*/ // TODO: доделать это. Передавать в метод doShot ссылку на Map. Бах. Тут и полиморфизм.
            }
            return true;
        } else {
            field.setFieldState(FieldState.MISSED);
            return false;
        }
    }
}
