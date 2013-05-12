/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Zdenek
 */
public class Starter extends JFrame {

    JTextField name1;
    JTextField name2;
    JButton start;
    Window w;

    public Starter() {
        super("Piškvorky");
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 200);
        this.getContentPane().setBackground(Color.PINK);

        name1 = new JTextField();
        name1.setText("Player 1");
        name1.setBounds(35, 20, 100, 50);
        this.add(name1);

        name2 = new JTextField();
        name2.setText("Player 2");
        name2.setBounds(155, 20, 100, 50);
        this.add(name2);

        start = new JButton();
        start.setText("START");
        start.setBounds(90, 90, 100, 50);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    start();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Starter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        this.add(start);
    }

    public void start() throws InterruptedException {
        w = new Window(30, name1.getText(), name2.getText());
        w.setVisible(true);
        this.dispose();
        w.run();

    }
}
