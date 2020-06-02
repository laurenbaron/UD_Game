package cisc181.lab_4;

import static org.junit.Assert.*;
import org.junit.Test;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class GameHTest {
    @Test
    public void gameTests() throws Exception {

        System.out.println("Testing Game");

        // Create 3 pieces for team A
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        Piece penguinA = new PiecePenguin("Peng","Red",0,0);

        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);
        piecesTeamA.add(penguinA);

        // Create 3 pieces for team B
        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece blueHenB = new PieceBlueHen("Hen ","Green",0,0);
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);

        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(blueHenB);
        piecesTeamB.add(penguinB);

        TeamH teamA = new TeamH("UD", "Red",piecesTeamA);
        TeamH teamB = new TeamH("PJ",  "Green",piecesTeamB);

        Game181H ourGame = new Game181H(4, 4,teamA, teamB);
        System.out.println(ourGame.toString());
    }
}