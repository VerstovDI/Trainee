package GameLogic.AI;

import Content.Board;
import Content.Ship;
import DataInput.InputChecker;
import Game.GameOptions;
import GameLogic.ShipArrangement;
import GameLogic.Shot;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

public class AI {
    GameOptions gameOptions;
    // LinkedHashMap -> to iterate in put order, faster to arrange in future
    LinkedHashMap<Integer, Integer> AIShipsOnBoard = new LinkedHashMap<>();
    private static final Random rnd = new Random();

    public AI() {
        this.AIShipsOnBoard.put(4, 0);
        this.AIShipsOnBoard.put(3, 0);
        this.AIShipsOnBoard.put(2, 0);
        this.AIShipsOnBoard.put(1, 0);
    }

    public AI(GameOptions gameOptions) {
        this.AIShipsOnBoard.put(4, 0);
        this.AIShipsOnBoard.put(3, 0);
        this.AIShipsOnBoard.put(2, 0);
        this.AIShipsOnBoard.put(1, 0);
        this.gameOptions = gameOptions;
    }

    public void autoPutShip(Board board) {
        for (int key : AIShipsOnBoard.keySet()) {
            while (AIShipsOnBoard.get(key) < gameOptions.getShipsConfig().get(key)) {
                Ship ship = getRandomShip(key);
                if (InputChecker.checkPlace(board, ship)) {
                    ShipArrangement.putShip(ship, board);
                    AIShipsOnBoard.computeIfPresent(key, (k, v) -> v + 1);
                    }
                }
            }
    }

    public boolean AIShot(Board firedBoard, Map<Integer, Integer> computerShips) {
        // TODO: в будущем сделать логику, что если попал, то проверяет
        //  необстрелянные клетки по 4 сторонам от данной
        int xPos = rnd.nextInt(10);
        int yPos = rnd.nextInt(10);
        return Shot.doShot(xPos, yPos, firedBoard, computerShips);
    }

    private Ship getRandomShip(int numberOfDecks) {
        Random rnd = new Random();
        int rndX = rnd.nextInt(10);
        int rndY = rnd.nextInt(10);
        int rndDirection = rnd.nextInt(2);
        return new Ship(rndX, rndY, (rndDirection == 0 ? 0 : numberOfDecks - 1),
                (rndDirection == 0 ? numberOfDecks - 1 : 0), numberOfDecks);
    }

    public GameOptions getGameOptions() {
        return gameOptions;
    }

    public void setGameOptions(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    public LinkedHashMap<Integer, Integer> getAIShipsOnBoard() {
        return AIShipsOnBoard;
    }

    public void setAIShipsOnBoard(LinkedHashMap<Integer, Integer> AIShipsOnBoard) {
        this.AIShipsOnBoard = AIShipsOnBoard;
    }
}
