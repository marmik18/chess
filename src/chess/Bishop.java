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
public class Bishop extends Piece {

    public Bishop(boolean white) {
        super(white, "Bishop");
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        boolean flag = false;

        if (x == y) {
            int startX, endX, startY, endY;
            startX = start.getX();
            endX = end.getX();
            startY = start.getY();
            endY = end.getY();
            try {
//              If Piece is going to north east 
                if (startX < endX && startY < endY) {
                    for (int i = startX + 1, j = startY + 1; i <= endX && j <= endY; i++, j++) {
                        if (board.getBox(i, j).getPiece() == null) {
                            flag = true;
                        } else if (board.getBox(i, j).getPiece() == end.getPiece() && i == endX) {
                            flag = true;
                        } else {
                            return false;
                        }
                    }
                } 
//              If Piece is going to south east
                else if (startX > endX && startY < endY) {

                    for (int i = startX - 1, j = startY + 1; i >= endX && j <= endY; i--, j++) {
                        if (board.getBox(i, j).getPiece() == null) {
                            flag = true;
                        } else if (board.getBox(i, j).getPiece() == end.getPiece() && i == endX) {
                            flag = true;
                        } else {
                            return false;
                        }
                    }

                } 
//              If Piece is going to south west
                else if (startX > endX && startY > endY) {

                    for (int i = startX - 1, j = startY - 1; i >= endX && j >= endY; i--, j--) {
                        if (board.getBox(i, j).getPiece() == null) {
                            flag = true;
                        } else if (board.getBox(i, j).getPiece() == end.getPiece() && i == endX) {
                            flag = true;
                        } else {
                            return false;
                        }
                    }

                } 
//               If Piece is going to north west 
                else if (startX < endX && startY > endY) {

                    for (int i = startX + 1, j = startY - 1; i <= endX && j >= endY; i++, j--) {
                        if (board.getBox(i, j).getPiece() == null) {
                            flag = true;
                        } else if (board.getBox(i, j).getPiece() == end.getPiece() && i == endX) {
                            flag = true;
                        } else {
                            return false;
                        }
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Queen.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return flag;
    }

}
