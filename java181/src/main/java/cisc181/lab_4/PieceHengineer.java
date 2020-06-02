package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PieceHengineer Class
 */
public class PieceHengineer extends Piece implements Attacker{

    public PieceHengineer(String symbol, String color){
        super(symbol, color);
    }
    /**
     * constructor for when color information is not available yet
     * @param symbol -- the Hengineer's symbol
     */
    public PieceHengineer(String symbol){
        this(symbol, "");
    }
    /**
     * Checks whether the Hengineer is taking a valid path. Because the hengineer is able
     * to move anywhere on the board, this will always return true.
     * @param rowBefore -- current row index of the hengineer on the board that is being moved
     * @param colBefore -- current column index of the hengineer on the board that is being moved
     * @param rowAfter -- row index of the location the hengineer will be moved to
     * @param colAfter -- column index of the location the hengineer will be moved to
     * @return boolean -- whether or not the second location is a valid move based on first location
     */
    public boolean validPath(int rowBefore, int colBefore, int rowAfter, int colAfter){
        return true;
    }
    /**
     * when a blue hen attacks another piece
     * @param rowAttacker -- the row index of the attacker (this hengineer)
     * @param colAttacker -- the column index of the attacker (this hengineer)
     * @param rowAttackee -- the row index of the piece the attacker is attacking
     * @param colAttackee -- the column index of the piece the attacker is attacking
     */
    public void attack(int rowAttacker, int colAttacker, int rowAttackee, int colAttackee){
        speak();
        System.out.println("Attacks with logical debate – other piece removed from game.");
    }
    public void speak(){ System.out.println("Comp Sci rules!");}
    }
