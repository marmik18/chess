/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author marmik
 */
public abstract class Piece {
    boolean killed = false;
    boolean white = false;
    public String name;

    public Piece(boolean white, String name) {
        this.white = white;
        this.killed = false;
        if(this.isWhite()){
            this.name = name+"(w)";
        }else{
            this.name = name+"(b)";
        }
    }

    public boolean isKilled() {
        return killed; 
    }

    public void setKilled(boolean killed) {
        this.killed = killed;
    }

    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  
    
    public abstract boolean canMove(Board board, Box start, Box end);
}
