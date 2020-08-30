package Game;

import Content.FieldState;
import Content.Ship;
import DataInput.Input;
import GameLogic.ShipArrangement;
import GameLogic.Shot;
import GameView.FieldsView;

import java.util.Scanner;

// Загрузчик игры. Включает в себя заданные игровые опции (по умолчанию (поля 10 на 10, первый ходит пользователь) или нет)
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
        System.out.println("\t\t\t" +
                "~~~~~  W E L C O M E  T O  T H E  S E A  B A T T L E  G A M E  ~~~~~\n");
        gameStatus = GameState.IN_GAME;
        FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
        if (!gameOptions.isRandomFirstMove()) {
            System.out.println("Arrange your ships, please.\n" +
                    "| Please, enter ships one by one.\n");
            // Блок расстановки кораблей
            while (!gameOptions.shipsConfig.equals(gameOptions.currentNumberOfShips)) {
                // TODO: подумать над условием выхода из цикла
                Ship ship = Input.getShip(gameOptions);
                ShipArrangement.putShip(ship, gameOptions);
                // TODO: Зачем в этих манипуляциях ship ?
                FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
            }
            System.out.println("Your ships are arranged!");
            System.out.println("Opponents ships arrangement...");
            // вызываем метод авторасстановки кораблей компа
            // Автогенерация и инициализация полей компа(boards[1])
            // initOpponentField() - внутри вызываются  функции рандомизации
        } else {
            // наоборот
        }
        // TODO: Исправить ввод на: число палуб, базовое поле, направление корабля
        // Блок игры
        // декомпозировать ввод
        Scanner sc = new Scanner(System.in);
        while (gameStatus != GameState.ENDED) {
            System.out.print("Enter field to shot, please: ");
            // Ввод
            System.out.print("Enter x: ");
            int x = sc.nextInt();
            System.out.println(("Enter y: "));
            int y = sc.nextInt();
            boolean result;
            do {  // result - попал/не попал
                result = Shot.doShot(x, y, gameOptions.getBoards()[1]);
                // отображение надписи, что попал или нет
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);

            System.out.println("Opponents shot: ");
            do {
                // result = opponents shot...
                // отображение надписи, попал или нет
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);
        }
        // Декомпозировать
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
