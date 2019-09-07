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

        movesPlayed.clear();
    }

    public boolean isEnd() {
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
            System.out.println("Source Item is null");
            return false;
        }

        if (player != currentTurn) {
            System.out.println("Wrong players turn");
            return false;
        }

        if (sourcePiece.isWhite() != player.isWhiteSide()) {
            System.out.println("Invalid Piece Picked by the Player");
            return false;
        }

        if (!sourcePiece.canMove(board, move.getStart(),
                move.getEnd())) {
            System.out.println("Invalid move for the piece");
            return false;
        }

        Piece destPiece = move.getStart().getPiece();
        if (destPiece != null) {
            destPiece.setKilled(true);
            move.setPieceKilled(destPiece);
        }

        movesPlayed.add(move);

        move.getEnd().setPiece(move.getStart().getPiece());
        move.getStart().setPiece(null);

        if (destPiece != null && destPiece instanceof King) {
            if (player.isWhiteSide()) {
                this.setStatus(GameStatus.WHITE_WIN);
            } else {
                this.setStatus(GameStatus.BLACK_WIN);
            }
        }

        if (this.currentTurn == players[0]) {
            this.currentTurn = players[1];
        } else {
            this.currentTurn = players[0];
        }

        return true;
    }

    public Board getBoard() {
        return board;
    }

}
