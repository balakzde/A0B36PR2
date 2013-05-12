/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Zdenek
 */
public class Button extends JButton implements ActionListener {

    private int i;
    private int j;
    Window w;

    public Button(int i, int j, String text, Window w) {
        super();
        this.i = i;
        this.j = j;
        this.w = w;
        this.setText(text);
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int helper;
        helper = w.g.doMove(i, j, w.getWhoseTurn());

        if (helper == 1) {
            changeField();
        }
    }

    public void changeField() {
        Button[][] helper2;
        helper2 = w.bf.getField();
        Image myImage;
        ImageIcon myIcon;

        if (w.getWhoseTurn() == 1) {
            myImage = getToolkit().createImage("O.jpg");
        } else {
            myImage = getToolkit().createImage("X.jpg");
        }

        myIcon = new ImageIcon(myImage);
        this.setIcon(myIcon);
        w.setGameStatus(w.g.winnerCheck(w.getWhoseTurn()));

        for (int k = 0; k < w.g.getA(); k++) {
            for (int l = 0; l < w.g.getA(); l++) {
                helper2[k][l].removeActionListener(helper2[k][l]);
            }
        }
        w.bf.setField(helper2);
        w.switchPlayer();
        w.setFilledWithAL(false);

    }
}
