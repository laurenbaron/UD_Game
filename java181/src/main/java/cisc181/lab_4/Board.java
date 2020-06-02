package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Board Class
 */
public class Board {

    private int rows; //the number of rows on the board
    private int columns; //the number of columns on the board
    private BoardSpace[][] spaces; //all the spaces on the board

    /**
     * constructor with all parameters (makes a board)
     * @param rows -- the number of rows for the board
     * @param columns -- the number of columns for the board
     */
    public Board(int rows, int columns) {
        this.rows=rows;
        this.columns=columns;
        spaces=new BoardSpace[rows][columns];
        setUpEmptyBoard();
    }

    /**
     * accessor method for the number of rows
     * @return int -- board's rows
     */
    public int getNumRows() {
        return rows;
    }

    /**
     * accessor method for the number of columns
     * @return int -- board's columns
     */
    public int getNumColumns() {
        return columns;
    }

    /**
     * accessor method for the board's spaces
     * @return BoardSpace[][] -- 2D array of the board's spaces
     */
    public BoardSpace[][] getSpaces() {
        return spaces;
    }

    /**
     * whether or not the space at the given location is within the bounds of the board
     * ex: inBounds(5,5) is false for any board with less than 6 rows and less than 6 columns
     * @param row -- row index
     * @param column -- column index
     * @return boolean -- whether the space is in bounds of the board
     */
    public boolean inBounds(int row, int column) {
        if ((row<0) || (column<0)) {
            return false;
        }
        return ((row<getNumRows()) && (column<getNumColumns()));
    }

    /**
     * creates a boardgame space object for each location in the spaces array
     */
    public void setUpEmptyBoard() {
        for (int row=0; row<getNumRows(); row++) {
            for (int column=0; column<getNumColumns(); column++) {
                //make checkerboard pattern
                if (((column%2==0) && (row%2==0)) || ((column%2!=0) && (row%2!=0))) {
                    spaces[row][column]=new BoardSpace(row, column, "White");
                } else {
                    spaces[row][column]=new BoardSpace(row, column, "Black");
                }
            }
        }
    }

    /**
     * randomly finds spaces on the board and checks if empty or not until find one that is
     * @return BoardSpace -- the empty board space
     */
    public BoardSpace findRandomEmptySpace() {
        //uses Math.random() to generate random row and column indexes
        int row=(int) (Math.random() * getNumRows());
        int column= (int) (Math.random() * getNumColumns());
        BoardSpace space = spaces[row][column];

        while (!space.isEmpty()) {
            row=(int) (Math.random() * getNumRows());
            column= (int) (Math.random() * getNumColumns());
            space = spaces[row][column];
        }
        return space;
    }

    /**
     * provided code to represent a board
     * @return String -- string representation of a board
     */
    @Override
    public String toString() {
        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :        ");
        for (int col = 0; col < spaces[0].length ; col++){
            boardString.append(col + "       ");
        }
        boardString.append("\n");
        for (int row = 0; row < spaces.length ; row++){
            boardString.append("Row : " +row + "   ");
            for (int col = 0; col < spaces[row].length ; col++){
                boardString.append(spaces[row][col].toString() + "  ");
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }
}
