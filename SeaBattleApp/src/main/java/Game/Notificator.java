package Game;

import GameLogic.AI.AI;

import java.lang.System;

import static java.lang.System.out;

public class Notificator {
    public static void printShotResult(Boolean result) {
        if (result) {
            System.out.println("| ---> Hit!");
        } else {
            System.out.println("| ---> Missed!");
        }
    }

    public static boolean isGameEnded(AI computer) {
        String winner;
        if ((GameOptions.currentNumberOfShips.keySet().isEmpty())) {
            winner = "user";
            if ((computer.getAIShipsOnBoard().keySet().isEmpty())) {
                winner = "opponent";
            }
            GameRunner.setGameStatus(GameState.ENDED);
            out.println("\t\t\t~ ~ ~ Game over! " + winner + " wins! ~ ~ ~");
            return true;
        } else {
            return false;
        }
    }
}
