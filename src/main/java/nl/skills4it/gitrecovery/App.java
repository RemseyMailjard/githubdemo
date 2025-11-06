package nl.skills4it.gitrecovery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final List<String> NOTES = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("another bug");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Git Recovery Demo ===");
            System.out.println("1. Show notes");
            System.out.println("2. Add note");
            System.out.println("3. Remove first note (simulate bug)");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    showNotes();
                    break;
                case "2":
                    System.out.print("Enter note: ");
                    String note = scanner.nextLine();
                    NOTES.add(note);
                    System.out.println("Note added.");
                    break;
                case "3":
                    simulateBug();
                    break;
                case "0":
                    System.out.println("Bye!");
                    return;
                default:
                    System.out.println("Unknown option.");
            }
        }
    }

    private static void showNotes() {
        if (NOTES.isEmpty()) {
            System.out.println("(no notes)");
            return;
        }
        System.out.println("\n--- Notes ---");
        for (int i = 0; i < NOTES.size(); i++) {
            System.out.println((i + 1) + ". " + NOTES.get(i));
        }
    }

    private static void simulateBug() {

        System.out.println("I added a bug");
        if (!NOTES.isEmpty()) {
            String removed = NOTES.remove(0);
            System.out.println("Removed: " + removed + " ❌ (Oops!)");
            System.out.println("Now commit this change and recover it via Git!");
        } else {
            System.out.println("No notes to remove.");
        }
    }
}
