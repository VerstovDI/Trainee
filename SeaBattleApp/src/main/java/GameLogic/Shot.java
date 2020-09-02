package GameLogic;

import Content.Board;
import Content.FieldState;
import Content.Ship;

public class Shot {
    public static boolean doShot(int xPos, int yPos, Board firedBoard) {
        Board.Field firedField = firedBoard.getGameBoard().get(xPos).get(yPos);
        if (firedField.getFieldState() == FieldState.SHIP) {
            firedField.setFieldState(FieldState.HIT);
            Ship currentShip = firedField.getShip();
            currentShip.setHealth(firedField.getShip().getHealth() - 1);
            if (currentShip.getHealth() == 0) {
                for (int i = currentShip.getShipMinX(); i <= currentShip.getShipMaxX(); i++) {
                    for (int j = currentShip.getShipMinY(); j <= currentShip.getShipMaxY(); j++) {
                        if (firedBoard.getGameBoard().get(i).get(j).getFieldState()
                                != FieldState.HIT) {
                            firedBoard.getGameBoard().get(i).get(j).setFieldState(FieldState.MISSED);
                        }
                    }
                }
            }
            // Если это попадание было попаданием последним (кончились палубы),
            // то сменить состояние корабля во всех полях
            // мб что-то ещё?
            return true;
        } else {
            firedField.setFieldState(FieldState.MISSED);
            return false;
        }
    }
}
