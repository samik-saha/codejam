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
public class StoreCredit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        int credit;
        int nItems;
        int[] items;
        int total;
        String output;

        Path inputfile = Paths.get("A-large-practice.in");
        Path outputfile = Paths.get("A-large-practice.out");

        InputStream in = Files.newInputStream(inputfile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(outputfile, charset)) {
            String line = reader.readLine();
            Integer nTestCase = Integer.parseInt(line);
            for (int i = 0; i < nTestCase; i++) {
                line = reader.readLine();
                credit = Integer.parseInt(line);

                line = reader.readLine();
                nItems = Integer.parseInt(line);

                items = new int[nItems];
                line = reader.readLine();
                Scanner scanner = new Scanner(line);
                for (int j = 0; j < items.length; j++) {
                    items[j] = scanner.nextInt();
                }

                for (int k = 0; k < items.length; k++) {
                    for (int l = k + 1; l < items.length; l++) {
                        total = items[k] + items[l];

                        if (credit == total) {
                            output = "Case #" + (int)(i + 1) + ": " + (int)(k+1) + " " + (int)(l+1);
                            writer.write(output);
                            writer.newLine();
                        }
                    }
                }
            }
            writer.close();
        }
         

    }
}
