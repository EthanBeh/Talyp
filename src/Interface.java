import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    private Scanner s;
    private static ArrayList<Word> words = new ArrayList<Word>();

    public Interface() {
        s = new Scanner(System.in);
        start();
    }

    public void start() {
        readData();
        welcome();
    }

    public void welcome() {
        System.out.println("Welcome to the Talyp Tool!");
        System.out.println("What would you like to do today");
        String choice = printMenu();
        while (Integer.parseInt(choice) != 3) {
            if (Integer.parseInt(choice) == 1) {
                System.out.println("Please choose a word to conjugate: ");
                String wrd = s.nextLine();
                for (int i = 0; i < words.size(); i++) {
                    if (words.get(i).getWord().equals(wrd)) {
                        String[][] conj = ((Verb) words.get(i)).getConjugationTable();
                        for (String[] row : conj) {
                            for (String con : row) {
                                System.out.print(con + " ");
                            }
                            System.out.println();
                        }
                    }
                }
            } else if (Integer.parseInt(choice) == 2) {
                for (int i = 0; i < words.size(); i++) {
                    System.out.println(words.get(i));
                }
            } else {
                System.out.print("That's not a valid option, please try again: ");
                choice = s.nextLine();
                continue;
            }
            printMenu();
        }
    }

    public String printMenu() {
        System.out.println("(1) See a verb's whole conjugation table");
        System.out.println("(2) View Talyp dictionary");
        System.out.println("(3) Quit");
        return s.nextLine();
    }

    private void readData() {
        try {
            File myFile = new File("src\\WordList");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String s = fileScanner.nextLine();
                String[] splitData = s.split(",");
                Word w;
                if (splitData[1].equals("v")) {
                    w = new Verb(splitData[0], splitData[1], splitData[2]);
                } else {
                    w = new Word(splitData[0], splitData[1], splitData[2]);
                }
                words.add(w);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
