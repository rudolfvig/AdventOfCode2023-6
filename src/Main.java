import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int length = 100;
        HashMap<Integer, Integer> racePossibilities = new HashMap<>();
        for (int i = 0; i <= length; i++) {
            System.out.println("distance traveled in powered " + i + ": " + (length - i) * i);
            racePossibilities.put(i, length - i);
        }
        

    }
}