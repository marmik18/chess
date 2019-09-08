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
public class Rook extends Piece {

    public Rook(boolean white) {
        super(white, "Rook");
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }
        
        int x = Math.abs(start.getX() - end.getX());
        int y = Math.abs(start.getY() - end.getY());
        boolean flag = false;
        
        if ((x == 0 && y != 0) || (y == 0 && x != y)) {
            int startX, endX, startY, endY;
            startX = start.getX();
            endX = end.getX();
            startY = start.getY();
            endY = end.getY();

            if (x == 0 && y != 0) {
//              If the Piece moves west
                if (startY > endY) {
                    try {
                        for (int i = startY - 1; i >= endY; i--) {
                            if (board.getBox(startX, i).getPiece() == null) {
                                flag = true;
                            } else if (board.getBox(startX, i).getPiece() == end.getPiece() && i == endY) {
                                flag = true;
                            } else {
                                return false;
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Queen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } //                If the piece moves east
                else {
                    try {
                        for (int i = startY + 1; i <= endY; i++) {
                            if (board.getBox(startX, i).getPiece() == null) {
                                flag = true;
                            } else if (board.getBox(startX, i).getPiece() == end.getPiece() && i == endY) {
                                flag = true;
                            } else {
                                return false;
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Queen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            } else if (y == 0 && x != 0) {
//              If the Piece moves south
                if (startX > endX) {
                    try {
                        for (int i = startX - 1; i >= endX; i--) {
                            if (board.getBox(i, startY).getPiece() == null) {
                                flag = true;
                            } else if (board.getBox(i, startY).getPiece() == end.getPiece() && i == endX) {
                                flag = true;
                            } else {
                                return false;
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Queen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        for (int i = startX + 1; i <= endX; i++) {
                            if (board.getBox(i, startY).getPiece() == null) {
                                flag = true;
                            } else if (board.getBox(i, startY).getPiece() == end.getPiece() && i == endX) {
                                flag = true;
                            } else {
                                return false;
                            }
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(Queen.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return flag;
    }

}
