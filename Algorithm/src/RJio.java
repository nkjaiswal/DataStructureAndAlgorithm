import java.util.Arrays;
import java.util.stream.Stream;

public class RJio {
    public static void main(String[] args) {
        String str = "Multiple findme classes and nested static findme classes are supported, Printing unwanted or ill-formatted data to output will cause the test findmecases to failfindme";
        System.out.println(str.split("findme").length);
    }
}
