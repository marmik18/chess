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
public class Board {

    Box[][] boxses = new Box[8][8];

    public Board() {
        initBoard();
    }

    void initBoard() {
//      Init White Pieces
        boxses[0][0] = new Box(0, 0, new Rook(true));
        boxses[0][1] = new Box(0, 1, new Knight(true));
        boxses[0][2] = new Box(0, 2, new Bishop(true));
        boxses[0][3] = new Box(0, 3, new Queen(true));
        boxses[0][4] = new Box(0, 4, new King(true));
        boxses[0][5] = new Box(0, 5, new Bishop(true));
        boxses[0][6] = new Box(0, 6, new Knight(true));
        boxses[0][7] = new Box(0, 7, new Rook(true));
//      Init White Pawns
        boxses[1][0] = new Box(1, 0, new Pawn(true));
        boxses[1][1] = new Box(1, 1, new Pawn(true));
        boxses[1][2] = new Box(1, 2, new Pawn(true));
        boxses[1][3] = new Box(1, 3, new Pawn(true));
        boxses[1][4] = new Box(1, 4, new Pawn(true));
        boxses[1][5] = new Box(1, 5, new Pawn(true));
        boxses[1][6] = new Box(1, 6, new Pawn(true));
        boxses[1][7] = new Box(1, 7, new Pawn(true));
        
//      Init Blank Spaces
        for (int i = 2; i < 6; i++) {
            for (int j = 0; j < 8; j++) {
                boxses[i][j] = new Box(i, j, null);
            }
        }

//      Init Black Pieces
        boxses[7][0] = new Box(7, 0, new Rook(false));
        boxses[7][1] = new Box(7, 1, new Knight(false));
        boxses[7][2] = new Box(7, 2, new Bishop(false));
        boxses[7][3] = new Box(7, 3, new Queen(false));
        boxses[7][4] = new Box(7, 4, new King(false));
        boxses[7][5] = new Box(7, 5, new Bishop(false));
        boxses[7][6] = new Box(7, 6, new Knight(false));
        boxses[7][7] = new Box(7, 7, new Rook(false));
//      Init White Pawns
        boxses[6][0] = new Box(6, 0, new Pawn(false));
        boxses[6][1] = new Box(6, 1, new Pawn(false));
        boxses[6][2] = new Box(6, 2, new Pawn(false));
        boxses[6][3] = new Box(6, 3, new Pawn(false));
        boxses[6][4] = new Box(6, 4, new Pawn(false));
        boxses[6][5] = new Box(6, 5, new Pawn(false));
        boxses[6][6] = new Box(6, 6, new Pawn(false));
        boxses[6][7] = new Box(6, 7, new Pawn(false));


    }

    public Box getBox(int x, int y) throws Exception {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            throw new Exception("Index out of bound");
        }
        return boxses[x][y];
    }

    public void displayAll() {
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                System.out.print(i + "," + j + ": " );
                if(boxses[i][j].getPiece() != null ){
                    System.out.print(boxses[i][j].getPiece().getName()+"\t");
                }else{
                    System.out.print("*\t\t");
                }
            }
            System.out.println("");
        }
    }
}
