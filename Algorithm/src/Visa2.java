import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Visa2 {
    public static void main(String[] args){
        List<String> names = new ArrayList<>();
        List<String> query = new ArrayList<>();
        names.add("steve");
        names.add("stevens");
        names.add("danny");
        names.add("steves");
        names.add("dan");
        names.add("john");
        names.add("johnny");
        names.add("joe");
        names.add("alex");
        names.add("alexander");

        query.add("steve");
        query.add("alex");
        query.add("joe");
        query.add("john");
        query.add("dan");
        System.out.println(findCompletePrefixes(names, query));
    }

    public static List<Integer> findCompletePrefixes(List<String> names, List<String> query){
        List<Integer> queryResult = new ArrayList<>();
        for(String q: query){
            queryResult.add(names.stream().filter(n-> n.startsWith(q) && (!q.equalsIgnoreCase(n))).collect(Collectors.toList()).size());
        }
        return queryResult;
    }
}
