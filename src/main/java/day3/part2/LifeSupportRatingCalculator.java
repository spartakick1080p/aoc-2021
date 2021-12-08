package day3.part2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LifeSupportRatingCalculator {

    private static List<String> input;

    @SuppressWarnings("Unused")
    public static void main(String[] args) {

        String filepath = args[0];
        int oxygenRating;
        int CO2rating;

        try {
            input = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
        } catch (Exception e) {
            System.out.println(e);
        }

            oxygenRating = findRating(input, "Oxygen");
            CO2rating = findRating(input, "CO2");

            System.out.println(oxygenRating * CO2rating);

    }

    static int findRating(List<String> codes, String gasName) {

        String ratingCode = null;
        for (int i = 0; i < codes.get(0).length(); ++i) {
            int ones = 0;
            for (String code : codes) {
                if (code.charAt(i) == '1') {
                    ++ones;
                }
            }

            int zeros = codes.size() - ones;
            List<String> newCodes = new ArrayList<String>();
            for (String code : codes) {
                if (ones >= zeros) {
                    if ((gasName.equals("Oxygen") && code.charAt(i) == '1') ||
                            (gasName.equals("CO2")    && code.charAt(i) == '0')) {
                        newCodes.add(code);
                    }
                } else {
                    if ((gasName.equals("Oxygen") && code.charAt(i) == '0') ||
                            (gasName.equals("CO2")    && code.charAt(i) == '1')) {
                        newCodes.add(code);
                    }
                }
            }

            codes = newCodes;
            if (codes.size() == 1) {
                ratingCode = codes.get(0);
                break;
            }
        }

        return Integer.parseInt(ratingCode, 2);
    }
}
