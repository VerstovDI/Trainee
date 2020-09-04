package Game;

import Content.Ship;
import DataInput.Input;
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
    private static GameState gameStatus = GameState.EMPTY;

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
            // Ship arrangement block (user's)
            while (!gameOptions.shipsConfig.equals(GameOptions.currentNumberOfShips)) {
                Ship ship = Input.getShip(gameOptions);
                ShipArrangement.putShip(ship, gameOptions.getBoards()[0]);
                FieldsView.printNewFields(gameOptions.boards[0], gameOptions.boards[1]);
            }
            out.println("| Your ships are arranged!\n" +
                    "| Opponents ships arrangement...");
            AI computer = new AI(gameOptions);  // Ship arrangement block (AI's)s
            computer.autoPutShip(gameOptions.getBoards()[1]);
            FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
        while (gameStatus != GameState.ENDED) {
            boolean result;
            out.println("| Your shot: ");
            do {  // result - hit/missed
                Notificator.isGameEnded(computer);
                result = Shot.playerShot(gameOptions.getBoards()[1], GameOptions.currentNumberOfShips);
                Notificator.printShotResult(result);
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);

            out.println("| Opponents shot: ");
            do {
                Notificator.isGameEnded(computer);
                result = computer.AIShot(gameOptions.getBoards()[0], computer.getAIShipsOnBoard());
                Notificator.printShotResult(result);
                FieldsView.printNewFields(gameOptions.getBoards()[0], gameOptions.getBoards()[1]);
            } while (result);
        }
        }
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

    public static void setGameStatus(GameState gameStatus) {
        GameRunner.gameStatus = gameStatus;
    }

    @Override
    public String toString() {
        return "GameRunner{" +
                "gameOptions=" + gameOptions +
                ", gameStatus=" + gameStatus +
                '}';
    }
}
