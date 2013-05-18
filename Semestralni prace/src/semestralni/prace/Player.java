/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

/**
 *
 * @author Zdenek
 */
public abstract class Player {
    
    String name;
    int number;
    Window w;
    
        public Player(String name, int number, Window w) {
        this.name = name;
        this.number = number;
        this.w = w;
    }
        
            int getNumber() {
        return number;
    }
            
    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void makeMove();

    
  
}
