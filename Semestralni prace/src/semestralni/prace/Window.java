/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Zdenek
 */
public class Window extends JFrame {


    Playground p;
    Panel f;

    public Window() {
        super("Piškvorky");
        this.setSize(1000, 698);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        p = new Playground(30);
        f = new Panel(p);
        this.add(f, 0, 0);
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
}
