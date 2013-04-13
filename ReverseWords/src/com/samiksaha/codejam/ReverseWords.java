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


/**
 *
 * @author Samik
 */
public class ReverseWords {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        String output;

        Path inputfile = Paths.get("B-large-practice.in");
        Path outputfile = Paths.get("B-large-practice.out");

        InputStream in = Files.newInputStream(inputfile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(outputfile, charset)) {
            String line = reader.readLine();
            Integer nTestCase = Integer.parseInt(line);
            for (int i = 0; i < nTestCase; i++) {
                line = reader.readLine();
                output = "Case #" + (int) (i + 1) + ":" + reverseWords(line);
                writer.write(output);
                writer.newLine();
            }
            writer.close();
        }
    }

    public static String reverseWords(String s) {
        String reverseString = "";

        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            reverseString = reverseString + " " + words[words.length - i - 1];
        }
        return reverseString;
    }
}
