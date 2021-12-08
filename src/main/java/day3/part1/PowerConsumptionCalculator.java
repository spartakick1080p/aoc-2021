package day3.part1;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PowerConsumptionCalculator {

    private static String gammaRate = "";
    private static String epsilonRate = "";
    private static List<String> input;
    private static int majorityComparator = 0;

    @SuppressWarnings("Unused")
    public static void main(String[] args) {

        String filepath = args[0];

        try {
            input = Files.readAllLines(Paths.get(filepath), StandardCharsets.UTF_8);
            majorityComparator = input.size() / 2;
        } catch (Exception e) {
            System.out.println(e);
        }

        for (int i = 0; i < input.get(0).length(); i++) {
            int oneCount = 0;
            int zeroCount = 0;
            for (int j = i; j < input.size(); j++) {

                if (oneCount > majorityComparator) {
                    gammaRate += "1";
                    break;
                } else if (zeroCount > majorityComparator) {
                    gammaRate += "0";
                    break;
                }

                if (input.get(j).charAt(i) == '1') {
                    oneCount++;
                } else {
                    zeroCount++;
                }
            }
        }

        // Epsilon rate is the inverse of the gamma rate
        for (int i = 0; i < gammaRate.length(); i++) {
            epsilonRate+=gammaRate.charAt(i) == '1' ? "0" : "1";
        }

        int gammaRateDecimal = Integer.parseUnsignedInt(gammaRate, 2);
        int epsilonRateDecimal = Integer.parseUnsignedInt(epsilonRate, 2);

        System.out.println(gammaRateDecimal * epsilonRateDecimal);

    }
}
