/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marmi
 */
public class Game {

    private final Player[] players = new Player[2];
    private Board board;
    private Player currentTurn;
    private GameStatus status;
    private final List<Move> movesPlayed;

    public Game() {
        movesPlayed = new ArrayList<>();
    }

    void initialize(Player p1, Player p2) {
        players[0] = p1;
        players[1] = p2;

        board = new Board();
        if (p1.isWhiteSide()) {
            this.currentTurn = p1;
        } else {
            this.currentTurn = p2;
        }
        
        setStatus(GameStatus.ACTIVE);
        movesPlayed.clear();
        
    }

    public boolean isEnd() {
        System.out.println(this.getStatus() != GameStatus.ACTIVE);
        return this.getStatus() != GameStatus.ACTIVE;
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public boolean playerMove(Player player, int startX, int startY, int endX, int endY) throws Exception {
        Box startBox = board.getBox(startX, startY);
        Box endBox = board.getBox(endX, endY);
        Move move = new Move(player, startBox, endBox);
        return this.makeMove(move, player);
    }

    private boolean makeMove(Move move, Player player) {

        Piece sourcePiece = move.getStart().getPiece();
        if (sourcePiece == null) {
            System.err.println("Source Item is null");
            return false;
        }

        if (player != currentTurn) {
            System.err.println("Wrong players turn");
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            System.err.println("Invalid Piece Color Picked by the Player");
            return false;
        }

        if (!sourcePiece.canMove(board, move.getStart(),
                move.getEnd())) {
            System.err.println("Invalid move for the piece");
            return false;
        }

        Piece destPiece = move.getEnd().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
            System.err.println(move.getStart().getPiece().getName()+" killed "+ destPiece.getName());
        }

        movesPlayed.add(move);
        if (move.getStart().getPiece() instanceof Pawn){
            ((Pawn)move.getStart().getPiece()).setFirstMove();
        }
        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece != null && destPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
                System.err.println("White Team Wins");
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
                System.err.println("Black Team Wins");
            }
        }

        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }

        return true;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public Board getBoard() {
        return board;
    }

}
