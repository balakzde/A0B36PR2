/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.GridLayout;
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
//        this.setSize(660, 660);
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
    
    public void restart(){
        
        
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
}
