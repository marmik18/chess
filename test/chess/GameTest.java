package chess;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marmi
 */
public class GameTest {

    Player p1;
    Player p2;
    Game instance;

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        p1 = new Player(true);
        p2 = new Player(false);
        instance = new Game(p1, p2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of isEnd method, of class Game.
     */
    @Test
    public void testIsEnd() {
        System.out.println("Verifying that the game has NOT ended");
        assertFalse(instance.isEnd());
        System.out.println("Verfied");
        instance.playerMove(p1, 1, 2, 2, 2);
        assertFalse(instance.isEnd());
        instance.playerMove(p2, 6, 3, 4, 3);
        assertFalse(instance.isEnd());
        instance.playerMove(p1, 0, 3, 3, 0);
        assertFalse(instance.isEnd());
        System.out.println("Performing moves to end the game");
        instance.playerMove(p2, 4, 3, 3, 3);
        assertFalse(instance.isEnd());
        System.out.println("Verfying that the game has ENDED");
        instance.playerMove(p1, 3, 0, 7, 4);
        assertTrue(instance.isEnd());
        System.out.println("Verfied");
        System.out.println("");
    }

    /**
     * Test of getStatus method, of class Game.
     */
    @Test
    public void testGetStatus() {
        System.out.println("Verifying Game Status");
        GameStatus expResult = GameStatus.ACTIVE;
        GameStatus result = instance.getStatus();
        assertEquals(expResult, result);
        System.out.println("Verified Game Status");
        System.out.println("");
    }

    /**
     * Test of playerMove method, of class Game.
     */
    @Test
    public void testPlayerMove() {
        System.out.println("Verifying PlayerMove");
        boolean expResultTrue = true;
        boolean expResultFalse = false;

//       Player 1 Moving Knight at 0 1 to 2 0 (north west)
        assertTrue(instance.playerMove(p1, 0, 1, 2, 0));

//        Player 1 trying to play again
        assertFalse(instance.playerMove(p1, 2, 0, 0, 1));

//        Player 2 tryring to move pawm 2 steps from 6 3 to 4 3 
        assertTrue(instance.playerMove(p2, 6, 3, 4, 3));

//        Player 1 tryring to move pawm diagonally steps from 1 1 to 2 2       
        assertFalse(instance.playerMove(p1, 1, 1, 2, 2));
        
        System.out.println("Verified PlayerMove");
        System.out.println("");
    }

    /**
     * Test of getCurrentTurn method, of class Game.
     */
    @Test
    public void testGetCurrentTurn() {
        System.out.println("Verifying Verfying P1's Turn");
        assertEquals(p1, instance.getCurrentTurn());
        System.out.println("Verifying getCurrentTurn after P1 plays his turn");
        instance.playerMove(p1, 1, 3, 3, 3);
        assertEquals(p2, instance.getCurrentTurn());
        System.out.println("Verfying P2's Turn");
        System.out.println("");
    }

    /**
     * Test of testKnightMovement method, of class Game.
     */
    @Test
    public void testKnightMovement() throws Exception {
        System.out.println("Verifying All Knight Movements");
        Knight testKnight = (Knight) instance.getBoard().getBox(0, 1).getPiece();

//        Invalid Move but on null location
        assertFalse(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(2, 1)));

//        Invalid Moves on ally location        
        assertFalse(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(1, 1)));
        assertFalse(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(1, 0)));
        assertFalse(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(0, 0)));

//        Valid move on Ally spot        
        assertFalse(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(1, 3)));

//      Valid movements after the board has initailized  
        assertTrue(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(2, 2)));
        assertTrue(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(0, 1), instance.getBoard().getBox(2, 0)));
//        Kills move on pawn when the knight is on 4 2
        assertTrue(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(6, 1)));
        assertTrue(testKnight.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(6, 3)));
        System.out.println("Knight Movements Verified");
        System.out.println("");
    }

    /**
     * Test of testRookMovement method, of class Game.
     */
    @Test
    public void testRookMovement() throws Exception {
        System.out.println("Verifying All Rook Movements");
        Rook testRook = (Rook) instance.getBoard().getBox(0, 0).getPiece();

//        Invalid Move but on null location
        assertFalse(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(2, 0)));

//        Invalid Moves
        assertFalse(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(1, 1)));
        assertFalse(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(1, 0)));
//        Same Location
        assertFalse(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(0, 0)));

