import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GameManager {
    private final WordsDB wordsDB;
    private final DrawingTool drawingTool;
    private char[] correctWord;
    private char[] currentWord;
    private int failsCoint = 0;
    private HashSet<Character> enterLetters = new HashSet<>();

    public GameManager() {
        this.wordsDB = new WordsDB();
        this.drawingTool = new DrawingTool();
    }

    public void Game() {
        correctWord = wordsDB.GetNewWord();
        currentWord = wordsDB.GetNewEmptyWord(correctWord.length);
        Scanner scanner = new Scanner(System.in);
        while(true){
            drawingTool.PrintGameInfo(currentWord, failsCoint);
            System.out.print("Enter the letter: ");
            if (GameFinishCheck()){
                break;
            }
            String input =  scanner.nextLine();
            Pattern pattern = Pattern.compile("[а-я]+");
            final Matcher regexp = pattern.matcher(input);
            if(!regexp.matches()){
                continue;
            }
            if (wordsDB.CheckWordOnLetter(input.charAt(0), correctWord)){
                currentWord = wordsDB.OpenTheLetters(input.charAt(0), correctWord, currentWord);
            }
            else {
                if(!enterLetters.contains(input.charAt(0))){
                    enterLetters.add(input.charAt(0));
                    failsCoint ++;
                }
            }
        }
        StartGame();
    }

    public Boolean GameFinishCheck() {
        if (Arrays.equals(correctWord, currentWord)){
            System.out.println("You win!");
            return true;
        }
        else if (failsCoint > 5){
            System.out.println("You lose!");
            return true;
        }
        return false;
    }

    public void StartGame() {
        System.out.println("You wanna start new game? (1 - yes, 2 - no)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.charAt(0) == '1'){
            failsCoint = 0;
            enterLetters.clear();
            Game();
        }
        else {
            System.exit(0);
        }
    }
}
