package cisc181.lab_4;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTests {

    public static String boardString(int numRows, int numColumns){
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :     ");

        for(int col = 0; col < numColumns; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for(int row = 0; row < numRows; row++){
            boardString.append("Row : " + row + "   ");
            for(int col = 0; col < numColumns; col++){
                boardString.append("------" + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    @Test
    public void testingBoard() throws Exception {
        System.out.println("Testing Board Class");

        int numRows = 6;
        int numCols = 10;
        Board testBoard = new Board(numRows,numCols);
        // print the board all spaces should be empty
        System.out.println(testBoard.toString());
        assertEquals(boardString(numRows,numCols),testBoard.toString());

        assertEquals(numRows,testBoard.getNumRows());
        assertEquals(numCols,testBoard.getNumColumns());

        assertTrue(testBoard.inBounds(0,0));
        assertTrue(testBoard.inBounds(numRows-1, numCols-1));
        assertFalse(testBoard.inBounds(numRows, numCols));
        assertFalse(testBoard.inBounds(-1,-1));

        // place some pieces on the board
        Piece nemo = new PieceSharkBait("nemo","Blue");
        testBoard.getSpaces()[3][6].setPiece(nemo);
        Piece skipper = new PiecePenguin("peng","Green",1,5);
        testBoard.getSpaces()[numRows-1][numCols-1].setPiece(skipper);
        Piece youdee = new PieceBlueHen("bhen","Blue",3,9);
        testBoard.getSpaces()[2][1].setPiece(youdee);
        System.out.println(testBoard.toString());

        // testing random empty space method
        BoardSpace emptySpace = testBoard.findRandomEmptySpace();
        assertTrue(emptySpace.isEmpty());
        assertNull(emptySpace.getPiece());
        Piece dory = new PieceSharkBait("dory","Green");
        emptySpace.setPiece(dory);
        System.out.println(testBoard.toString());
    }

}
