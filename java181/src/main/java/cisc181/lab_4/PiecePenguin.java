package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PiecePenguin Class
 */
public class PiecePenguin extends PieceEggLaying implements Attacker, Recruiter {

    private int numAttacked; //the number of pieces the piece attacked

    /**
     * constructor that has all parameters
     * @param symbol -- penguin's symbol
     * @param color -- penguin's color
     * @param numEggs -- number of eggs penguin has
     * @param numAttacked -- the number of pieces the penguin attacked
     */
    public PiecePenguin(String symbol, String color, int numEggs, int numAttacked){
        super(symbol, color, numEggs);
        this.numAttacked=numAttacked;
    }

    /**
     * constructor for when color information not available yet
     * and brand new piece that hasn’t laid eggs and hasn’t attacked
     * @param symbol -- penguin's symbol
     */
    public PiecePenguin(String symbol){
        super(symbol);
        numAttacked=0;
    }

    /**
     * accessor method for numAttacked
     * @return int -- the number of pieces the piece attacked
     */
    public int getNumAttacked()  {
        return this.numAttacked;
    }

    /**
     * Penguin's specific thing to say
     */
    public void speak(){
        System.out.println("Smile and wave boys. Smile and wave.");
    }

    /**
     * check whether the move from 1st location to second location is valid based on Penguin's
     * specific way to move
     * @param rowBefore -- current row index of the penguin on the board that is being moved
     * @param colBefore -- current column index of the penguin on the board that is being moved
     * @param rowAfter -- row index of the location the penguin will be moved to
     * @param colAfter -- column index of the location the penguin will be moved to
     * @return boolean -- whether or not the second location is a valid move based on first location
     */
    public boolean validPath(int rowBefore, int colBefore, int rowAfter, int colAfter) {
        if ((rowBefore==rowAfter) && (colAfter!=colBefore)) {
            //can move any number of spaces left or right but NOT up and down
            return true;
        } else if ((colBefore==colAfter) && (Math.abs(rowAfter-rowBefore)==1)) {
            //Can move one space up or one space down the board and not left or right
            return true;
        } else {
            return false;
        }
    }

    /**
     * mutator method of numAttacked. increases by one
     */
    public void incrementNumAttacked( ){
        this.numAttacked++;
    }

    /**
     * when a penguin attacks another piece
     * @param rowAttacker -- the row index of the attacker (this penguin)
     * @param colAttacker -- the column index of the attacker (this penguin)
     * @param rowAttackee -- the row index of the piece the attacker is attacking
     * @param colAttackee -- the column index of the piece the attacker is attacking
     */
    public void attack(int rowAttacker, int colAttacker, int rowAttackee, int colAttackee){
        incrementNumAttacked();
        speak();
        System.out.println("Attack with lasers – other piece removed from game.");
    }

    /**
     * when a penguin recruits another piece for their team
     * @param rowRecruiter -- the row index of the piece that is recruiting (this penguin)
     * @param colRecruiter -- the column index of the piece that is recruiting (this penguin)
     * @param rowRecruitee -- the row index of the piece the recruiter is recruiting
     * @param colRecruitee -- the column index of the piece the recruiter is recruiting
     */
    public void recruit(int rowRecruiter, int colRecruiter, int rowRecruitee, int colRecruitee){
        speak();
        System.out.println("You're on my team now! – other piece removed from other team and added to this team.");
    }

    /**
     * when the piece lays a penguin egg
     * @return PiecePenguin -- the new penguin the original penguin laid
     */
    public PiecePenguin layEgg(){
        // if this piece hasn't laid max eggs yet - allow it create new piece
        if( this.numEggs < MAX_EGGS){
            this.incrementNumEggs();
            // this creates a new piece that has not laid any eggs
            // and has not attacked any pieces yet it will belong to this team so pass in Color
            return new PiecePenguin(this.symbol, this.color,0,0);
        }
        else{
            return null;
        }
    }
}

