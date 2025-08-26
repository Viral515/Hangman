import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DrawingTool {
    private final long GALLOWSLINESCOUNT = 8;

    private final Path hangmanGallowsFilePath = Paths.get("src\\resources\\HangmanGallows.txt");

    public void PrintGameInfo(char[] currentWord, int failsCount){
        try {
            System.out.println("\nCurrent word: " + Arrays.toString(currentWord));
            System.out.println("Fails counter: " + failsCount);
            List<String> gallows = Files.readAllLines(hangmanGallowsFilePath);
            for(int i = (int) (failsCount*GALLOWSLINESCOUNT); i < failsCount*GALLOWSLINESCOUNT+GALLOWSLINESCOUNT; i++){
                System.out.println(gallows.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
