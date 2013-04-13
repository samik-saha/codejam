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
public class Lawnmower {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String output;

        Path inputfile = Paths.get("B-large.in");
        Path outputfile = Paths.get("B-large.out");

        InputStream in = Files.newInputStream(inputfile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(outputfile, charset)) {
            String line = reader.readLine();
            Integer nTestCase = Integer.parseInt(line);
            for (int i = 0; i < nTestCase; i++) {
                line = reader.readLine();
                Scanner scanner = new Scanner(line);
                int N = scanner.nextInt();
                int M = scanner.nextInt();

                //System.out.println("N=" + N + ", M=" + M);

                int[][] lawn = new int[N][M];
                int[][] pattern = new int[N][M];

                for (int j = 0; j < N; j++) {
                    line = reader.readLine();
                    scanner = new Scanner(line);
                    for (int k = 0; k < M; k++) {
                        lawn[j][k] = 100;
                        pattern[j][k] = scanner.nextInt();
                    }
                }

                for (int j = 0; j < N; j++) {
                    int maxInt = getMaxInt(pattern[j]);
                    //System.out.println(maxInt);
                    for (int k = 0; k < M; k++) {
                        lawn[j][k] = maxInt;
                    }
                }

                String result = "YES";
                for (int k = 0; k < M; k++) {

                    if (!matchCol(lawn, pattern, k)) {
                        if (!isUniformCol(pattern, k)) {
                            result = "NO";
                            break;
                        }
                    }
                }

                output = "Case #" + (int) (i + 1) + ": " + result;
                //System.out.println(output);
                writer.write(output);
                writer.newLine();

            }
            writer.close();
        }


    }

    private static int getMaxInt(int[] i) {
        int maxInt = 0;
        for (int j = 0; j < i.length; j++) {
            if (i[j] > maxInt) {
                maxInt = i[j];
            }
        }
        return maxInt;
    }

    private static boolean matchCol(int[][] x, int[][] y, int k) {
        boolean result = true;
        for (int j = 0; j < x.length; j++) {
            if (x[j][k] != y[j][k]) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean isUniformCol(int[][] x, int k) {
        boolean result = true;
        
        if (x.length<=1) return true;
        for (int j = 1; j < x.length; j++) {
            if (x[j][k]!=x[0][k]) result=false;
        }
        
        return result;
    }
}