//        When the Pawn in the way of the move  
        assertFalse(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(2, 0)));
//        Removing Pawn from the way
        instance.playerMove(p1, 1, 0, 3, 0);
//      Valid movements after the board has initailized  
        assertTrue(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(2, 0)));
        assertTrue(testRook.canMove(instance.getBoard(), instance.getBoard().getBox(2, 0), instance.getBoard().getBox(2, 2)));
        System.out.println("Verified Rook Movements");
        System.out.println("");
    }

    /**
     * Test of getCurrentTurn method, of class Game.
     */
    @Test
    public void testBishopMovement() throws Exception {
        System.out.println("Verifying All Bishop Movements");
        Bishop testBishop = (Bishop) instance.getBoard().getBox(0, 2).getPiece();

//        Invalid move passing over a pawn
        assertFalse(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(0, 2), instance.getBoard().getBox(2, 0)));

//        Invalid Moves
        assertFalse(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(2, 1)));
//        Same Location
        assertFalse(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(0, 2), instance.getBoard().getBox(0, 2)));

//        When the Pawn in the way of the move  
        assertFalse(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(0, 0), instance.getBoard().getBox(2, 0)));
        assertFalse(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(3, 5), instance.getBoard().getBox(7, 1)));

//        Removing Pawn from the way
        instance.playerMove(p1, 1, 1, 3, 1);
//      Valid movements after the board has initailized  
        assertTrue(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(0, 2), instance.getBoard().getBox(2, 0)));
        assertTrue(testBishop.canMove(instance.getBoard(), instance.getBoard().getBox(2, 4), instance.getBoard().getBox(6, 0)));
        System.out.println("Verified Bishop Movements");
        System.out.println("");
    }

    /**
     * Test of getCurrentTurn method, of class Game.
     */
    @Test
    public void testQueenMovement() throws Exception {
        System.out.println("Verifying All Queen Movements");
        Queen testQueen = (Queen) instance.getBoard().getBox(0, 3).getPiece();

//        All 8 valid movements on all side
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(5, 2)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(5, 3)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(4, 3)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(3, 3)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(3, 2)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(3, 1)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(4, 1)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(5, 1)));

//        Invalid move passing over a pawn
        assertFalse(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(0, 3), instance.getBoard().getBox(2, 3)));
        assertFalse(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(7, 2)));

//        Invalid Moves
        assertFalse(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(3, 4)));
        assertFalse(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(4, 2), instance.getBoard().getBox(5, 4)));

//        Same Location
        assertFalse(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(0, 3), instance.getBoard().getBox(0, 3)));

//        Removing Pawn from the way
        instance.playerMove(p1, 1, 3, 3, 3);
//      Valid movements after Pawn move
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(0, 3), instance.getBoard().getBox(1, 3)));
        assertTrue(testQueen.canMove(instance.getBoard(), instance.getBoard().getBox(0, 3), instance.getBoard().getBox(2, 3)));
        System.out.println("Verified Queen Movements");
        System.out.println("");
    }
    
        /**
     * Test of getCurrentTurn method, of class Game.
     */
    @Test
    public void testPawmMovement() throws Exception {
        System.out.println("Verifying All Pawn Movements");
        Pawn testPawn = (Pawn) instance.getBoard().getBox(1, 2).getPiece();

//        All 2 valid movements before First move
        assertTrue(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(1, 2), instance.getBoard().getBox(3, 2)));
        assertTrue(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(1, 2), instance.getBoard().getBox(2, 2)));

//        Testing 2 steps after the first move
        instance.playerMove(p1, 1, 2, 3, 2);
        assertFalse(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(5, 2)));

//        Testing blocked by other piece       
        instance.playerMove(p2, 6, 2, 4, 2);
        assertFalse(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(4, 2)));

        instance.playerMove(p1, 1, 4, 3, 4);
        instance.playerMove(p2, 6, 3, 4, 3);
        instance.playerMove(p1, 1, 3, 3, 3);
//        Killing only on the diagonal only
        assertTrue(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(4, 3)));
        

//        Invalid Moves
        assertFalse(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(1, 2)));
        assertFalse(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(2, 1)));
        assertFalse(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(2, 2)));

//        Same Location
        assertFalse(testPawn.canMove(instance.getBoard(), instance.getBoard().getBox(3, 2), instance.getBoard().getBox(3, 2)));

        System.out.println("Verified Pawn Movements");
        System.out.println("");
    }
}
    


