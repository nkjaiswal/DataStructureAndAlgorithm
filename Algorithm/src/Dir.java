import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Dir {
    public static void main(String[] args) throws IOException {
        if(!Files.isDirectory(Paths.get("./test"))){
            Files.createDirectories(Paths.get("./test"));
            System.out.println("Created");
        }
    }
}
