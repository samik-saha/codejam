/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.samiksaha.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Samik
 */
public class FairAndSquare {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String output;

        Path inputfile = Paths.get("C-large-1.in");
        Path outputfile = Paths.get("C-large-1.out");

        InputStream in = Files.newInputStream(inputfile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(outputfile, charset)) {
            String line = reader.readLine();
            Integer nTestCase = Integer.parseInt(line);
            for (int i = 0; i < nTestCase; i++) {
                line = reader.readLine();
                Scanner scanner = new Scanner(line);
                long start = scanner.nextLong();
                long end = scanner.nextLong();

                int count = 0;
                for (long j = start; j <= end; j++) {
                    if (isPalindrome(j)) {
                        if (isPerfectSquare(j)) {
                            long root = (long) Math.sqrt(j);
                            if (isPalindrome(root)) {
                                count++;
                            }

                        }
                    }
                }

                output = "Case #" + (int) (i + 1) + ": " + count;
                //System.out.println(output);
                writer.write(output);
                writer.newLine();

            }
            writer.close();
        }


    }

    public static long reverse(long number) {

        long result = 0;

        while (number != 0) {
            long lastDigit = number % 10;
            result = result * 10 + lastDigit;
            number = number / 10;
        }

        return result;
    }

    public static boolean isPalindrome(long number) {
        return number == reverse(number);
    }

    public static boolean isPerfectSquare(long n) {
        if (n < 0) {
            return false;
        }

        switch ((int) (n & 0xF)) {
            case 0:
            case 1:
            case 4:
            case 9:
                long tst = (long) Math.sqrt(n);
                return tst * tst == n;

            default:
                return false;
        }
    }
}