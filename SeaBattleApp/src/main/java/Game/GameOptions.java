package Game;

import Content.Board;

import java.util.HashMap;

public class GameOptions {
    public static int NUMBER_OF_PLAYERS = 2;
    public static int fieldSize = 10;  // Размер каждого из игровых полей (квадраты fieldsSize x fieldsSize)
    boolean isRandomFirstMove; // Право первого хода. True - случайно. False - пользователь ходит первым.
    Board[] boards = new Board[NUMBER_OF_PLAYERS];  // Игровые поля. Поле #1 - пользователя, поле #2 - соперника.
    HashMap<Integer, Integer> shipsConfig;
    HashMap<Integer, Integer> currentNumberOfShips;

    public GameOptions() {
        for (int i = 0; i < boards.length; i++) {
            boards[i] = new Board(fieldSize);
        }
        currentNumberOfShips = new HashMap<>(4);
        currentNumberOfShips.put(1, 0);
        currentNumberOfShips.put(2, 0);
        currentNumberOfShips.put(3, 0);
        currentNumberOfShips.put(4, 0);
        shipsConfig = new HashMap<>(4);
        shipsConfig.put(1, 4);
        shipsConfig.put(2, 3);
        shipsConfig.put(3, 2);
        shipsConfig.put(4, 1);
    }

    /*public GameOptions(int fieldSize, boolean isRandomFirstMove) {
        this.fieldSize = fieldSize;
        this.isRandomFirstMove = isRandomFirstMove;
        TODO: To be continued...
    }*/

    public int getFieldSize() {
        return fieldSize;
    }

    public boolean isRandomFirstMove() {
        return isRandomFirstMove;
    }

    public void setFieldSize(int fieldSize) {
        GameOptions.fieldSize = fieldSize;
    }

    public void setRandomFirstMove(boolean randomFirstMove) {
        isRandomFirstMove = randomFirstMove;
    }

    public int getNUMBER_OF_PLAYERS() {
        return NUMBER_OF_PLAYERS;
    }

    public Board[] getBoards() {
        return boards;
    }

    public HashMap<Integer, Integer> getShipsConfig() {
        return shipsConfig;
    }

    public void setBoards(Board[] boards) {
        this.boards = boards;
    }

    public void setShipsConfig(HashMap<Integer, Integer> shipsConfig) {
        this.shipsConfig = shipsConfig;
    }

    public HashMap<Integer, Integer> getCurrentNumberOfShips() {
        return currentNumberOfShips;
    }

    public void setCurrentNumberOfShips(HashMap<Integer, Integer> currentNumberOfShips) {
        this.currentNumberOfShips = currentNumberOfShips;
    }
}
