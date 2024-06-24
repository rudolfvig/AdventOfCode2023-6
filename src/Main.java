import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Main {
    public static void main(String[] args) {

        MyFileScanner sc = new MyFileScanner("input.txt");
        ArrayList<String> lines = sc.getLines();
        NumberIdentificationFromLine numIdentification = new NumberIdentificationFromLine();
        List<Integer> times = numIdentification.setLineAndGetNumbers(lines.get(0))
                .stream()
                .map(Long::intValue) // Convert Long to Integer
                .toList();
        List<Integer> recordDistances = numIdentification.setLineAndGetNumbers(lines.get(1))
                .stream()
                .map(Long::intValue) // Convert Long to Integer
                .toList();

        ArrayList<Race> races = new ArrayList<>();
        for(int i = 0; i < times.size(); i++){
            races.add(new Race(times.get(i), recordDistances.get(i)));
        }
        int resultOfProblem = 1;
        for (Race race : races){
            resultOfProblem *= race.getAllBetterPossibilities();
            System.out.println("Better possibilities: "+ race.getAllBetterPossibilities());
        }
        System.out.println("result: " + resultOfProblem);

        StringBuilder sbForTime = new StringBuilder();
        for(Integer time : times){
            sbForTime.append(time);
        }
        StringBuilder sbForRecordDistance = new StringBuilder();
        for(Integer recordDistance : recordDistances){
            sbForRecordDistance.append(recordDistance);
        }
        long raceTimeForPart2 = Long.parseLong(sbForTime.toString());
        long raceRecordDistanceForPart2 = Long.parseLong(sbForRecordDistance.toString());
        Race raceForPart2 = new Race(raceTimeForPart2, raceRecordDistanceForPart2);
        System.out.println("Result of part 2: " + raceForPart2.getAllBetterPossibilities());
        /*    //understanding the exercise
        int length = 45;
        HashMap<Integer, Integer> racePossibilities = new HashMap<>();
        for (int i = 0; i <= length; i++) {
            System.out.println("distance traveled in powered " + i + ": " + (length - i) * i);
            racePossibilities.put(i, (length - i) * i);
        }
        int count = (int) racePossibilities.values().stream()
                .filter(value -> value > length)
                .count();
        System.out.println(count);
        */

    }
}