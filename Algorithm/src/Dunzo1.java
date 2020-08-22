import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dunzo1 {
    public static void main(String[] args) {
        List<Integer> energy = new ArrayList<>();
        energy.add(1);energy.add(5);energy.add(3);energy.add(3);energy.add(1);
        List<Integer> coins = new ArrayList<>();
        coins.add(3);coins.add(23);coins.add(9);coins.add(2);coins.add(2);

        System.out.println(getRich(1, energy, coins));
        System.out.println(count);
    }

    public static int getRich(long initialEnergy, List<Integer> energy, List<Integer> coins) {
        return collect(initialEnergy, 0, energy, coins);
    }

    private static int count = 0;
    static Map<String, Integer> cache = new HashMap<>();
    public static int collect(long currentEnergy, int currentHouse, List<Integer> energy, List<Integer> coins){
        if (currentEnergy < 0) {
            return 0;
        }
        if(currentHouse >= energy.size()){
            return 0;
        }
        count++;
        if(currentEnergy > energy.size() - currentHouse) {
            currentEnergy = energy.size() - currentHouse;
        }
        if(cache.containsKey(currentEnergy + "_" + currentHouse)){
            return cache.get(currentEnergy + "_" + currentHouse);
        }
        int coin;
        if (currentEnergy >= energy.size() - currentHouse - 1) {
            coin = coins.get(currentHouse) + collect(currentEnergy - 1, currentHouse+1, energy, coins);
        } else {
            coin = Math.max(
              coins.get(currentHouse) + collect(currentEnergy-1, currentHouse+1, energy, coins),
              collect(currentEnergy-1+energy.get(currentHouse), currentHouse+1, energy, coins)
            );
        }
        cache.put(currentEnergy + "_" + currentHouse, coin);
        return coin;
    }
}
