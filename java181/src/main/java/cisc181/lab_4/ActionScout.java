package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * ActionScout Class
 */
public class ActionScout extends Action {

    // constructor
    public ActionScout(Game181H game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game,fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    /**
     * Returns whether the action is valid, and bases this on whether
     * fromSpace, toSpace, and validActionPath methods of superclass are true
     * @return boolean: Whether the action is valid
     */
    public boolean validAction(){
        //cannot take full radius if where you are moving is on the border
        if(toSpaceCol==0 || toSpaceCol==3 || toSpaceRow==0 || toSpaceRow==3) {
            return false;
        }

        if(super.fromSpaceValid() && super.toSpaceValid(true) && validActionPath()){
            return true;
        }
        return false;
    }

    /**
     * This method removes Piece from the from space, sets Piece onto the space, checks to see if
     * any opponent is hidden within a one space radius, and changes the turn
     */
    public void performAction(){
        //move piece
        game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(
                game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].removePiece());

        //make sure there is a piece on boardspace before call method on it
        if( (!(game.getBoard().getSpaces()[toSpaceRow+1][toSpaceCol+1].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow+1][toSpaceCol+1].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow+1][toSpaceCol-1].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow+1][toSpaceCol-1].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow-1][toSpaceCol+1].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow-1][toSpaceCol+1].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow-1][toSpaceCol-1].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow-1][toSpaceCol-1].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow+1][toSpaceCol].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow+1][toSpaceCol].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow][toSpaceCol+1].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow][toSpaceCol+1].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow-1][toSpaceCol].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow-1][toSpaceCol].getPiece().isHidden()) ||
                (!(game.getBoard().getSpaces()[toSpaceRow][toSpaceCol-1].isEmpty()) && game.getBoard().getSpaces()[toSpaceRow][toSpaceCol-1].getPiece().isHidden())){
            System.out.println("\nThere is an opponent piece hidden within one spot (left, right, up, " +
                    "down, or diagonal of you!\n");
        } else {
            System.out.println("\nThere is no opponent piece hidden within one spot of you.\n");
        }
        game.changeTurn();
    }
}
