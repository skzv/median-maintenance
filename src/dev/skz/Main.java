package dev.skz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // MedianMaintainer<Integer> mm = new MedianMaintainer<>();
        // mm.add(1);
        // System.out.println(mm.getMedian());
        // mm.add(2);
        // System.out.println(mm.getMedian());
        // mm.add(3);
        // System.out.println(mm.getMedian());
        // mm.add(4);
        // System.out.println(mm.getMedian());
        // mm.add(5);
        // System.out.println(mm.getMedian());

        MedianMaintainer<Integer> mm = new MedianMaintainer<>();
        int medianSumModulo = 0;
        for (int x : readIntegersFromFile()) {
            mm.add(x);
            medianSumModulo = (medianSumModulo + mm.getMedian()) % 10_000;
        }
        System.out.println(medianSumModulo);
    }

    static List<Integer> readIntegersFromFile() {
        List<Integer> numbers = new ArrayList<>();

        File file = Paths.get("Median.txt").toFile();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return numbers;
    }
}
