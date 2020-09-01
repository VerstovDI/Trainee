package GameLogic;

import Content.Board;
import Content.FieldState;

public class Shot {
    public static boolean doShot(int xPos, int yPos, Board firedBoard) {
        Board.Field firedField = firedBoard.getGameBoard().get(xPos).get(yPos);
        if (firedField.getFieldState() == FieldState.SHIP) {
            firedField.setFieldState(FieldState.HIT);
            firedField.getShip().setHealth(firedField.getShip().getHealth() - 1);
            if (firedField.getShip().getHealth() == 0) {
                // Нарисовать обстрелянный ореол, сменить состояние корабля и т д
            }
            // TODO: Ввести здоровье корабля? Кол-во необходимых выстрелов?
            // Если это попадание было попаданием последним (кончились палубы),
            // то сменить состояние корабля во всех полях
            // пометить все поля вокруг как "missed"
            // мб что-то ещё?
            return true;
        } else if (firedField.getFieldState() == FieldState.WATER) {
            firedField.setFieldState(FieldState.MISSED);
        } else {
            // ... ?
        }
        return false; // ?
    }
}
