/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Zdenek
 */
public class Playground {

    private int size;
    private char[][] playground;

    public Playground(int size) {

        if (size < 0) {
            size = -size;
        }
        if (size >= 0 && size < 10) {
            size = 10;
        }
        if (size > 50) {
            size = 50;
        }


        this.size = size;
        this.playground = new char[size][size];

        for (int i = 0; i < size; i++) { //fill the field with dots
            for (int j = 0; j < size; j++) {
                playground[i][j] = ('.');
            }
        }
    }
    
    
    
}
