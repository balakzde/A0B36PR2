/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zdenek
 */
public class Menu extends JPanel {

    JButton autoplay1, autoplay2, newGame, restartGame, doContinue, saveGame, loadGame;
    JLabel name1, name2, score1, score2;
    Window w;

    public Menu(Window w, int x, int y, int a, int b, String name1, String name2) {
        this.setBounds(x, y, a, b);
        this.setLayout(null);
        this.setBackground(Color.pink);
        this.w = w;

        this.name1 = new JLabel();
        this.name1.setText(name1 + " score :");
        this.name1.setBounds(20, 50, 200, 50);
        this.name1.setForeground(Color.blue);
        this.add(this.name1);

        score1 = new JLabel();
        score1.setText("0");
        score1.setBounds(250, 50, 60, 50);
        this.add(score1);

        autoplay1 = new JButton();
        autoplay1.setText(name1 + " autoplay");
        autoplay1.setBounds(20, 110, 295, 50);
        this.add(autoplay1);
        autoplay1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                computer1();
            }
        });

        this.name2 = new JLabel();
        this.name2.setText(name2 + " score :");
        this.name2.setBounds(20, 200, 295, 50);

        this.add(this.name2);

        score2 = new JLabel();
        score2.setText("0");
        score2.setBounds(250, 200, 60, 50);
        this.add(score2);

        autoplay2 = new JButton();
        autoplay2.setText(name2 + " autoplay");
        autoplay2.setBounds(20, 260, 295, 50);
        this.add(autoplay2);
        autoplay2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                computer2();
            }
        });


        doContinue = new JButton();
        doContinue.setText("CONTINUE");
        doContinue.setBounds(20, 580, 295, 50);
        doContinue.setBackground(Color.green);
        this.add(doContinue);
        doContinue.setVisible(false);
        doContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    doContinue();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }


            }
        });

        newGame = new JButton();
        newGame.setText("New game");
        newGame.setBounds(20, 340, 295, 50);
        this.add(newGame);
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                newGame();
            }
        });


        restartGame = new JButton();
        restartGame.setText("Restart game");
        restartGame.setBounds(20, 400, 295, 50);
        this.add(restartGame);
        restartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                restartGame();
            }
        });

        saveGame = new JButton();
        saveGame.setText("Save game");
        saveGame.setBounds(20, 460, 295, 50);
        this.add(saveGame);
        saveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    save();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        loadGame = new JButton();
        loadGame.setText("Load game");
        loadGame.setBounds(20, 520, 295, 50);
        this.add(loadGame);
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    load();
                } catch (IOException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });




    }

    public void doContinue() throws InterruptedException {
        w.clicked = false;
        w.setGameStatus(0);
        w.g.restart();
        w.bf.restart();
        doContinue.setVisible(false);
        saveGame.setBackground(newGame.getBackground());
        loadGame.setBackground(newGame.getBackground());
        restartGame.setBackground(newGame.getBackground());
        w.setFilledWithAL(false);
        w.run();
    }

    public void save() throws IOException {
        if (w.getGameStatus() == 0) {
            w.bf.saveGame();
        }

    }

    public void load() throws FileNotFoundException, IOException {
        if (w.getGameStatus() == 0) {
            w.bf.loadGame();
        }
    }

    public void newGame() {
        Starter s = new Starter();
        s.setVisible(true);
        w.dispose();
    }

    public void restartGame() {
        if (w.getGameStatus() == 0) {
            w.clicked = false;

            w.bf.restart();
            w.setGameStatus(0);
            w.g.restart();
            score1.setText("0");
            score2.setText("0");
            w.setWhoseTurn(1);
            w.setFilledWithAL(false);

            w.run();

        }

    }

    public void computer1() {

        if (w.p1 instanceof PCPlayer) {
            w.p1 = new AI(w.p1.getName(), w.p1.getNumber(), w);
            autoplay1.setBackground(Color.yellow);
        } else {
            autoplay1.setBackground(newGame.getBackground());
            w.p1 = new PCPlayer(w.p1.getName(), w.p1.getNumber(), w);
        }


    }

    public void computer2() {
        if (w.p2 instanceof PCPlayer) {
            w.p2 = new AI(w.p2.getName(), w.p2.getNumber(), w);
            autoplay2.setBackground(Color.yellow);

        } else {
            w.p2 = new PCPlayer(w.p2.getName(), w.p2.getNumber(), w);
            autoplay2.setBackground(newGame.getBackground());

        }
    }
}
