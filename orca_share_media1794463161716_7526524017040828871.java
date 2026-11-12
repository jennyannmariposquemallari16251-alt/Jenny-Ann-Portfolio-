import java.util.Random;
import java.util.Scanner;

public class GuessTheWord {
    static Scanner input = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        String[] subjects = {"Math", "Science", "English"};
        String[][][] words = {
            { // Math
                {"sum", "The answer when numbers are added."},
                {"fraction", "A number that represents part of a whole."},
                {"denominator", "The bottom number in a fraction."}
            },
            { // Science
                {"sun", "The star at the center of our solar system."},
                {"oxygen", "A gas that humans need for breathing."},
                {"photosynthesis", "The process plants use to make their own food."}
            },
            { // English
                {"noun", "A word that names a person, place, thing, or idea."},
                {"adjective", "A word that describes a noun."},
                {"metaphor", "A figure of speech that directly compares two unlike things."}
            }
        };

        System.out.println("================================");
        System.out.println("          GUESS THE WORD");
        System.out.println("================================");

        System.out.println("Choose a subject:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }

        System.out.print("Enter your choice: ");
        int subjectChoice = readChoice(1, 3);
        int subjectIndex = subjectChoice - 1;

        System.out.println("\nChoose difficulty:");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter your choice: ");
        int difficultyChoice = readChoice(1, 3);

        // Each subject has one word for each difficulty level.
        int wordIndex = difficultyChoice - 1;
        String answer = words[subjectIndex][wordIndex][0];
        String hint = words[subjectIndex][wordIndex][1];

        System.out.println("\nSubject: " + subjects[subjectIndex]);
        System.out.println("Clue: " + hint);
        System.out.println("You have 3 attempts.");

        int attempts = 3;
        boolean correct = false;

        while (attempts > 0 && !correct) {
            System.out.print("\nEnter your guess: ");
            String guess = input.nextLine().trim();

            if (guess.equalsIgnoreCase(answer)) {
                correct = true;
                System.out.println("Correct! Good job!");
            } else {
                attempts--;
                if (attempts > 0) {
                    System.out.println("Wrong answer. Try again.");
                    System.out.println("Attempts left: " + attempts);
                } else {
                    System.out.println("No more attempts.");
                    System.out.println("The correct answer is: " + answer);
                }
            }
        }

        System.out.println("\nThank you for playing!");
        input.close();
    }

    // This method checks if the player's menu choice is valid.
    static int readChoice(int minimum, int maximum) {
        while (true) {
            if (input.hasNextInt()) {
                int choice = input.nextInt();
                input.nextLine();

                if (choice >= minimum && choice <= maximum) {
                    return choice;
                }
            } else {
                input.nextLine();
            }

            System.out.print("Invalid choice. Enter " + minimum + " to " + maximum + ": ");
        }
    }
}
