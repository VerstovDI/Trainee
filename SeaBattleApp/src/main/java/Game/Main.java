package Game;

// Основная и единственая точка входа в приложение-игру "Морской бой".
public class Main {
    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();  // Создаём объект GameRunner - "загрузчик" игры
        gameRunner.startNewGame();  // Запускаем новую игру. Играем.
    }
}
