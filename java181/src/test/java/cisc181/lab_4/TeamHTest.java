package cisc181.lab_4;

import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class TeamHTest {
    @Test
    public void getTeamName() throws Exception {

        System.out.println("Testing Team class");
        Piece nemoA = new PieceSharkBait("Nemo","Red");
        Piece blueHenA = new PieceBlueHen("Hen ","Red",0,0);
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        piecesTeamA.add(nemoA);
        piecesTeamA.add(blueHenA);

        Piece nemoB = new PieceSharkBait("Nemo","Green");
        Piece penguinB = new PiecePenguin("Peng","Green",0,0);
        ArrayList<Piece> piecesTeamB = new ArrayList<>();
        piecesTeamB.add(nemoB);
        piecesTeamB.add(penguinB);

        TeamH teamA = new TeamH("CISC", "Red",piecesTeamA);
        TeamH teamB = new TeamH("181",  "Green",piecesTeamB);

        // check teamA
        assertEquals("CISC",teamA.getTeamName());
        assertEquals("Red",teamA.getTeamColor());
        assertEquals(2,teamA.getTeamPieces().size());
        assertTrue(teamA.getTeamPieces().contains(nemoA));
        assertTrue(teamA.getTeamPieces().contains(blueHenA));
        assertFalse(teamA.getTeamPieces().contains(nemoB));
        assertFalse(teamA.getTeamPieces().contains(penguinB));

        // check teamB
        assertEquals("181",teamB.getTeamName());
        assertEquals("Green",teamB.getTeamColor());
        assertEquals(2,teamB.getTeamPieces().size());
        assertTrue(teamB.getTeamPieces().contains(nemoB));
        assertTrue(teamB.getTeamPieces().contains(penguinB));
        assertFalse(teamB.getTeamPieces().contains(nemoA));
        assertFalse(teamB.getTeamPieces().contains(blueHenA));

        // remove a Piece from teamA and put on Team B
        teamA.removePieceFromTeam(nemoA);
        teamB.addPieceToTeam(nemoA);
        // check team B pieces
        assertEquals(3,teamB.getTeamPieces().size());
        assertTrue(teamB.getTeamPieces().contains(nemoA));
        assertTrue(teamB.getTeamPieces().contains(nemoB));
        assertTrue(teamB.getTeamPieces().contains(penguinB));
        assertFalse(teamB.getTeamPieces().contains(blueHenA));
        //check that nemoA color was changed
        assertEquals(teamB.getTeamColor(),nemoA.getColor());

        // check team A pieces
        assertEquals(1,teamA.getTeamPieces().size());
        assertTrue(teamA.getTeamPieces().contains(blueHenA));
        assertFalse(teamA.getTeamPieces().contains(nemoA));
        assertFalse(teamA.getTeamPieces().contains(nemoB));
        assertFalse(teamA.getTeamPieces().contains(penguinB));

        // should have no tools
        System.out.println("\n" + teamA.toString());
        System.out.println("\n" + teamB.toString());

        //check toolbox - should each have one tool
        teamA.getToolBox().addTool(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
        assertTrue(teamA.getToolBox().hasTool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
        assertFalse(teamA.getToolBox().hasTool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
        System.out.println("\n" + teamA.toString());

        teamB.getToolBox().addTool(new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
        assertTrue(teamB.getToolBox().hasTool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
        assertFalse(teamB.getToolBox().hasTool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
        System.out.println("\n" + teamB.toString());

        // remove a tool that the toolbox does not have
        assertEquals(null,teamB.getToolBox().removeTool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));

        // remove a tool that the toolbox does have
        // teamB should have no tools again
       Tool t1 =  teamB.getToolBox().removeTool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER);
       assertEquals(Tool.ITEM.CLOAK, t1.getToolType());
       assertEquals(Tool.STRENGTH.SILVER, t1.getToolStrength());
       assertFalse(teamB.getToolBox().hasTool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
       System.out.println("\n" + teamB.toString());
    }
}