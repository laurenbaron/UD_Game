package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Piece Class
 */
public abstract class Piece {

    protected String symbol; // represents what kind of piece it is
    protected String color; // represents what color the piece is
    protected boolean hidden; // represents whether this piece is visible or hidden

    /**
     * Constructor with all parameters
     * @param symbol -- what piece it is
     * @param color -- what color the piece is
     */
    public Piece(String symbol, String color) {
        this.symbol=symbol;
        this.color=color;
        this.hidden=false;
    }

    /**
     * constructor for when color information is not available yet
     * @param symbol -- what piece it is
     */
    public Piece(String symbol){
        this(symbol,"");
    }

    /**
     * accessor method for symbol
     * @return String -- the symbol of the piece
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * accessor method for color
     * @return String -- the color of the piece
     */
    public String getColor(){
        return color;
    }

    /**
     * accessor method for hidden
     * @return boolean -- whether the piece is hidden or not
     */
    public boolean isHidden() {
        return hidden;
    }

    /**
     * mutator method for color
     * @param color -- the new color to set color to
     */
    public void setColor(String color){
        this.color = color;
    }

    /**
     * mutator method for hidden
     * @param hidden -- the new hidden value to set hidden to
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * abstract method of what Piece says when speak (different for each subclass)
     */
    public abstract void speak();

    /**
     * abstract method of if the Piece's move is valid (different for each subclass)
     * @param rowBefore -- current row index of the piece on the board that is being moved
     * @param colBefore -- current column index of the piece on the board that is being moved
     * @param rowAfter -- row index of the location the piece will be moved to
     * @param colAfter -- column index of the location the piece will be moved to
     * @return boolean -- whether or not the second location is a valid move based on first location
     */
    public abstract boolean validPath(int rowBefore, int colBefore, int rowAfter, int colAfter);

    /**
     * the first letter of the Piece’s color followed by a dash followed by the Piece’s symbol
     * @return String -- string representation of the piece
     */
    @Override
    public String toString(){
        return color.charAt(0) + "-" + symbol;
    }
}
