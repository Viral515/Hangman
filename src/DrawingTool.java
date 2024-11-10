import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DrawingTool {
    private static long GALLOWSLINESCOUNT = 8;

    private Path hangmanGallowsFilePath = Paths.get("D:\\GithubProjects\\Hangman\\src\\resources\\HangmanGallows.txt");

    public void PrintGameInfo(char[] currentWord, int failsCount){
        try {
            System.out.println("Current word: " + Arrays.toString(currentWord));
            System.out.println("Fails counter: " + failsCount);
            List<String> gallows = Files.readAllLines(hangmanGallowsFilePath);
            for(int i = (int) (failsCount*GALLOWSLINESCOUNT); i < failsCount*GALLOWSLINESCOUNT+GALLOWSLINESCOUNT; i++){
                System.out.println(gallows.get(i));
            }
            System.out.println("");
            System.out.print("Enter the letter: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
