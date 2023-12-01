import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InputReader {
    //da
    public static String getFile(int task){
        String path = "src/main/resources/input/input"+task+".txt";

        String fileContent;

        try {
            fileContent = Files.readString(Paths.get(path));
        } catch (IOException e) {
            fileContent = ""; // Assign an empty string or handle as needed
            throw new RuntimeException(e.getMessage());
        }
        return fileContent;
    }

    public static String[] getLines(int task){
        return getFile(task).split("\n");
    }




}
