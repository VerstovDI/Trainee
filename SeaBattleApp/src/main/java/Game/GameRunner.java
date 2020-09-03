package Game;

import Content.Ship;
import DataInput.Input;
import DataInput.InputChecker;
import GameLogic.AI.AI;
import GameLogic.ShipArrangement;
import GameLogic.Shot;
import GameView.FieldsView;

import static java.lang.System.out;

/**
Game runner, which provides game options and method for the game.
 Controls game process.
 */
public class GameRunner {
    /**
     * GameOptions object, provides basic game options, such as number of players,
     * board's size, randomness of the first move e.t.c.
     */
    private GameOptions gameOptions;
    /**
     * GameState object to control game's status
     * (game not started, game in progress, game is ended)
     */
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
            out.println("| Arrange your ships, please.\n" +
                    "| Please, enter ships one by one.\n");
            // Ship arrangement block
            while (!gameOptions.shipsConfig.equals(gameOptions.currentNumberOfShips)) {
                Ship ship = Input.getShip(gameOptions);
                if (InputChecker.checkFieldsAroundShip(gameOptions.getBoards()[0], ship)) {
                    ShipArrangement.putShip(ship, gameOptions.getBoards()[0]);
                } else {
                    throw new IllegalArgumentException(
                            "The ship can't be put on board (touches another ship)");
                }
                FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
            }
            out.println("Your ships are arranged!\n" +
                    "Opponents ships arrangement...");
            AI computer = new AI(gameOptions);
            computer.autoPutShip(gameOptions.getBoards()[1]);
            FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
        // TODO: Исправить ввод на: число палуб, базовое поле, направление корабля
        // TODO: декомпозировать ввод
        while (gameStatus != GameState.ENDED) {
            boolean result;
            do {  // result - попал/не попал
                out.println("Enter field to shot, please.");
                out.print("\tEnter x: ");
                int x = Input.inputFieldCoordinate();
                out.print(("\tEnter y: "));
                int y = Input.inputFieldCoordinate();
                result = Shot.doShot(x, y, gameOptions.getBoards()[1]);
                Notificator.printShotResult(result);
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);

            out.println("Opponents shot: ");
            do {
                result = computer.AIShot(gameOptions.getBoards()[0]);
                Notificator.printShotResult(result);
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);
        }
        } else {
            //  Conversely
        }
        // TODO: подумать над тем, как контроллировать статус игры. КОгда игра заканчивается?
        // Игра заканчивается тогда,
        // когда в одной из мап (юзерской или комповской) все ключи имеют значение 0
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
