package Game;

// The main and only entry point to the APP game "Sea Battle!"
public class Main {
    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();  // Creating game loader
        // Starting new game with default options. For configuring go to GameOptions class
        gameRunner.startNewGame();
    }
}
