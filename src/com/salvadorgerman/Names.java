package com.salvadorgerman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Names {
    public static void main(String[] args) {
        String file = "src/com/salvadorgerman/first_names.txt";
        List<String> names = readNamesFromFile(file);
        names.sort(Comparator.naturalOrder());

        long total = 0;
        for (int i = 0; i < names.size(); i++) {
            int nameValue = calculateNameValue(names.get(i));
            long nameScore = (long) (i + 1) * nameValue;
            total += nameScore;
        }
        System.out.println("Total score: " + total);
    }

    private static List<String> readNamesFromFile(String file) {
        List<String> names = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.replaceAll("\"", "");
                String[] nameArray = line.split(",");
                names = Arrays.asList(nameArray);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return names;
    }

    private static int calculateNameValue(String name) {
        int value = 0;
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            int charValue = Character.getNumericValue(c) - 9;
            value += charValue;
        }
        return value;
    }
}