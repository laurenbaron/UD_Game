package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PieceBookWorm Class
 */
public class PieceBookWorm extends PieceEggLaying implements Recruiter {
    public PieceBookWorm(String symbol, String color, int numEggs){
        super(symbol, color, numEggs);
    }

    /**
     * constructor for when color information is not available yet
     * @param symbol -- the BookWorm's symbol
     */
    public PieceBookWorm(String symbol){
        this(symbol,"",0);
    }
   /**
     *
    * The bookworm is able to move two spaces in any direction, including diagonal. This method
    * checks if its path is valid.
     * @param rowBefore -- current row index of the bookworm on the board that is being moved
     * @param colBefore -- current column index of the bookworm on the board that is being moved
     * @param rowAfter -- row index of the location the bookworm will be moved to
     * @param colAfter -- column index of the location the bookworm will be moved to
     * @return boolean -- whether or not the second location is a valid move based on first location
     */
    public boolean validPath(int rowBefore, int colBefore, int rowAfter, int colAfter) {
        //can move two spaces in any direction or two spaces diagonally in any direction
        return ( ((rowAfter==rowBefore+2) && (colAfter==colBefore+2)) ||
                ((rowAfter==rowBefore-2) && (colAfter==colBefore-2)) ||
                ((rowAfter==rowBefore-2) && (colAfter==colBefore+2)) ||
                ((rowAfter==rowBefore+2) && (colAfter==colBefore-2)) ||
                (Math.abs(rowAfter - rowBefore) == 2) || (Math.abs(colAfter - colBefore) == 2));
    }
    /**
     * when a bookworm attacks another piece
     * @param rowAttacker -- the row index of the attacker (this bookworm)
     * @param colAttacker -- the column index of the attacker (this bookworm)
     * @param rowAttackee -- the row index of the piece the attacker is attacking
     * @param colAttackee -- the column index of the piece the attacker is attacking
     */
    public void recruit(int rowAttacker, int colAttacker, int rowAttackee, int colAttackee){
        speak();
        System.out.println("Attacks with books and the power of knowledge – other piece removed from game.");
    }
    public void speak(){ System.out.println("Club Morris for the win!");}

    /**
     * Gives the bookworm piece the ability to lay an egg
     * @return PieceBookWorm (new piece)
     */
    public PieceBookWorm layEgg(){
        // if this piece hasn't laid max eggs yet - adllow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBookWorm(this.symbol,this.color,this.numEggs);
        }
        else{
            return null;
        }
    }
}
