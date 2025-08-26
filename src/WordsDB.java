import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WordsDB {

    private final Path wordsFilePath = Paths.get("src\\resources\\words.txt");

    public char[] GetNewWord(){
        try{
            List<String> words = Files.readAllLines(wordsFilePath);
            Random rand = new Random();
            return words.get(rand.nextInt(1, words.size())).toCharArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public char[] GetNewEmptyWord(int length){
        char[] newEmptyWord = new char[length];
        Arrays.fill(newEmptyWord, '_');
        return newEmptyWord;
    }

    public boolean CheckWordOnLetter(char letter, char[] correctWord){
        int letterCounter = 0;
        for (char c : correctWord) {
            if (c == letter) {
                letterCounter++;
            }
        }
        return letterCounter > 0;
    }

    public char[] OpenTheLetters(char letter, char[] correctWord, char[] currentWord) {
        for(int i = 0; i < correctWord.length; i++){
            if(correctWord[i] == letter){
                currentWord[i] = letter;
            }
        }
        return currentWord;
    }
}
