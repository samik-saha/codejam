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
public class TicTacToeTomek {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        char[][] board = new char[4][4];
        boolean emptyCell = false;

        String output;

        Path inputfile = Paths.get("A-large.in");
        Path outputfile = Paths.get("A-large.out");

        InputStream in = Files.newInputStream(inputfile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(outputfile, charset)) {
            String line = reader.readLine();
            Integer nTestCase = Integer.parseInt(line);
            for (int i = 0; i < nTestCase; i++) {
                String status = "";
                emptyCell = false;

                for (int j = 0; j < 4; j++) {
                    line = reader.readLine();
                    board[j] = line.toCharArray();

                    if (line.replace('T', 'X').equals("XXXX")) {
                        status = "X won";
                    } else if (line.replace('T', 'O').equals("OOOO")) {
                        status = "O won";
                    }

                    if (line.contains(".")) {
                        emptyCell = true;
                    }

                }

                if (status.equals("")) {
                    for (int j = 0; j < 4; j++) {

                        char[] col = new char[]{board[0][j], board[1][j], board[2][j], board[3][j]};

                        String colStr = new String(col);
                        if (colStr.replace('T', 'X').equals("XXXX")) {
                            status = "X won";
                            break;
                        } else if (colStr.replace('T', 'O').equals("OOOO")) {
                            status = "O won";
                            break;
                        }
                    }

                }



                if (status.equals("")) {
                    char[] dia = new char[4];
                    dia[0] = board[0][0];
                    dia[1] = board[1][1];
                    dia[2] = board[2][2];
                    dia[3] = board[3][3];
                    String diaStr = new String(dia);
                    if (diaStr.replace('T', 'X').equals("XXXX")) {
                        status = "X won";

                    } else if (diaStr.replace('T', 'O').equals("OOOO")) {
                        status = "O won";

                    }

                    dia[0] = board[0][3];
                    dia[1] = board[1][2];
                    dia[2] = board[2][1];
                    dia[3] = board[3][0];
                    diaStr = new String(dia);
                    if (diaStr.replace('T', 'X').equals("XXXX")) {
                        status = "X won";

                    } else if (diaStr.replace('T', 'O').equals("OOOO")) {
                        status = "O won";

                    }
                }

                if (status.equals("")) {
                    if (emptyCell == false) {
                        status = "Draw";
                    } else {
                        status = "Game has not completed";
                    }
                }



                output = "Case #" + (int) (i + 1) + ": " + status;
                writer.write(output);
                writer.newLine();

                reader.readLine();
            }
            writer.close();
        }


    }
}
