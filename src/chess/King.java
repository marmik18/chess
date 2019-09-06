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
public class King extends Piece {

    public King(boolean white) {
        super(white, "King");

    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        
        return x + y == 1 || x * y == 1;
    }

}
