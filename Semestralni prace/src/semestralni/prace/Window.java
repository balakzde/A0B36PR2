/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Color;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Zdenek
 */
public class Window extends JFrame {
    
    boolean clicked = false;
    int x;
    int y;
    Game g;
    ButtonField bf;
    Player p1;
    Player p2;
    private int whoseTurn = 1;
    private int gameStatus = 0;
    Menu m;
    private boolean filledWithAL = false;
    //Starter s;

    public Window(int a, String name1, String name2) {
        super("Piškvorky");
        this.setSize(1000, 688);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setBackground(Color.pink);
        g = new Game(a);
        bf = new ButtonField(this);
        this.add(bf);
        p1 = new PCPlayer(name1, 1, this);
        p2 = new PCPlayer(name2, 2, this);
        m = new Menu(this, 660, 0, 340, 688, name1, name2);
        this.add(m);
        this.setBackground(Color.pink);
        //this.s = s;



    }

    public void setFilledWithAL(boolean filledWithAL) {
        this.filledWithAL = filledWithAL;
    }

    public boolean isFilledWithAL() {
        return filledWithAL;
    }

    public int getWhoseTurn() {
        return whoseTurn;
    }

    public void setWhoseTurn(int whoseTurn) {
        this.whoseTurn = whoseTurn;

    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public int getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void switchPlayer() {
        if (whoseTurn == 1) {
            setWhoseTurn(2);
            m.name1.setForeground(Color.black);
            m.name2.setForeground(Color.blue);
        } else {
            setWhoseTurn(1);
            m.name1.setForeground(Color.blue);
            m.name2.setForeground(Color.black);
        }
    }

    public void win() {
        Button[][] helper = bf.getField();
        char[][] helper2 = g.getField();
        Image myImage;
        ImageIcon myIcon;
        int helper3;

        if (gameStatus == 3) {
            m.doContinue.setVisible(true);
            return;
        }
        if (gameStatus == 1) {
            myImage = getToolkit().createImage("O2.jpg");
            helper3 = (int) Double.parseDouble(m.score1.getText());
            helper3++;
            m.score1.setText(Integer.toString(helper3));
        } else {
            myImage = getToolkit().createImage("X2.jpg");
            helper3 = (int) Double.parseDouble(m.score2.getText());
            helper3++;
            m.score2.setText(Integer.toString(helper3));

        }
        myIcon = new ImageIcon(myImage);



        for (int k = 0; k < g.getA(); k++) {
            for (int l = 0; l < g.getA(); l++) {
                helper[k][l].removeActionListener(helper[k][l]);
            }
        }
        bf.setField(helper);
        setFilledWithAL(false);

        for (int k = 0; k < g.getA(); k++) {
            for (int l = 0; l < g.getA(); l++) {
                if (helper2[k][l] == 'w') {
                    helper[k][l].setIcon(myIcon);
                }
            }
        }
        m.saveGame.setBackground(Color.red);
        m.loadGame.setBackground(Color.red);
        m.doContinue.setVisible(true);
    }

    public void run() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (gameStatus == 0) {
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if (getGameStatus() != 0) {
                        break;
                    }
                    if (whoseTurn == 1) {
                        p1.makeMove();

                    } else {
                        p2.makeMove();
                    }

                }
                win();
            }
        };
        thread.setDaemon(true);
        thread.start();
    }
}
