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
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        Game game = new Game();
        game.initialize(p1, p2);
        game.getBoard().displayAll();
        System.out.println("*************************************************");
        game.playerMove(p1, 0, 1, 2, 0);
        game.getBoard().displayAll();
        System.out.println("*************************************************");
        game.playerMove(p2, 7, 3, 0, 2);
        game.getBoard().displayAll();
//        System.out.println("*************************************************");
//        game.playerMove(p1, 2, 0, 3, 2);
//        game.getBoard().displayAll();
//        System.out.println("*************************************************");
//        game.playerMove(p2, 7, 1, 5, 2);
//        game.getBoard().displayAll();
    }

}
