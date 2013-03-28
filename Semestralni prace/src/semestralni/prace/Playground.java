/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Zdenek
 */
public class Playground {

    private int size;
    private char[][] playground;

    public Playground(int size) {

        if (size < 0) {
            size = -size;
        }
        if (size >= 0 && size < 10) {
            size = 10;
        }
        if (size > 50) {
            size = 50;
        }


        this.size = size;
        this.playground = new char[size][size];

        for (int i = 0; i < size; i++) { //fill the field with dots
            for (int j = 0; j < size; j++) {
                playground[i][j] = ('.');
            }
        }
    }

    public int winnerCheck(int whoseTurn) {
        int follow = 0;
        char symbol;
        if (whoseTurn == 1) {
            symbol = 'O';
        } else {
            symbol = 'X';
        }


        // checks horizontal lines
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (playground[i][j] == symbol) {
                    follow++;
                } else {
                    follow = 0;
                }
                if (follow == 5) {
                    return whoseTurn;
                }
            }
        }
        // check vertical lines
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (playground[j][i] == symbol) {
                    follow++;
                } else {
                    follow = 0;
                }
                if (follow == 5) {
                    return whoseTurn;
                }
            }
        }

        // checks diagonals
        for (int i = 2; i < size - 2; i++) {
            for (int j = 2; j < size - 2; j++) {
                if (playground[i][j] == playground[i + 1][j + 1] && playground[i][j] == playground[i + 2][j + 2] && playground[i][j] == playground[i - 1][j - 1] && playground[i][j] == playground[i - 2][j - 2] && playground[i][j] == symbol) {
                    return whoseTurn;
                }
                if (playground[i][j] == playground[i + 1][j - 1] && playground[i][j] == playground[i + 2][j - 2] && playground[i][j] == playground[i - 1][j + 1] && playground[i][j] == playground[i - 2][j + 2] && playground[i][j] == symbol) {
                    return whoseTurn;
                }
            }
        }


        // check if there are still options left
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (playground[j][i] != '.') {
                    follow++;
                } else {
                    return 0;
                }
            }
        }
        return 3;
    }

    public void saveGame(int whoseTurn) throws IOException {
        try (FileWriter fw = new FileWriter("Piskvorky.txt")) {
            fw.write(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    fw.write(playground[i][j]);
                }
            }
            fw.write(whoseTurn);
        }
    }

    public int loadGame() throws FileNotFoundException, IOException {
        int whoseTurn;
        try (FileReader fr = new FileReader("Piskvorky.txt")) {
            size = (int) fr.read();
            playground = new char[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    playground[i][j] = (char) fr.read();
                }
            }
            whoseTurn = (int) fr.read();
        }

        return whoseTurn;
    }
}
