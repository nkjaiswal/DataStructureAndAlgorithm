import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArcsiumFootballSelectionPlayer {

    public static void main(String[] args) {
        List<List<String>> data = Arrays.asList(Arrays.asList("Boateng", "6.1", "22", "24", "45"),
                Arrays.asList("Kaka", "6", "22", "1", "1"),
                Arrays.asList("Ronaldo", "5.8", "21", "120", "0"),
                Arrays.asList("Suarez", "5.9", "20", "100", "1"));
        System.out.println(getSelectionStatus(data));
    }
    public static List<List<String>> getSelectionStatus(List<List<String>> applications) {
        List<Player> players = new ArrayList<>();

        // read all text data and convert it to Player Object
        for(List<String> application: applications) {
            players.add(new Player(
                    application.get(0),
                    Double.parseDouble(application.get(1)),
                    Double.parseDouble(application.get(2)),
                    Integer.parseInt(application.get(3)),
                    Integer.parseInt(application.get(4))
            ));
        }

        // create different player filters
        PlayerFilter fitnessFilter = new FitnessFilter();
        PlayerFilter strikerFilter = new StrikerFilter();
        PlayerFilter defenderFilter = new DefenderFilter();

        //filter out most fit player for the Role (Defender/Striker)
        List<Player> potentialStriker = players.stream().filter(fitnessFilter::isFit).filter(strikerFilter::isFit).collect(Collectors.toList());
        List<Player> potentialDefender = players.stream().filter(fitnessFilter::isFit).filter(defenderFilter::isFit).collect(Collectors.toList());

        // sort the player based on the capability / strength
        potentialStriker.sort((a, b) -> b.getScores() - a.getScores());
        potentialDefender.sort((a, b) -> b.getDefends() - a.getDefends());

        // place to store selected players
        Set<Player> striker = new HashSet<>();
        Set<Player> defender = new HashSet<>();

        /*
            Select player one by one. If you have more number of defender then select striker first and vice versa.
            Once you selected the striker/defender, then select defender/striker
            Add them to the above hash set and remove them from the list of potential players since they are already selected.
            Make sure to filter out those player who are already selected for other group.
            For example one player can be both potential striker and potential defender, but once he is selected in one group,
            he should not be the part of other group
         */
        while (!potentialDefender.isEmpty() && !potentialStriker.isEmpty()) {
            if (potentialDefender.size() < potentialStriker.size()) {
                selectPlayerWhoIsNotPartOfOtherGroup(potentialDefender, striker,defender);
                selectPlayerWhoIsNotPartOfOtherGroup(potentialStriker, defender, striker);
            } else {
                selectPlayerWhoIsNotPartOfOtherGroup(potentialStriker, defender, striker);
                selectPlayerWhoIsNotPartOfOtherGroup(potentialDefender, striker, defender);
            }
        }

        List<Player> finalStrikers = new ArrayList<>(striker);
        List<Player> finalDefenders = new ArrayList<>(defender);

        // sort player again, since hash set does not preserve the order.
        finalStrikers.sort((a, b) -> b.getScores() - a.getScores());
        finalDefenders.sort((a, b) -> b.getDefends() - a.getDefends());

        // both group should have same number of player, so remove if there are extras
        if (finalStrikers.size() > finalDefenders.size()) {
            removeLastNEntry(finalStrikers, finalStrikers.size() - finalDefenders.size());
        } else {
            removeLastNEntry(finalDefenders, finalDefenders.size() - finalStrikers.size());
        }

        List<List<String>> sol = new ArrayList<>();

        // Loop through all the player to check if they are selected or not
        for (Player player : players) {
            if (striker.contains(player)) {
                sol.add(Arrays.asList(player.getName(), "SELECT", "STRIKER"));
            } else if (defender.contains(player)) {
                sol.add(Arrays.asList(player.getName(), "SELECT", "DEFENDER"));
            } else {
                sol.add(Arrays.asList(player.getName(), "REJECT", "NA"));
            }
        }
        return sol;
    }

    /**
     * It removes last {@count} player
     * @param players: List of Players
     * @param count: No of player need to be removed
     */
    private static void removeLastNEntry(List<Player> players, int count) {
        for(int i=0; i<count; i++){
            players.remove(players.size()-1);
        }
    }

    /**
     * It will select player for Striker/Defender and make sure that one player is not part of other group
     * @param potentialPlayerGroupA: List of potential player of one group
     * @param groupB: Set of all player in other group
     * @param groupA: Group on which player need to be added
     */
    private static void selectPlayerWhoIsNotPartOfOtherGroup(List<Player> potentialPlayerGroupA, Set<Player> groupB, Set<Player> groupA) {
        Player currentDefender = potentialPlayerGroupA.size() > 0 ? potentialPlayerGroupA.remove(0) : null;
        while (groupB.contains(currentDefender) && currentDefender != null) {
            currentDefender = potentialPlayerGroupA.size() > 0 ? potentialPlayerGroupA.remove(0) : null;
        }
        if (currentDefender != null)
            groupA.add(currentDefender);
    }
}

class Player {
    private String name;
    private double height, bmi;
    private int scores;
    private int defends;

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getBmi() {
        return bmi;
    }

    public int getScores() {
        return scores;
    }

    public int getDefends() {
        return defends;
    }

    public Player(String name, double height, double bmi, int scores, int defends) {
        this.name = name;
        this.height = height;
        this.bmi = bmi;
        this.scores = scores;
        this.defends = defends;
    }
    @java.lang.Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", bmi=" + bmi +
                ", scores=" + scores +
                ", defends=" + defends +
                '}';
    }
}

interface PlayerFilter {
    boolean isFit(Player player);
}
class StrikerFilter implements  PlayerFilter {
    private final int minGoalScored = 50;

    @java.lang.Override
    public boolean isFit(Player player) {
        return player.getScores() >= minGoalScored;
    }
}

class DefenderFilter implements  PlayerFilter {
    private final int minGoalDefended = 30;

    @java.lang.Override
    public boolean isFit(Player player) {
        return player.getDefends() >= minGoalDefended;
    }
}

class FitnessFilter implements  PlayerFilter {
    private final double minHeight = 5.8;
    private final double maxBmi = 23;

    @java.lang.Override
    public boolean isFit(Player player) {
        return player.getHeight() >= minHeight && player.getBmi() <= maxBmi;
    }
}
