package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PieceEggLaying Class
 */
public abstract class PieceEggLaying extends Piece {

    protected int numEggs; //the number of eggs the piece has
    final public static int MAX_EGGS = 2; //a constant for the maximum number of eggs can lay

    /**
     * constructor that has all parameters
     * @param symbol -- piece's symbol
     * @param color -- piece's color
     * @param numEggs -- number of eggs piece has
     */
    public PieceEggLaying(String symbol, String color, int numEggs) {
        super(symbol, color);
        this.numEggs=numEggs;
    }

    /**
     * constructor for when color information not available yet
     * and brand new piece that hasn’t laid eggs
     * @param symbol -- piece's symbol
     */
    public PieceEggLaying(String symbol){
        super(symbol);
        this.numEggs=0;
    }

    /**
     * accessor method for numEggs
     * @return int -- the number of eggs the piece has
     */
    public int getNumEggs()  {
        return this.numEggs;
    }

    /**
     * mutator method of numEggs. increases by one
     */
    public void incrementNumEggs( ){
        this.numEggs++;
    }

    /**
     * Abstract method for when the piece lays an egg (different for each subclass)
     * @return PieceEggLaying -- the new piece the original  piece laid
     */
    public abstract PieceEggLaying layEgg();
}
