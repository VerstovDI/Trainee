package ReflectionTasks;

import java.util.Random;

public class KeyPhraseValidator {
    @KeyPhrase(keyPhrase = "Hi, Ben")
    public static String generateUniqueAuthPair() {
        return String.valueOf(new Random().nextInt());
    }
}
