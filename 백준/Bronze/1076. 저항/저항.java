import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Map<String, Integer> colorMap = Map.of(
            "black", 0,
            "brown", 1,
            "red", 2,
            "orange", 3,
            "yellow", 4,
            "green", 5,
            "blue", 6,
            "violet", 7,
            "grey", 8,
            "white", 9
        );

        String color1 = br.readLine().trim();
        String color2 = br.readLine().trim();
        String color3 = br.readLine().trim();

        int significantValue = colorMap.get(color1) * 10 + colorMap.get(color2);

        int multiplier = colorMap.get(color3);

        long resistance = significantValue * (long) Math.pow(10, multiplier);

        System.out.println(resistance);
    }
}