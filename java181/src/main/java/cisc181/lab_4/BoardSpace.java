package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * BoardSpace Class
 */
public class BoardSpace {

    private int row; // the row on the board the space is in
    private int column; // the column on the board the space is in
    private String color; //the color of the space
    private boolean empty; //whether or not the space is empty
    private Piece pieceOnSpace; //the piece on the space

    /**
     * constructor with all parameters
     * @param row -- the space's row
     * @param column -- the space's column
     * @param color -- the space's color
     */
    public BoardSpace (int row, int column, String color) {
        this.row=row;
        this.column=column;
        this.color=color;
        //the space initially does not have a piece on it so is empty
        empty=true;
        pieceOnSpace=null;
    }

    /**
     * accessor for row
     * @return int -- the space's row
     */
    public int getRow() {
        return row;
    }

    /**
     * accessor for column
     * @return int -- the space's column
     */
    public int getColumn() {
        return column;
    }

    /**
     * accessor for pieceOnSpace
     * @return Piece -- the boardgame piece on the space
     */
    public Piece getPiece() {
        return pieceOnSpace;
    }

    /**
     * accessor for color
     * @return String -- the space's color
     */
    public String getSpaceColor() {
        return color;
    }

    /**
     * accessor for empty
     * @return boolean -- if the space is empty or not
     */
    public boolean isEmpty() {
        return empty;
    }

    /**
     * mutator method to add a piece to the space
     * @param myPiece -- the new piece on the space
     */
    public void setPiece(Piece myPiece) {
        pieceOnSpace=myPiece;
        empty=false;
    }

    /**
     * mutator method to remove a piece to the space
     * @return Piece -- the old piece on the space
     */
    public Piece removePiece() {
        Piece currentPiece=getPiece();
        setPiece(null);
        empty=true;
        return currentPiece;
    }

    /**
     * the representation of a boardgame space is the piece on it or nothing if no piece
     * @return String -- boardgame space's string representation
     */
    @Override
    public String toString() {
        if (getPiece()==null) {
            return "----------";
        } else {
            return getPiece().toString();
        }
    }
}
