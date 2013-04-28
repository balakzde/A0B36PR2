/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zdenek
 */
public class Window extends JFrame {

    int whoseTurn;
    Playground p;
    Panel f;
    Player p1;
    Player p2;
    Menu m1;

    public Window() {
        super("Piškvorky");
        this.setSize(1000, 698);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        p = new Playground(30);
        f = new Panel(p);
        this.add(f, 0, 0);


        p1 = new Player("Míša", 700, 10, 300, 200);
        this.add(p1);
        p2 = new Player("Zdeněk", 700, 220, 300, 200);
        this.add(p2);
        m1 = new Menu(700, 430, 300, 200);
        this.add(m1);

        whoseTurn = 1;


    }

    public void restart() {
        p.playground = new Button[p.size][p.size];

        for (int i = 0; i < p.size; i++) {
            for (int j = 0; j < p.size; j++) {
                p.playground[i][j] = new Button();
            }
        }
        whoseTurn = 1;
        this.remove(f);
        f.removeAll();

        for (int i = 0; i < p.size; i++) {
            for (int j = 0; j < p.size; j++) {

                f.add(p.playground[i][j]);

            }
        }
        this.add(f);
        this.setVisible(false);
        this.setVisible(true);

    }

    public class Panel extends JPanel {

        public Panel(Playground p) {
            this.setSize(660, 660);
            this.setLayout(new GridLayout(p.size, p.size));

            for (int i = 0; i < p.size; i++) {
                for (int j = 0; j < p.size; j++) {

                    this.add(p.playground[i][j]);

                }
            }
        }
    }

    public class Player extends JPanel {

        JLabel name;
        JButton autoPlay;
        JLabel score;

        public Player(String name, int x, int y, int a, int b) {
            this.setLayout(null);
            this.setBounds(x, y, a, b);


            this.name = new JLabel();
            this.autoPlay = new JButton();
            this.score = new JLabel();

            this.name.setText(name + " score:");
            this.name.setBounds(10, 10, 200, 50);
            this.add(this.name);

            this.score.setText("0");
            this.score.setBounds(220, 10, 50, 50);
            this.add(score);

            this.autoPlay.setText(name + " autoplay");
            this.autoPlay.setBounds(10, 80, 250, 50);
            this.add(autoPlay);

        }
    }

    public class Menu extends JPanel {

        JButton newGame;
        JButton restart;
        JButton continue1;

        public Menu(int x, int y, int a, int b) {
            super();
            this.setLayout(null);
            this.setBounds(x, y, a, b);

            newGame = new JButton();
            newGame.setText("New Game");
            newGame.setBounds(10, 10, 115, 50);
            this.add(newGame);
            newGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    restart();
                    p1.score.setText("0");
                    p2.score.setText("0");
                }
            });

            restart = new JButton();
            restart.setText("Restart");
            restart.setBounds(145, 10, 120, 50);
            this.add(restart);
            restart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    restart();
                    p1.score.setText("0");
                    p2.score.setText("0");
                }
            });
            
            continue1 = new JButton();
            continue1.setText("Continue");
            continue1.setBounds(10, 80, 250, 50);
            this.add(continue1);
            continue1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    restart();

                }
            });

        }
    }

    public class Playground extends JButton {

        int size;
        Button[][] playground;

        public Playground(int size) {



            this.size = size;
            this.playground = new Button[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    playground[i][j] = new Button();
                }
            }

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
            follow = 0;
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
            follow = 0;

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


            // check if there are still options left
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size - 1; j++) {
                    if (!".".equals(playground[j][i].text)) {
                        follow++;
                    } else {
                        follow = 0;
                    }

                }
            }
            if (follow == size * size) {
                restart();

            }
        }

        public void win(int a) {
            int pom;


            if (whoseTurn == 1) {
                pom = (int) Double.parseDouble(p1.score.getText()) + 1;
                p1.score.setText(Integer.toString(pom));
            } else {
                pom = (int) Double.parseDouble(p2.score.getText()) + 1;
                p2.score.setText(Integer.toString(pom));
            }

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    playground[i][j].operable = false;
                }
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
            if (operable == true) {
                switch (whoseTurn) {

                    case (1):
                        this.text = "O";
                        Image myImage = getToolkit().createImage("O.jpg");
                        ImageIcon myIcon = new ImageIcon(myImage);
                        this.setIcon(myIcon);
                        operable = false;
                        p.winnerCheck(whoseTurn);
                        whoseTurn = 2;
                        break;

                    case (2):
                        this.text = "X";
                        Image myImage2 = getToolkit().createImage("X.jpg");
                        ImageIcon myIcon2 = new ImageIcon(myImage2);
                        this.setIcon(myIcon2);
                        operable = false;
                        p.winnerCheck(whoseTurn);
                        whoseTurn = 1;
                        break;

                }
            }
        }
    }
}
