/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess;

import java.util.Scanner;

/**
 *
 * @author marmi
 */
public class Chess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Player p1 = new Player(true);
        Player p2 = new Player(false);
        Game game = new Game();
        game.initialize(p1, p2);
        while (game.getStatus() == GameStatus.ACTIVE) {
            System.out.println("*****************************************************************************************************************************");
            game.getBoard().displayAll();
            System.out.println("*****************************************************************************************************************************");
            if (game.getCurrentTurn() == p1) {
                System.out.println("Player 1's Turn (White)");
                int startX = sc.nextInt();
                int startY = sc.nextInt();
                int endX = sc.nextInt();
                int endY = sc.nextInt();
                game.playerMove(p1, startX, startY, endX, endY);
            } else {
                System.out.println("Player 2's Turn (Black)");
                int startX = sc.nextInt();
                int startY = sc.nextInt();
                int endX = sc.nextInt();
                int endY = sc.nextInt();
                game.playerMove(p2, startX, startY, endX, endY);
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

}
