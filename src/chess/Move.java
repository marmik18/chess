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
public class Move { 
    private Player player; 
    private Box start; 
    private Box end; 
    private Piece pieceMoved; 
    private Piece pieceKilled; 
  
    public Move(Player player, Box start, Box end) 
    { 
        this.player = player; 
        this.start = start; 
        this.end = end; 
        this.pieceMoved = start.getPiece(); 
    } 
}