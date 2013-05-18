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

    public PCPlayer(String name, int number, Window w) {
        super(name, number, w);
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
        
        if(w.clicked){
        int helper;
        helper = w.g.doMove(w.x, w.y, w.getWhoseTurn());

        if (helper == 1) {
            Button[][]field = w.bf.getField();
            field[w.x][w.y].changeField();

        }  
        }

        
    }
   
}
