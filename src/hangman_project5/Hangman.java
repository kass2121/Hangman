package hangman_project5;

import java.util.Random;

public class Hangman {


    private static String[] words = {"two", "three", "four", "bus", "larva", "hangman", "class"};

    private String chosenWord;

    private char[] correct;

    private char[] incorrect = new char[7];

    private int guesses = 0;

    public Hangman() {
        Random randomWord = new Random();
        int wordNumber = randomWord.nextInt(words.length);
        chosenWord = words[wordNumber];
        correct = new char[chosenWord.length()];
        for (int x = 0; x < chosenWord.length(); x++) {
            correct[x] = '_';
        }
    }


    private boolean gameWon() {
        for (int x = 0; x < chosenWord.length(); x++) {
            if (correct[x] == '_') {
                return false;
            }
        }
        return true;
    }

    private boolean gameLost() {
        if (guesses >= 7) return true;
        return false;
    }


    private boolean gameOver() {
        return (gameWon() || gameLost());
    }


    private void handleGuess(char ch) {

        for (int x = 0; x < chosenWord.length(); x++) {
            if (chosenWord.charAt(x) == ch) {
                correct[x] = ch;
            }
        }
    }


    private void printHangman(int numWrong) {
        System.out.println("  ____");
        System.out.println("  |  |");

        if (numWrong > 0) {
            System.out.println("  |  O");
            if (numWrong == 2) {
                System.out.println("  |  |");
            } else if (numWrong == 3) {
                System.out.println("  | \\|");
            } else if (numWrong >= 4) {
                System.out.println("  | \\|/");
            }
            if (numWrong == 5) {
                System.out.println("  | /");
            } else if (numWrong == 6) {
                System.out.println("  | / \\");
            }
        }
        for (int k = 6 - numWrong; k > 0; k--) {
            System.out.println("  |");
        }
        System.out.println("__|__");
        System.out.println();
    }
}


