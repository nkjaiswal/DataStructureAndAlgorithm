import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AmazonPrimeShipping {
    public static void main(String[] args) {
        List<Route> forwardRoute = new ArrayList<>();
        List<Route> reverseRoute = new ArrayList<>();

        forwardRoute.add(new Route(1, 3000));
        forwardRoute.add(new Route(2, 5000));
        forwardRoute.add(new Route(3, 7000));
        forwardRoute.add(new Route(4, 10000));

        reverseRoute.add(new Route(1,2000));
        reverseRoute.add(new Route(2,3000));
        reverseRoute.add(new Route(3,4000));
        reverseRoute.add(new Route(4,5000));

        System.out.println(new AmazonPrimeShipping().optimalPath(10000, forwardRoute, reverseRoute));
    }

    int maxCost;
    List<List<Integer>> optimalPath(int maxTravDist, List<Route> forwardRoute, List<Route> reverseRoute){
        maxCost = Integer.MIN_VALUE;
        reverseRoute.sort(Comparator.comparing(Route::getCost).reversed());
        List<List<Integer>> solution = new ArrayList<>();

        for(Route r : forwardRoute){
            addSolution(maxTravDist - r.getCost(), solution, reverseRoute, r);
        }

        Map<Integer, Route> fRouteMap = forwardRoute.stream().collect(Collectors.toMap(Route::getIdentifier, Function.identity()));

        Map<Integer, Route> rRouteMap = reverseRoute.stream().collect(Collectors.toMap(Route::getIdentifier, Function.identity()));

        List<List<Integer>> finalSolution = new ArrayList<>();

        for(List<Integer> s : solution){
            if(fRouteMap.get(s.get(0)).getCost() + rRouteMap.get(s.get(1)).getCost() == maxCost){
                finalSolution.add(Arrays.asList(s.get(0), s.get(1)));
            }
        }
        return finalSolution;
    }

    private void addSolution(int dist, List<List<Integer>> solution, List<Route> reverseRoute, Route fRoute) {
        if(dist<=0){
            return;
        }
        Optional<Route> op = justSmallerRoute(dist, reverseRoute);
        if(op.isPresent()){
            solution.add(Arrays.asList(fRoute.getIdentifier(), op.get().getIdentifier()));
            maxCost = Math.max(maxCost, fRoute.getCost() + op.get().getCost());
        }
    }

    private Optional<Route> justSmallerRoute(int dist, List<Route> reverseRoute){
        return reverseRoute.stream().filter(r -> r.getCost() <= dist).findFirst();
    }


}


class Route{
    int identifier;

    public int getIdentifier() {
        return identifier;
    }

    public int getCost() {
        return cost;
    }

    int cost;
    public Route(int identifier, int cost) {
        this.identifier = identifier;
        this.cost = cost;
    }
}