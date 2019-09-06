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
    private boolean killed = false;
    private boolean white = false;

    public Piece(boolean white) {
        this.white = white;
        this.killed = false;
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
  
    
    public abstract boolean canMove(Board board, Box start, Box end);
}
