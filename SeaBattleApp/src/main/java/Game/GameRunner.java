package Game;

import Content.FieldState;
import Content.Ship;
import DataInput.Input;
import GameLogic.ShipArrangement;
import GameView.FieldsView;

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
        this.gameStatus = GameState.IN_GAME;
        FieldsView.printStartFields();
        if (!gameOptions.isRandomFirstMove()) {
            System.out.println("Arrange your ships, please.\n" +
                    "| Please, enter ships one by one.\n");
            // Блок расстановки кораблей
            while (true) { // TODO: подумать над условием выхода из цикла
                Ship ship = Input.getShip(gameOptions);
                for (int i = ship.getX(); i <= ship.getX() + ship.getDx(); i++) {
                    for (int j = ship.getY(); j <= ship.getY() + ship.getDy(); j++) {
                        ShipArrangement.putShip(ship, gameOptions);
                    }
                }
                // TODO: Зачем в этих манипуляциях ship ?
                FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
            }
            // вызываем метод расстановки кораблей юзера, который вызывает метод сканирования ввода -> обновляем состояния, поля
            // вызываем метод авторасстановки кораблей компа
        } else {
            // наоборот
        }
        // Блок авторасстановки кораблей компа
        // Автогенерация и инициализация полей компа(boards[1])    initOpponentField() - внутри вызываются  функции рандомизации
        // Блок игры
        /*while (gameStatus != gameStatus.ENDED) {
            ...
        }*/
        /* Цикл: пока игра не окончена (ни у кого не закончились корабли)           while (gameStatus != gameStatus.ENDED) { ... };
         Обновление игрового поля
         Отрисовка игрового поля     --> FieldsView
         Ход в порядке очерёдности.  ... .makeMove(xCoordinate, yCoordinate)   makeMove return boolean?
         Если Попал -> обновление игрового поля и ходит дальше, если нет -> передача хода; (цикл внутри? обновляем поле после первой ошибки?)
        */
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
