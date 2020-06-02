package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Action Class
 */
public abstract class Action {
    //Fields
    protected Game181H game;
    protected int fromSpaceRow;
    protected int fromSpaceCol;
    protected int toSpaceRow;
    protected int toSpaceCol;
    //Constructor
    public Action(Game181H game, int fromRow, int fromColumn, int toRow, int toColumn){
        this.game = game;
        this.fromSpaceRow = fromRow;
        this.fromSpaceCol = fromColumn;
        this.toSpaceRow = toRow;
        this.toSpaceCol = toColumn;

    }
    //Accessor Methods


    /**
     * Checks whether the row and column are in bounds on the board and checks
     * whether the space contains a game piece that belongs to the Team
     * @return: boolean whether the from space is valid
     */
    public boolean fromSpaceValid(){
        if((game.getBoard().inBounds(fromSpaceRow, fromSpaceCol)) &&
                game.getCurrentTeam().getTeamPieces().contains
                        (game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].
                                getPiece())){
            return true;
        }
        return false;
    }

    /**
     * Checks whether the row and column are in bounds, whether the space is empty if the parameter
     * is true or if the space contains the opponent's team piece if the parameter is false
     * @param isEmpty: represents whether the space should be empty
     * @return: boolean: whether the toSpace is valid
     */
    public boolean toSpaceValid(boolean isEmpty){
        if((game.getBoard().inBounds(toSpaceRow, toSpaceCol)) && isEmpty && game.getBoard().
                getSpaces()[toSpaceRow][toSpaceCol].isEmpty()){
            return true;
        }
        else if(game.getBoard().inBounds(toSpaceRow, toSpaceCol) &&
                !isEmpty &&
                game.getOpponentTeam().getTeamPieces()
                        .contains(game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece())){
            return true;
        }
        return false;
    }


    /**
     * Checks whether the path from the from space to the to space is valid for
     * the type of Piece that is on the from space
     * @return: boolean of whether the path is valid
     */
    public boolean validActionPath(){
        if(game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].getPiece()
                .validPath(fromSpaceRow, fromSpaceCol, toSpaceRow,
                        toSpaceCol)){
            return true;
        }
        return false;
    }
    //Abstract methods
    public abstract boolean validAction();
    public abstract void performAction();


}
