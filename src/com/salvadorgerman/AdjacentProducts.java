package com.salvadorgerman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AdjacentProducts {

    public static void main(String[] args) {
        String file = "src/com/salvadorgerman/digits.txt";
        int adjacentDigits = 13;
        long maxProduct = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            String digits = sb.toString();
            int len = digits.length();

            for (int i = 0; i < len - adjacentDigits; i++) {
                long product = 1;
                for (int j = 0; j < adjacentDigits; j++) {
                    product *= Character.getNumericValue(digits.charAt(i+j));
                }
                if (product > maxProduct) {
                    maxProduct = product;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("The maximum product of " + adjacentDigits + " adjacent digits is " + maxProduct);
    }
}
