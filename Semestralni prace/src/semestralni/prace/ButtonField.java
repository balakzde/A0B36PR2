/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Zdenek
 */
public class ButtonField extends JPanel {

    private Button[][] field;
    private int a;
    Window w;

    public ButtonField(Window w) {
        this.w = w;
        this.a = w.g.getA();
        this.setBounds(0, 0, 660, 660);
        this.setLayout(new GridLayout(a, a));
        field = new Button[a][a];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                field[i][j] = new Button(i, j, "", w);
                this.add(field[i][j]);

            }
        }
    }

    public int getA() {
        return a;
    }

    void setField(Button[][] field) {
        this.field = field;
    }

    public Button[][] getField() {
        return field;
    }

    public void restart() {


        this.removeAll();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < a; j++) {
                field[i][j] = new Button(i, j, "", w);
                add(field[i][j]);
            }
        }
        this.setVisible(false);
        this.setVisible(true);
    }

    public void saveGame() throws IOException {
        char[][] charField = w.g.getField();
        try (FileWriter fw = new FileWriter("Piskvorky.balak")) {
            fw.write(a);
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    fw.write(charField[i][j]);
                }
            }
            fw.write(w.getWhoseTurn());
            fw.write((int) Double.parseDouble(w.m.score1.getText()));
            fw.write((int) Double.parseDouble(w.m.score2.getText()));
            fw.write(w.p1.getName());
            fw.write(0);
            fw.write(w.p2.getName());
            fw.write(0);

        }
    }
    /*
     * metoda Nacitani nacte udaje potrebne k navazani na rozehranou hru
     */

    public synchronized void loadGame() throws FileNotFoundException, IOException {
        int whoseTurn;
        try (FileReader fr = new FileReader("Piskvorky.balak")) {
            a = (int) fr.read();
            Button[][] buttonField = new Button[a][a];
            w.bf.removeAll();
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    buttonField[i][j] = new Button(i, j, "", w);
                    w.bf.add(buttonField[i][j]);

                }
            }

            char[][] charField = new char[a][a];
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    charField[i][j] = (char) fr.read();
                }
            }
            w.g.setField(charField);
            whoseTurn = (int) fr.read();
            w.setWhoseTurn(whoseTurn);
            int helper1 = (int) fr.read();
            int helper2 = (int) fr.read();

            String score1 = "";
            String score2 = "";
            score1 += helper1;
            score2 += helper2;
            w.m.score1.setText(score1);
            w.m.score2.setText(score2);


            String name1 = "";
            String name2 = "";
            while (true) {
                char pom = (char) fr.read();
                if (pom == 0) {
                    break;
                }
                name1 += pom;
            }
            while (true) {
                char pom = (char) fr.read();
                if (pom == 0) {
                    break;
                }
                name2 += pom;
            }

            w.p1.setName(name1);
            w.p2.setName(name2);

            w.m.name1.setText(name1 + " score : ");
            w.m.name2.setText(name2 + " score : ");
            w.m.autoplay1.setText(name1 + " autoplay");
            w.m.autoplay2.setText(name2 + " autoplay");



            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    if (charField[i][j] == 'O') {
                        Image myImage = getToolkit().createImage("O.jpg");
                        ImageIcon myIcon = new ImageIcon(myImage);
                        buttonField[i][j].setIcon(myIcon);
                    }

                    if (charField[i][j] == 'X') {
                        Image myImage = getToolkit().createImage("X.jpg");
                        ImageIcon myIcon = new ImageIcon(myImage);
                        buttonField[i][j].setIcon(myIcon);
                    }
                }
            }
            w.bf.setField(buttonField);
            w.setFilledWithAL(false);
            w.setVisible(false);
            w.setVisible(true);




        }
    }
}
