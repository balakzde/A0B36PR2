/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Zdenek
 */
public class Playground extends JButton {

    int size, whoseTurn;
    Button[][] playground;

    public Playground(int size) {



        this.size = size;
        this.playground = new Button[size][size];

        for (int i = 0; i < size; i++) { 
            for (int j = 0; j < size; j++) {
                playground[i][j] = new Button();
            }
        }
        this.whoseTurn = 1;
    }

    public void winnerCheck(int whoseTurn) {
        int follow = 0;
        String symbol;
        Image myImage;
        ImageIcon myIcon;

        if (whoseTurn == 1) {
            myImage = getToolkit().createImage("O2.jpg");

            myIcon = new ImageIcon(myImage);
            symbol = "O";
        } else {
            myImage = getToolkit().createImage("X2.jpg");
            myIcon = new ImageIcon(myImage);
            symbol = "X";
        }


        // checks horizontal lines
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playground[i][j].text.equals(symbol)) {
                    follow++;
                } else {
                    follow = 0;
                }
                if (follow == 5) {
                    playground[i][j].setIcon(myIcon);
                    playground[i][j - 1].setIcon(myIcon);
                    playground[i][j - 2].setIcon(myIcon);
                    playground[i][j - 3].setIcon(myIcon);
                    playground[i][j - 4].setIcon(myIcon);

                    win(whoseTurn);
                }
            }
        }
        // check vertical lines
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (playground[j][i].text.equals(symbol)) {
                    follow++;
                } else {
                    follow = 0;
                }
                if (follow == 5) {
                    playground[j][i].setIcon(myIcon);
                    playground[j - 1][i].setIcon(myIcon);
                    playground[j - 2][i].setIcon(myIcon);
                    playground[j - 3][i].setIcon(myIcon);
                    playground[j - 4][i].setIcon(myIcon);
                    win(whoseTurn);

                }
            }
        }

        // checks diagonals
        for (int i = 2; i < size - 2; i++) {
            for (int j = 2; j < size - 2; j++) {
                if (playground[i][j].text.equals(playground[i + 1][j + 1].text) && playground[i][j].text.equals(playground[i + 2][j + 2].text) && playground[i][j].text.equals(playground[i - 1][j - 1].text) && playground[i][j].text.equals(playground[i - 2][j - 2].text) && playground[i][j].text.equals(symbol)) {
                    playground[i + 1][j + 1].setIcon(myIcon);
                    playground[i + 2][j + 2].setIcon(myIcon);
                    playground[i - 1][j - 1].setIcon(myIcon);
                    playground[i - 2][j - 2].setIcon(myIcon);
                    playground[i][j].setIcon(myIcon);

                    win(whoseTurn);

                }
                if (playground[i][j].text.equals(playground[i + 1][j - 1].text) && playground[i][j].text.equals(playground[i + 2][j - 2].text) && playground[i][j].text.equals(playground[i - 1][j + 1].text) && playground[i][j].text.equals(playground[i - 2][j + 2].text) && playground[i][j].text.equals(symbol)) {
                    playground[i + 1][j - 1].setIcon(myIcon);
                    playground[i + 2][j - 2].setIcon(myIcon);
                    playground[i - 1][j + 1].setIcon(myIcon);
                    playground[i - 2][j + 2].setIcon(myIcon);
                    playground[i][j].setIcon(myIcon);
                    win(whoseTurn);
                }
            }
        }


//        // check if there are still options left
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size - 1; j++) {
//                if (!".".equals(playground[j][i].text)) {
//                } else {
//                }
//            }
//        }
    }

    public void win(int a) {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                playground[i][j].operable = false;
            }
        }

    }

    public class Button extends JButton implements ActionListener {

        boolean operable;
        String text = "";

        public Button() {
            super();
            this.setText(text);
            this.operable = true;
            this.addActionListener(this);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            Font f1 = new Font("Monospaced ", Font.BOLD, 8);
            if (operable == true) {
                switch (whoseTurn) {

                    case (1):
                        this.text = "O";
                        Image myImage = getToolkit().createImage("O.jpg");
                        ImageIcon myIcon = new ImageIcon(myImage);
                        this.setIcon(myIcon);
                        operable = false;
                        winnerCheck(whoseTurn);
                        whoseTurn = 2;
                        break;

                    case (2):
                        this.text = "X";
                        Image myImage2 = getToolkit().createImage("X.jpg");
                        ImageIcon myIcon2 = new ImageIcon(myImage2);
                        this.setIcon(myIcon2);
                        operable = false;
                        winnerCheck(whoseTurn);
                        whoseTurn = 1;
                        break;

                }
            }
        }
    }
}