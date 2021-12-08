package day1.part2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowSum {
	public static void main(String[] args) {
        String filepath = args[0];
        List<String> lines = List.of();
        ArrayList<Integer> sumList = new ArrayList<>();
        int counter = 0;
        try {
            lines = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < lines.size(); i++) {
            try {
                sumList.add(Integer.valueOf(lines.get(i)) + Integer.valueOf(lines.get(i + 1)) + Integer.valueOf(lines.get(i + 2)));
            } catch (IndexOutOfBoundsException e) {
                // If index is out of bounds, that means we don't have enough elements for a 3 sum
                break;
            }
        }

        for (int i = 1; i < sumList.size(); i++) {
            if (sumList.get(i) > sumList.get(i -1)) {
                counter++;
            }
        }

        System.out.println(counter);
	}
}
