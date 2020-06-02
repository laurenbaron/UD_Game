package cisc181.lab_4;

import java.lang.reflect.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class GamePieceTests {
    @Test
    public void test_Piece() {
        // Piece has a constructor
        // but we should not be able to create a Piece
        System.out.println("Testing Piece Class");
        try {
            Class<Piece> clazz = Piece.class;
            Constructor<Piece> ctor = clazz.getDeclaredConstructor(String.class, String.class);
            try {
                ctor.newInstance("BHen", "Red");
                fail("Should not be able to create an instance of Piece");
            } catch (Exception e) {
                // should happen
            }

            // speak should not be implemented in the Piece class
            Method m = clazz.getDeclaredMethod("speak", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertTrue(Modifier.isAbstract(m.getModifiers()));

            // validPath should not be implemented in the Piece class
            m = clazz.getDeclaredMethod("validPath", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertTrue(Modifier.isAbstract(m.getModifiers()));
        } catch (Exception e) {
            // not supposed to happen
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void test_PieceEggLaying() {
        // PieceEggLaying has a constructor
        // but we should not be able to create a Piece
        System.out.println("Testing PieceEggLaying Class");
        try {
            Class<PieceEggLaying> clazz = PieceEggLaying.class;
            Constructor<PieceEggLaying> ctor = clazz.getDeclaredConstructor(String.class, String.class, int.class);
            try {
                ctor.newInstance("BHen", "Red", 0);
                fail("Should not be able to create an instance of Piece");
            } catch (Exception e) {
                // should happen
            }

            // layEgg should not be implemented
            Method m = clazz.getDeclaredMethod("layEgg", new Class[]{});
            assertEquals(PieceEggLaying.class, m.getReturnType());
            assertTrue(Modifier.isAbstract(m.getModifiers()));

            // getNumEggs should be implemented
            m = clazz.getDeclaredMethod("getNumEggs", new Class[]{});
            assertEquals(int.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // incrementNumEggs should be implemented
            m = clazz.getDeclaredMethod("incrementNumEggs", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

        } catch (Exception e) {
            // not supposed to happen
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void test_SharkBait() {
        System.out.println("Testing SharkBait Class");
        PieceSharkBait nemo = new PieceSharkBait("Nemo", "Blue");
        assertTrue(nemo instanceof Piece);

        try {
            // speak should be implemented
            Method m = PieceSharkBait.class.getMethod("speak", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // validPath should be implemented
            m = PieceSharkBait.class.getMethod("validPath", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

        } catch (Exception e) {
            // not supposed to happen
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void test_Penguin() {
        System.out.println("Testing Penguin Class");
        PiecePenguin skipper = new PiecePenguin("Peng", "Blue", 10, 2);
        assertTrue(skipper instanceof Piece);
        assertTrue(skipper instanceof PieceEggLaying);

        try {
            // speak should be implemented
            Method m = PiecePenguin.class.getMethod("speak", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // validPath should be implemented
            m = PiecePenguin.class.getMethod("validPath", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // layEgg should not be implemented
            m = PiecePenguin.class.getDeclaredMethod("layEgg", new Class[]{});
            assertEquals(PiecePenguin.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));


            // getNumAttacked should be implemented
            m = PiecePenguin.class.getDeclaredMethod("getNumAttacked", new Class[]{});
            assertEquals(int.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));


            // incrementNumAttacked should be implemented
            m = PiecePenguin.class.getDeclaredMethod("incrementNumAttacked", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

        } catch (Exception e) {
            // not supposed to happen
            e.printStackTrace();
            fail(e.getMessage());
        }
    }

    @Test
    public void test_BlueHen() {
        System.out.println("Testing Blue Hen Class");
        PiecePenguin youdee = new PiecePenguin("BHen", "Blue", 5, 2);
        assertTrue(youdee instanceof Piece);
        assertTrue(youdee instanceof PieceEggLaying);

        try {
            // speak should be implemented
            Method m = PieceBlueHen.class.getMethod("speak", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // validPath should be implemented
            m = PieceBlueHen.class.getMethod("validPath", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // layEgg should not be implemented
            m = PieceBlueHen.class.getDeclaredMethod("layEgg", new Class[]{});
            assertEquals(PieceBlueHen.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // getNumAttacked should be implemented
            m = PieceBlueHen.class.getDeclaredMethod("getNumAttacked", new Class[]{});
            assertEquals(int.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

            // incrementNumAttacked should be implemented
            m = PieceBlueHen.class.getDeclaredMethod("incrementNumAttacked", new Class[]{});
            assertEquals(void.class, m.getReturnType());
            assertFalse(Modifier.isAbstract(m.getModifiers()));

        } catch (Exception e) {
            // not supposed to happen
            e.printStackTrace();
            fail(e.getMessage());
        }
    }
}
