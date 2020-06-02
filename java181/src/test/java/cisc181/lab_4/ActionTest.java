package cisc181.lab_4;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ActionTest {

    private Game181H ourGame;
    private  Piece nemoA;
    private Piece blueHenA;
    private  Piece nemoB;
    private Piece blueHenB;

    private void createOurGame() {
        // Create 3 pieces for team A
        String colorTeamA = "Red";
        nemoA = new PieceSharkBait("Nemo", colorTeamA);
        blueHenA = new PieceBlueHen("Hen ", colorTeamA, 0, 0);
        //Piece penguinA = new PiecePenguin("Peng",colorTeamA,0,0);

        // Create an ArrayList of pieces for Team A
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        //piecesTeamA.add(penguinA);

        // Create 3 pieces for team B
        String colorTeamB = "Green";
        nemoB = new PieceSharkBait("Nemo", colorTeamB);
        blueHenB = new PieceBlueHen("Hen ", colorTeamB, 0, 0);
        //Piece penguinB = new PiecePenguin("Peng",colorTeamB,0,0);

        // Create an ArrayList of pieces for Team B
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        //piecesTeamB.add(penguinB);

        // Create Team A & B objects, set the team color and the pieces
        TeamH teamA = new TeamH("A", colorTeamA, piecesTeamA);
        TeamH teamB = new TeamH("B", colorTeamB, piecesTeamB);

        // Create a game object
        int numRows = 4;
        int numCols = 4;
        ourGame = new Game181H(numRows, numCols, teamA, teamB);

        // Print Board at start of game
        System.out.println(ourGame.getBoard().toString());
        // remove all the pieces and put in specific locations for testing purposes
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (!ourGame.getBoard().getSpaces()[i][j].isEmpty()) {
                    ourGame.getBoard().getSpaces()[i][j].removePiece();
                }
            }
        }
        ourGame.getBoard().getSpaces()[0][0].setPiece(nemoA);
        ourGame.getBoard().getSpaces()[0][3].setPiece(nemoB);
        ourGame.getBoard().getSpaces()[3][0].setPiece(blueHenA);
        ourGame.getBoard().getSpaces()[3][3].setPiece(blueHenB);
        System.out.println(ourGame.getBoard().toString());
    }

    @Test
    public void testActionMove() {
        System.out.println("Testing ActionMove");

        createOurGame();

        // Now that game is set up - lets test actions
        ActionMove move1 = new ActionMove(ourGame, 0, 1, 3, 3);
        assertFalse(move1.fromSpaceValid());   // invalid because no Piece on this space
        assertFalse(move1.toSpaceValid(true));  // invalid because space is not empty

        move1 = new ActionMove(ourGame, 0, 5, 9, 0);
        assertFalse(move1.fromSpaceValid());   // invalid because out of bounds
        assertFalse(move1.toSpaceValid(true));  // invalid because out of bounds

        move1 = new ActionMove(ourGame, 3, 0, 0, 1);
        assertTrue(move1.fromSpaceValid());   // valid because  Team A Piece on this space
        assertTrue(move1.toSpaceValid(true));  // valid because space is empty and inbounds
        assertTrue(move1.validActionPath());  // valid path for a PieceBlueHen
        assertTrue((move1.validAction()));  // valid because all of the conditions above are true

        ActionMove move2 = new ActionMove(ourGame, 0, 3, 2, 1);
        assertFalse(move2.fromSpaceValid());   // invalid because  Team B Piece on this space and its Team A's turn
        assertTrue(move2.toSpaceValid(true));  // valid because space is empty and inbounds
        assertTrue(move2.validActionPath());  // valid path for a PieceSharkBait
        assertFalse((move2.validAction()));  // invalid because at least one of the conditions above is false

        move2 = new ActionMove(ourGame, 0, 0, -2, -2);
        assertTrue(move2.fromSpaceValid());   // valid because  Team A Piece on this space
        assertFalse(move2.toSpaceValid(true));  // invalid because not in bounds
        assertTrue(move2.validActionPath());  // valid path for a PieceSharkBait
        assertFalse((move2.validAction()));  // invalid because at least one of the conditions above is false

        move2 = new ActionMove(ourGame, 3, 0, 0, 0);
        assertTrue(move2.fromSpaceValid());   // valid because  Team A Piece on this space
        assertFalse(move2.toSpaceValid(true));  // invalid because space is not empty
        assertTrue(move2.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((move2.validAction()));  // invalid because at least one of the conditions above is false

        move2 = new ActionMove(ourGame, 3, 0, 0, 3);
        assertTrue(move2.fromSpaceValid());   // valid because  Team A Piece on this space
        assertFalse(move2.toSpaceValid(true));  // invalid because space is not empty
        assertTrue(move2.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((move2.validAction()));  // invalid because at least one of the conditions above is false

        move2 = new ActionMove(ourGame, 0, 0, 2, 2);
        assertTrue(move2.fromSpaceValid());   // valid because  Team A Piece on this space
        assertTrue(move2.toSpaceValid(true));  // valid because space is empty and inbounds
        assertTrue(move2.validActionPath());  // valid path for a PieceSharkBait
        assertTrue((move2.validAction()));  // valid because all of the conditions above are true

        // when ready to test ActionAttack - comment this line until you are ready
        testActionAttack();
        // if not ready to test ActionRecruit - comment this line until you are ready
        testActionRecruit();
    }

    public void testActionAttack() {

        System.out.println("Testing ActionAttack");

        ourGame.getBoard().getSpaces()[0][0].setPiece(nemoA);
        ourGame.getBoard().getSpaces()[0][3].setPiece(nemoB);
        ourGame.getBoard().getSpaces()[2][1].setPiece(blueHenA);
        ourGame.getBoard().getSpaces()[2][2].setPiece(blueHenB);
        System.out.println(ourGame.getBoard().toString());

        // Testing ActionAttack
        ActionAttack attack1 = new ActionAttack(ourGame, 0, 1, 2, 3);
        assertFalse(attack1.fromSpaceValid());   // invalid because no Piece on this space
        assertFalse(attack1.toSpaceValid(false));  // invalid  space is  empty

        attack1 = new ActionAttack(ourGame, 0, 5, 9, 0);
        assertFalse(attack1.fromSpaceValid());   // invalid because out of bounds
        assertFalse(attack1.toSpaceValid(false));  // invalid because out of bounds

        attack1 = new ActionAttack(ourGame, 2, 1, 2, 2);
        assertTrue(attack1.fromSpaceValid());   // valid because  Team A Piece on this space
        assertTrue(attack1.toSpaceValid(false));  // valid because space has Team B's piece
        assertTrue(attack1.validActionPath());  // valid path for a PieceBlueHen
        assertTrue((attack1.validAction()));  // valid because all of the conditions above are true and PieceBlueHen can attack

        ActionAttack attack2 = new ActionAttack(ourGame, 2, 2, 0, 3);
        assertFalse(attack2.fromSpaceValid());   // invalid because  Team B Piece on this space and its Team A's turn
        assertTrue(attack2.toSpaceValid(false));  // valid because space has Team B's piece and its Team A's turn
        assertTrue(attack2.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((attack2.validAction()));  // invalid because one of the above is invalid

        attack2 = new ActionAttack(ourGame, 2, 1, 0, 0);
        assertTrue(attack2.fromSpaceValid());  // valid because  Team A Piece on this space
        assertFalse(attack2.toSpaceValid(false));  // invalid because space has Team A's piece and its Team A's turn
        assertTrue(attack2.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((attack2.validAction()));  // invalid because one of the above is invalid

        attack2 = new ActionAttack(ourGame, 0, 0, 2, 2);
        assertTrue(attack2.fromSpaceValid());   // valid because  Team A Piece on this space
        assertTrue(attack2.toSpaceValid(false));  // valid because space has Team B's piece and its Team A's turn
        assertTrue(attack2.validActionPath());  // valid path for a PieceSharkBait
        assertFalse((attack2.validAction()));  // invalid because PieceSharkBait can't attack
    }


    public void testActionRecruit() {

        System.out.println("Testing ActionRecruit");
        ourGame.getBoard().getSpaces()[0][0].setPiece(nemoA);
        ourGame.getBoard().getSpaces()[0][3].setPiece(nemoB);
        ourGame.getBoard().getSpaces()[2][1].setPiece(blueHenA);
        ourGame.getBoard().getSpaces()[2][2].setPiece(blueHenB);
        System.out.println(ourGame.getBoard().toString());

        // Testing ActionRecruit
        ActionRecruit recruit1 = new ActionRecruit(ourGame, 0, 1, 2, 3);
        assertFalse(recruit1.fromSpaceValid());   // invalid because no Piece on this space
        assertFalse(recruit1.toSpaceValid(false));  // invalid  space is  empty

        recruit1 = new ActionRecruit(ourGame, 0, 5, 9, 0);
        assertFalse(recruit1.fromSpaceValid());   // invalid because out of bounds
        assertFalse(recruit1.toSpaceValid(false));  // invalid because out of bounds

        recruit1 = new ActionRecruit(ourGame, 2, 1, 2, 2);
        assertTrue(recruit1.fromSpaceValid());   // valid because  Team A Piece on this space
        assertTrue(recruit1.toSpaceValid(false));  // valid because space has Team B's piece
        assertTrue(recruit1.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((recruit1.validAction()));  // invalid because PieceBlueHen can't recruit

        ActionRecruit recruit2 = new ActionRecruit(ourGame, 2, 2, 0, 3);
        assertFalse(recruit2.fromSpaceValid());   // invalid because  Team B Piece on this space and its Team A's turn
        assertTrue(recruit2.toSpaceValid(false));  // valid because space has Team B's piece and its Team A's turn
        assertTrue(recruit2.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((recruit2.validAction()));  // invalid because one of the above is invalid

        recruit2 = new ActionRecruit(ourGame, 2, 1, 0, 0);
        assertTrue(recruit2.fromSpaceValid());  // valid because  Team A Piece on this space
        assertFalse(recruit2.toSpaceValid(false));  // invalid because space has Team A's piece and its Team A's turn
        assertTrue(recruit2.validActionPath());  // valid path for a PieceBlueHen
        assertFalse((recruit2.validAction()));  // invalid because one of the above is invalid

        recruit2 = new ActionRecruit(ourGame, 0, 0, 2, 2);
        assertTrue(recruit2.fromSpaceValid());   // valid because  Team A Piece on this space
        assertTrue(recruit2.toSpaceValid(false));  // valid because space has Team B's piece and its Team A's turn
        assertTrue(recruit2.validActionPath());  // valid path for a PieceSharkBait
        assertTrue((recruit2.validAction()));  // valid because PieceSharkBait can recruit
    }



}