package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PieceBlueHen Class
 */
public class PieceBlueHen extends PieceEggLaying implements Attacker {

    private int numAttacked; //the number of pieces the piece attacked
    private boolean fly; //whether or not the blue hen can fly

    /**
     * constructor that has all parameters
     * @param symbol -- blue hen's symbol
     * @param color -- blue hen's color
     * @param numEggs -- number of eggs blue hen has
     * @param numAttacked -- the number of pieces the blue hen attacked
     */
    public PieceBlueHen(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        this.numAttacked=numAttacked;
        updateFly();
    }

    /**
     * constructor for when color information not available yet
     * and brand new piece that hasn’t laid eggs and hasn’t attacked
     * @param symbol -- blue hen's symbol
     */
    public PieceBlueHen(String symbol){
        super(symbol);
        numAttacked=0;
    }

    /**
     * Blue hen's specific thing to say
     */
    public void speak(){
        System.out.println("Go UD!");
    }

    /**
     * accessor method for fly
     * @return boolean -- whether or not blue hen can fly
     */
    public boolean canFly ()  {
        return this.fly;
    }

    /**
     * accessor method for numAttacked
     * @return int -- the number of pieces the piece attacked
     */
    public int getNumAttacked()  {
        return this.numAttacked;
    }

    /**
     * mutator method of numEggs. increases by one and makes sure to update after
     */
    public void incrementNumEggs( ){
        super.incrementNumEggs();
        updateFly();
    }

    /**
     * mutator method for numAttacked. increase by one and make sure to update after
     */
    public void incrementNumAttacked( ){
        this.numAttacked++;
        updateFly();
    }

    /**
     * check whether the move from 1st location to second location is valid based on Blue hen's
     * specific way to move
     * @param rowBefore -- current row index of the blue hen on the board that is being moved
     * @param colBefore -- current column index of the blue hen on the board that is being moved
     * @param rowAfter -- row index of the location the blue hen will be moved to
     * @param colAfter -- column index of the location the blue hen will be moved to
     * @return boolean -- whether or not the second location is a valid move based on first location
     */
    public boolean validPath(int rowBefore, int colBefore, int rowAfter, int colAfter){
        if(canFly()) {
            //if can fly, can move anywhere
            return true;
        } else {
            //if can't fly, can move one space left or right or up or down
            if( ((rowAfter==rowBefore+1) && (colAfter==colBefore)) ||
                    ((rowAfter==rowBefore-1) && (colAfter==colBefore)) ||
                    ((colAfter==colBefore+1) && (rowAfter==rowBefore)) ||
                    ((colAfter==colBefore-1) && (rowAfter==rowBefore)) ) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * when a blue hen attacks another piece
     * @param rowAttacker -- the row index of the attacker (this blue hen)
     * @param colAttacker -- the column index of the attacker (this blue hen)
     * @param rowAttackee -- the row index of the piece the attacker is attacking
     * @param colAttackee -- the column index of the piece the attacker is attacking
     */
    public void attack(int rowAttacker, int colAttacker, int rowAttackee, int colAttackee){
        incrementNumAttacked();
        speak();
        System.out.println("Attacks with claws – other piece removed from game.");
    }

    /**
     * when the piece lays a blue hen egg
     * @return PieceBlueHen -- the new blue hen the original blue hen laid
     */
    public PieceBlueHen layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // creates a new piece that has the same number of eggs laid and attacked pieces
            // as this piece
            return new PieceBlueHen(this.symbol,this.color,this.numEggs,this.numAttacked);
        }
        else{
            return null;
        }
    }

    private void updateFly( ) {
        if (this.numEggs < MAX_EGGS) {
            this.fly = true;
        } else if (this.numAttacked == 0) {
            this.fly = true;
        } else {
            this.fly = false;
        }
    }
}

