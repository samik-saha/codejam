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
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Samik
 */
public class Treasure {

    private static void useKeys(HashMap keys) {
        
    }

    /**
     * @param args the command line arguments
     */
    static class Chest {

        int opensWith;
        Collection keys;
        boolean isOpen;
    }
    static Chest[] chests;
    static HashMap keys=new HashMap();
    

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
                int K = scanner.nextInt();
                int N = scanner.nextInt();
                
                line = reader.readLine();
                scanner = new Scanner(line);
                for (int j = 0; j < K; j++) {
                    int key=scanner.nextInt();
                    keys.put(j,key);
                }
                
                chests = new Chest[N];
                for (int j = 0; j < N; j++) {
                    line = reader.readLine();
                    scanner = new Scanner(line);
                    Chest c = new Chest();
                    c.opensWith = scanner.nextInt();
                    int nKeys = scanner.nextInt();
                    c.keys = new HashSet();
                    for (int k = 0; k < nKeys; k++) {
                        c.keys.add(scanner.nextInt());
                    }
                    chests[j]=c;
                }
                
                Set keySet = keys.keySet();
                Iterator iterator = keySet.iterator();
                while(iterator.hasNext()){
                    useKeys(keys);
                }


                output = "Case #" + (int) (i + 1) + ": ";
                //System.out.println(output);
                writer.write(output);
                writer.newLine();

            }

            writer.close();

        }

    }

    private static Collection OpenChest(Chest c) {
        Collection keys = new HashSet();
        

        return keys;
    }
}