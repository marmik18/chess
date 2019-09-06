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

    boolean whiteSide = false;

    public Player(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }    
    
    
    public boolean isWhiteSide() {
        return whiteSide;
    }

    public void setwhiteSide(boolean whiteSide) {
        this.whiteSide = whiteSide;
    }

}
