import java.util.Scanner;

public class GameManager {
    private WordsDB wordsDB;
    private DrawingTool drawingTool;
    private char[] correctWord;
    private char[] currentWord;
    private int failsCoint = 0;

    public GameManager() {
        this.wordsDB = new WordsDB();
        this.drawingTool = new DrawingTool();
    }

    public void StartGame() {
        correctWord = wordsDB.GetNewWord();
        currentWord = wordsDB.GetNewEmptyWord(correctWord.length);
        Scanner scanner = new Scanner(System.in);
        while(true){
            drawingTool.PrintGameInfo(currentWord, failsCoint);
            FinishGame();
            String input =  scanner.nextLine();
            if (wordsDB.CheckWordOnLetter(input.charAt(0), correctWord)){
                currentWord = wordsDB.OpenTheLetters(input.charAt(0), correctWord, currentWord);
            }
            else {
                failsCoint ++;
            }

        }
    }

    public void FinishGame() {
        int counter = 0;
        for(int i = 0; i < correctWord.length; i++){
            if(correctWord[i] != currentWord[i]){
                counter ++;
            }
        }
        if (counter == 0)
        {
            System.out.println("You win!");
            RestartGame();
        }
        if (failsCoint > 5){
            System.out.println("You lose!");
            RestartGame();
        }
    }

    public void RestartGame() {
        System.out.println("You wanna try again? (1 - yes, 2 - no)");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if (input.charAt(0) == '1'){
            StartGame();
        }
        else {
            System.exit(0);
        }
    }
}
