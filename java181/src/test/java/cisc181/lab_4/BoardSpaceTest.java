package cisc181.lab_4;

import org.junit.Test;
import static org.junit.Assert.*;
public class BoardSpaceTest {

    @Test
    public void testingBoardSpace() throws Exception {
        System.out.println("Testing Board Space Class");

        BoardSpace testSpace = new BoardSpace(1,2,"Black");
        BoardSpace testSpace2 = new BoardSpace(5,10,"White");

        //getRow
        assertEquals(1,testSpace.getRow());
        assertEquals(5,testSpace2.getRow());

        //getColumn
        assertEquals(2,testSpace.getColumn());
        assertEquals(10,testSpace2.getColumn());

        // getColor
        assertEquals("Black",testSpace.getSpaceColor());
        assertEquals("White",testSpace2.getSpaceColor());

        // isEmpty
        assertTrue(testSpace.isEmpty());
        assertTrue(testSpace2.isEmpty());

        //toString
        assertEquals(("------"),testSpace.toString());
        assertEquals(("------"),testSpace2.toString());

        //getPiece - none
        assertNull(testSpace.getPiece());
        assertNull(testSpace2.getPiece());

        //setPiece
        Piece nemo = new PieceSharkBait("nemo","Orange");
        testSpace.setPiece(nemo);
        Piece skipper = new PiecePenguin("peng","Green",5,3);
        testSpace2.setPiece(skipper);

        //toString
        assertEquals(("O-nemo"),testSpace.toString());
        assertEquals(("G-peng"),testSpace2.toString());

        //getPiece - returns Piece but doesn't remove it from space
        assertSame(nemo,testSpace.getPiece());
        assertSame(skipper,testSpace2.getPiece());

        //isEmpty
        assertFalse(testSpace.isEmpty());
        assertFalse(testSpace2.isEmpty());

        //toString
        assertEquals(("O-nemo"),testSpace.toString());
        assertEquals(("G-peng"),testSpace2.toString());

        // removePiece - returns Piece and removes it from space
        assertSame(nemo,testSpace.removePiece());
        assertSame(skipper,testSpace2.removePiece());

        //isEmpty
        assertTrue(testSpace.isEmpty());
        assertTrue(testSpace2.isEmpty());

        //toString
        assertEquals(("------"),testSpace.toString());
        assertEquals(("------"),testSpace2.toString());
    }
}