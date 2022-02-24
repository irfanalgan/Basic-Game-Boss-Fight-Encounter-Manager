import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.util.function.*;

import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toMap;

public class LogParser {

    public static void main(String[] args) throws FileNotFoundException {

   
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("encounterLogs.csv"))));

        Function<String, PlayerScore> mapToLogs = (line) -> {
            String[] p = line.split(",");
            return new PlayerScore(p[0], p[1], Integer.parseInt(p[2]), Integer.parseInt(p[3]), Integer.parseInt(p[4]), Integer.parseInt(p[5]), Integer.parseInt(p[6]));
        };
        List<PlayerScore> scores = br.lines().skip(1).map(mapToLogs).collect(Collectors.toList());

    // Query 1: Damage received by the player named Chopper.
        System.out.println("Query 1:");
        scores.stream()
                .filter(s -> s.getPlayerName().equals("Chopper"))
                .map(PlayerScore::getDamageReceived)
                .forEach(System.out::println);
        System.out.println("--------");

    // Query 2: List of healers' names that did more healing than 300 (HealingDone > 300) 
        System.out.println("Query 2:");
        scores.stream()
                .filter(s -> s.getHealingDone() > 300)
                .map(PlayerScore::getPlayerName)
                .sorted()
                .distinct()
                .forEach(System.out::println);
        System.out.println("--------");


    // Query 3: Damage dealt per damage received ratio for tanks
        System.out.println("Query 3:");
        scores.stream()
                .filter(s -> s.getRole().equals("Tank"))
                .map(s-> (double)s.getDamageDealt()/s.getDamageReceived())
                .forEach(System.out::println);
        System.out.println("--------");


    // Query 4: The name of the damage dealer that dealt the least amount of damage per attack (DamageDealt/Attacks)
        System.out.println("Query 4:");
        System.out.println(scores.stream()
                .filter(s -> s.getRole().equals("DamageDealer"))
                .min(Comparator.comparing(PlayerScore::getDamagePerAttack))
                .get()
                .getPlayerName());
        System.out.println("--------");

    // Query 5: How much healing was received by the tank that dealt the most damage 
        System.out.println("Query 5:");
        System.out.println(scores.stream()
                .filter(s -> s.getRole().equals("Tank"))
                .max(Comparator.comparing(PlayerScore::getDamageDealt))
                .get()
                .getHealingReceived());
        System.out.println("--------");
    }

}
