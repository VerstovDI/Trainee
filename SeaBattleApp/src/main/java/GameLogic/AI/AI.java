package GameLogic.AI;

import Content.Board;
import Content.FieldState;
import Content.Ship;
import DataInput.Input;
import DataInput.InputChecker;
import Game.GameOptions;
import GameLogic.ShipArrangement;
import GameLogic.Shot;
import GameView.FieldsView;
import org.w3c.dom.ranges.Range;

import java.util.LinkedHashMap;
import java.util.Random;

public class AI {
    GameOptions gameOptions;
    // Для того, чтобы сначала подобралось место под большие корабли. Так будет быстрее
    LinkedHashMap<Integer, Integer> shipOnBoard = new LinkedHashMap<>();
    private static Random rnd = new Random();

    public AI() {
        this.shipOnBoard.put(4, 0);
        this.shipOnBoard.put(3, 0);
        this.shipOnBoard.put(2, 0);
        this.shipOnBoard.put(1, 0);
    }

    public AI(GameOptions gameOptions) {
        this.shipOnBoard.put(4, 0);
        this.shipOnBoard.put(3, 0);
        this.shipOnBoard.put(2, 0);
        this.shipOnBoard.put(1, 0);
        this.gameOptions = gameOptions;
    }

    public boolean autoPutShip(Board board) {
        // TODO: Предусмотреть, что будет, когда все поля обстреляны
        for (int key : shipOnBoard.keySet()) {
            while (shipOnBoard.get(key) < gameOptions.getShipsConfig().get(key)) {
                Ship ship = getRandomShip(key);
                if (InputChecker.checkPlace(board, ship)) {
                    ShipArrangement.putShip(ship, board);
                    shipOnBoard.computeIfPresent(key, (k, v) -> v + 1);
                    // TODO: для отладки!! УБРАТЬ!!!
                    // FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
                    }
                    // TODO: здесь и на доске юзера проверить правильность состояния клеток, занятых кораблями
                    // ПРОВЕРИТЬ - обозначить во всех клетках, занятых кораблем, состояние клетки ship
                }
            }
        return true;
    }
        // TODO: если доска соперника, то печатаем все клетки, кроме HIT

    public boolean AIShot(Board firedBoard) {
        // TODO: в будущем сделать логику, что если попал, то проверяет
        //  необстрелянные клетки по 4 сторонам от данной
        int xPos = rnd.nextInt(10);
        int yPos = rnd.nextInt(10);
        return Shot.doShot(xPos, yPos, firedBoard);
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

    public LinkedHashMap<Integer, Integer> getShipOnBoard() {
        return shipOnBoard;
    }

    public void setShipOnBoard(LinkedHashMap<Integer, Integer> shipOnBoard) {
        this.shipOnBoard = shipOnBoard;
    }
}
