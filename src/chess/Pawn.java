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
public class Pawn extends Piece {

    boolean firstMove = true;

    public Pawn(boolean white) {
        super(white, "Pawn");
    }

    public boolean isFirstMove() {
        return firstMove;
    }

    public void setFirstMove() {
        this.firstMove = false;
    }

    @Override
    public boolean canMove(Board board, Box start, Box end) {
        if (end.getPiece() != null && end.getPiece().isWhite() == this.isWhite()) {
            return false;
        }

        int x = start.getX() - end.getX();
        int y = start.getY() - end.getY();

        if (!start.getPiece().isWhite()) {
            if (x == 2 && y == 0 && isFirstMove() && end.getPiece() == null) {
                return true;
            } else if (x == 1 && y == 0 && end.getPiece() == null) {
                return true;
            } else if ((x == 1 && y == 1 || x == 1 && y == -1) && end.getPiece() != null && end.getPiece().isWhite() != this.isWhite()) {
                return true;
            }
        } else {
            if (x == -2 && y == 0 && isFirstMove() && end.getPiece() == null) {
                return true;
            } else if (x == -1 && y == 0 && end.getPiece() == null) {
                return true;
            } else if ((x == -1 && y == -1 || x == -1 && y == 1) && end.getPiece() != null && end.getPiece().isWhite() != this.isWhite()) {
                return true;
            }
        }
        return false;
    }

}
