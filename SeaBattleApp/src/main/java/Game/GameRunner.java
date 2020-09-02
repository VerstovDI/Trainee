package Game;

import Content.FieldState;
import Content.Ship;
import DataInput.Input;
import DataInput.InputChecker;
import GameLogic.AI.AI;
import GameLogic.ShipArrangement;
import GameLogic.Shot;
import GameView.FieldsView;

import javax.swing.text.FieldView;

import static java.lang.System.out;
import static java.lang.System.in;

import java.util.Scanner;

/*
Загрузчик игры.
Включает в себя заданные игровые опции.
(по умолчанию (поля 10 на 10, первый ходит пользователь) или нет).
Имеет метод startNewGame, запускающий новую игру
 */
public class GameRunner {
    private GameOptions gameOptions;
    private GameState gameStatus = GameState.EMPTY;

    public GameRunner() {
        this.gameOptions = new GameOptions();
    }

    public GameRunner(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    public void startNewGame(){
        out.println("\t\t\t" +
                "~~~~~  W E L C O M E  T O  T H E  S E A  B A T T L E  G A M E  ~~~~~\n");
        gameStatus = GameState.IN_GAME;
        FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
        if (!gameOptions.isRandomFirstMove()) {
            out.println("Arrange your ships, please.\n" +
                    "| Please, enter ships one by one.\n");
            // Блок расстановки кораблей
            while (!gameOptions.shipsConfig.equals(gameOptions.currentNumberOfShips)) {
                // TODO: подумать над условием выхода из цикла

                AI testComp = new AI(gameOptions);
                testComp.autoPutShip(gameOptions.getBoards()[1]);
                FieldsView.printNewFields(gameOptions.getBoards()[0],gameOptions.getBoards()[1]);

                Ship ship = Input.getShip(gameOptions);
                if (InputChecker.checkFieldsAroundShip(gameOptions.getBoards()[0], ship)) {
                    ShipArrangement.putShip(ship, gameOptions.getBoards()[0]);
                } else {
                    throw new IllegalArgumentException(
                            "The ship can't be put on board (touches another ship)");
                }
                // TODO: Зачем в этих манипуляциях ship ?
                FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
            }
            out.println("Your ships are arranged!\n" +
                    "Opponents ships arrangement...");
            AI computer = new AI(gameOptions);
            computer.autoPutShip(gameOptions.getBoards()[1]);
            FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
        // TODO: Исправить ввод на: число палуб, базовое поле, направление корабля
        // TODO: декомпозировать ввод
        Scanner sc = new Scanner(in);
        while (gameStatus != GameState.ENDED) {
            boolean result;
            do {  // result - попал/не попал
                out.println("Enter field to shot, please.");
                out.print("\tEnter x: ");
                int x = sc.nextInt();
                out.print(("\tEnter y: "));
                int y = sc.nextInt();
                result = Shot.doShot(x, y, gameOptions.getBoards()[1]);
                // TODO: сделать Notifier?
                if (result) {
                    out.println("---> Hit!");
                    out.println();
                } else {
                    out.println("---> Missed!");
                }
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);

            System.out.println("Opponents shot: ");
            do {
                result = computer.AIShot();
                if (result) {
                    out.println("---> Hit!");
                    out.println();
                } else {
                    out.println("---> Missed!");
                }
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);
        }
        } else {
            // наоборот
        }
        // TODO: подумать над тем, как контроллировать статус игры. КОгда игра заканчивается?
    }

    public GameOptions getGameOptions() {
        return gameOptions;
    }

    public void setGameOptions(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    public GameState getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameState gameStatus) {
        this.gameStatus = gameStatus;
    }

    @Override
    public String toString() {
        return "GameRunner{" +
                "gameOptions=" + gameOptions +
                ", gameStatus=" + gameStatus +
                '}';
    }
}
