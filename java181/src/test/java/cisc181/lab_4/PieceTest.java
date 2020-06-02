package cisc181.lab_4;

import static org.junit.Assert.*;
import org.junit.Test;

public class PieceTest {
    @Test
    public void validPath() throws Exception {
        System.out.println("Testing  Blue Hen validPath");
        PieceBlueHen bh = new PieceBlueHen("BH","Red",0,1);
        // this piece can fly so should be able to go anywhere on board
        assertTrue(bh.validPath(35,1,5,67));
        assertTrue(bh.validPath(5,1,10,0));
        assertTrue(bh.validPath(8,1,4,20));

        bh = new PieceBlueHen("BH","Red",10,1);
        // this piece can't fly so should only be able to go one space left, or right or up or down
        assertTrue(bh.validPath(35,1,34,1));
        assertTrue(bh.validPath(5,10,6,10));
        assertTrue(bh.validPath(34,1,34,2));
        assertTrue(bh.validPath(5,10,5,9));
        assertFalse(bh.validPath(35,1,33,1));
        assertFalse(bh.validPath(5,10,7,10));
        assertFalse(bh.validPath(34,1,33,2));
        assertFalse(bh.validPath(6,20,7,10));

        System.out.println("Testing Penguin validPath");
        PiecePenguin penguin = new PiecePenguin("P","Red",0,1);
        // this piece can move left or right any number of spaces but not up or down
        assertTrue(penguin.validPath(15,1,15,67));
        assertTrue(penguin.validPath(4,1,4,0));
        assertTrue(penguin.validPath(8,16,8,10));
        assertFalse(penguin.validPath(15,1,16,56));
        assertFalse(penguin.validPath(5,10,6,0));
        assertFalse(penguin.validPath(7,10,6,0));

        // this piece can move up one or down one but not left or right
        assertTrue(penguin.validPath(35,2,34,2));
        assertTrue(penguin.validPath(5,9,6,9));
        assertFalse(penguin.validPath(35,1,33,1));
        assertFalse(penguin.validPath(5,10,7,10));
        assertFalse(penguin.validPath(34,1,33,2));
        assertFalse(penguin.validPath(6,20,7,10));

        System.out.println("Testing SharkBait validPath");
        PieceSharkBait nemo = new PieceSharkBait("N","Red");
        // this piece can move left or right any number of spaces but not up or down
        assertTrue(nemo.validPath(15,1,13,3));
        assertTrue(nemo.validPath(4,11,6,13));
        assertTrue(nemo.validPath(8,16,6,14));
        assertTrue(nemo.validPath(6,12,8,10));
        assertFalse(nemo.validPath(15,1,16,2));
        assertFalse(nemo.validPath(5,10,6,0));
        assertFalse(nemo.validPath(7,10,6,0));

        // add more test cases if you want to test more thoroughly

    }
}