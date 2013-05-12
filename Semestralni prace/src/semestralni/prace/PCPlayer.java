/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Zdenek
 */
public class PCPlayer extends Player {

    String name;
    int number;
    Window w;

    public PCPlayer(String name, int number, Window w) {
        this.name = name;
        this.number = number;
        this.w = w;
    }

    @Override
    int getNumber() {
        return number;
    }

    @Override
    void makeMove() {
        if (!w.isFilledWithAL()) {
            Button[][] helper = w.bf.getField();
            int a = w.bf.getA();


            for (int i = 0; i < a; i++) {
                for (int j = 0; j < a; j++) {
                    helper[i][j].addActionListener(helper[i][j]);
                }
            }
            w.bf.setField(helper);
            w.setFilledWithAL(true);
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
