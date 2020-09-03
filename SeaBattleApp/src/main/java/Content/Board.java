package Content;


import java.util.ArrayList;

/**
 * Class representing game's field as 2D-array of objects Field
 * @author Danila
 * @version 1.0
 */
public class Board {
    private final ArrayList<ArrayList<Field>> gameBoard;

    public Board(int boardSize){
        this.gameBoard = new ArrayList<>(boardSize);
        for (int i = 0; i < boardSize; i++) {
            this.gameBoard.add(new ArrayList<>(boardSize));
            for (int j = 0; j < boardSize; j++) {
                this.gameBoard.get(i).add(new Field());
            }
        }
    }

    public Board(ArrayList<ArrayList<Field>> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public static class Field {
        private FieldState fieldState = FieldState.WATER;
        private Ship ship;

        public Field() { }

        public Field(FieldState fieldState) {
            this.fieldState = fieldState;
        }

        public FieldState getFieldState() {
            return fieldState;
        }

        public void setFieldState(FieldState fieldState) {
            this.fieldState = fieldState;
        }

        public Ship getShip() {
            return ship;
        }

        public void setShip(Ship ship) {
            this.ship = ship;
        }

        @Override
        public String toString() {
            return "Field{" +
                    "fieldState=" + fieldState +
                    '}';
        }
    }

    public ArrayList<ArrayList<Field>> getGameBoard() {
        return gameBoard;
    }
}
