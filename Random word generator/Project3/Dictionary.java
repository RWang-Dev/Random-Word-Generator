package Project3;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

    /**
     * Get the words stored in words.txt
     * Each word will be cleaned, which means it will be converted it to lowercase and remove any non-alphabetic letter.
     */
    public static String[] getWords() {

        // making a scanner from a file. 
        Scanner scan = null;
        try {
            scan = new Scanner(new FileInputStream("words.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        
        List<String> words = new ArrayList<>();
        while(scan.hasNext()) {
            words.add(cleanup(scan.next()));
        }
        return words.toArray(new String[0]);

    }

    private static String cleanup(String input) {

        /*
         * Cleans a given word by making it lowercase and removing all non-alphabetic letters
         */
        input = input.toLowerCase();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isAlphabetic(c)) {
                output.append(c);
            }
        }
        return output.toString();
    }

    public static void main(String[] args) {
        // This serves as the dictionary file's test.
        
        String[] words = getWords();
        System.out.println(words.length);
        for (int i = 0; i < words.length; i += words.length/15) {
            System.out.println("\"" + words[i] + "\"");
        }
    }
    /*
62876
"Aachen"
"Marrakesh"
"alarming"
"bouquets"
"concave"
"diminishes"
"facade"
"hallmarking"
"iodizes"
"misbehave"
"patellae"
"quizzes"
"scragglier"
"stipulating"
"tummies"
"zoological"
     */
}
