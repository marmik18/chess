/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marmi
 */
public class Queen extends Piece {

    public Queen(boolean white) {
        super(white);
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
//        check current and end piece color 
        if (end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        
        boolean flag = false;
        if (x == y) {

            int startX, endX, startY, endY;

//          Reversing if the order is negative
            if (start.getX() < end.getX()) {
                startX = end.getX();
                endX = start.getX();
            } else {
                startX = start.getX();
                endX = end.getX();
            }

//          Reversing if the order is negative
            if (start.getY() < end.getY()) {
                startY = end.getY();
                endY = start.getY();
            } else {
                startY = start.getY();
                endY = end.getY();
            }
            try{
                for (int i = startX, j = startY; i < endX && j < endY; i++, j++) {
                    if (board.getBox(i, j) == null) {
                        flag = true;    
                    } else{
                        return  false;
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Queen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return flag;
    }

}
