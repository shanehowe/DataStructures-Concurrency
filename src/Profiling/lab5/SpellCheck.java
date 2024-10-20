package Profiling.lab5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * This program checks which words in a file are not present in a dictionary.
 */
public class SpellCheck {

    public static void main(String[] args) throws FileNotFoundException {
        Collection<String> dictionaryWords = readDictionary("src/Profiling.lab5/words");
        Set<String> documentWords = readWords("src/Profiling.lab5/war-and-peace.txt");

        System.out.println("Number of misspelled words: " + countIncorrectlySpeltWords(documentWords, dictionaryWords));
    }

    private static int countIncorrectlySpeltWords(Collection<String> document, Collection<String> dictionary) {
        return (int) document.stream().filter(dictionary::contains).count();
    }

    private static Collection<String> readDictionary(String filename) throws FileNotFoundException {
        Collection<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));

        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        return words;
    }

    /**
     * Reads all words from a file.
     *
     * @param filename the name of the file
     * @return a set with all lowercased words in the file. Here, a
     * word is a sequence of upper- and lowercase letters.
     */
    public static Set<String> readWords(String filename) throws FileNotFoundException {
        Set<String> words = new HashSet<>();
        Scanner in = new Scanner(new File(filename));
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext()) {
            words.add(in.next().toLowerCase());
        }
        in.close();
        return words;
    }
}
