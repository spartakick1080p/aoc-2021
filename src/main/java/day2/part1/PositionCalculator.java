package day2.part1;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PositionCalculator {

    private static int horizontal = 0;
    private static int depth = 0;

	public static void main(String[] args) {
		String filepath = args[0];
        List<String> lines = List.of();
        try {
            lines = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e);
        }

        lines.forEach(line -> calculateDepth(line));


        int position = horizontal * depth;
        System.out.println("Position (" + position + ") = " + horizontal + " " + depth);
	}

    private static void calculateDepth(String val) {
        String command = val.split(" ")[0];
        String value = val.split(" ")[1];

        switch (command) {
            case "forward":
                horizontal+=Integer.valueOf(value);
                break;
            case "down":
                depth+=Integer.valueOf(value);
                break;
            case "up":
                depth-=Integer.valueOf(value);;
                break;
            default:
                break;
        }

    }
}
