/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

/**
 *
 * @author marmi
 */
public class Player {

    boolean white = false;

    public Player(boolean white) {
//        set the player to white or black
        this.white = white;
    }    
    
    
    public boolean isWhite() {
        return white;
    }

    public void setWhite(boolean white) {
        this.white = white;
    }

}
