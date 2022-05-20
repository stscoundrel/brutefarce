package brutefarce;

import java.util.concurrent.ThreadLocalRandom;

public class Bruteforcer {
    static final String ALPHANUMERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private String password;
    private int minLength;
    private int maxLength;
    private long guesses = 1;
    private boolean isNotCracked = true;

    public Bruteforcer(String pass, int min, int max) {
        password = pass;
        minLength = min;
        maxLength = max;
    }

    private int getGuessLength() {
        return ThreadLocalRandom.current().nextInt(minLength, maxLength + 1);
    }

    private String newGuess(int guessLength) {
        StringBuilder stringBuilder = new StringBuilder(guessLength);

        for (int i = 0; i < guessLength; i++) {
            char randomCharacter = ALPHANUMERIC.charAt(ThreadLocalRandom.current().nextInt(0, ALPHANUMERIC.length()));
            stringBuilder.append(randomCharacter);
        }

        return stringBuilder.toString();
    }

    public long breakPassword() {
        while (isNotCracked) {
            String currentGuess = newGuess(getGuessLength());

            System.out.println(guesses + ". Guess is " + currentGuess);

            if (currentGuess.equals(password)) {
                isNotCracked = false;
                System.out.println("Found a match! " + currentGuess);
            }

            guesses++;
        }

        return guesses;
    }
}
