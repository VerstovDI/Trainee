package Game;

import java.lang.System;

public class Notificator {
    public static void printShotResult(Boolean result) {
        if (result) {
            System.out.println("| ---> Hit!");
        } else {
            System.out.println("| ---> Missed!");
        }
    }
}
