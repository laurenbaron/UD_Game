package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * ActionMove Class
 */
public class ActionMove extends Action {
    //Constructor
    public ActionMove(Game181H game, int fromRow, int fromColumn, int toRow, int toColumn) {
        super(game, fromRow, fromColumn, toRow, toColumn);

    }

    /**
     * Returns whether the action is valid, and bases this on whether
     * fromSpace, toSpace, and validActionPath methods of superclass are true
     *
     * @return boolean: Whether the action is valid
     */
    public boolean validAction() {
        if (super.fromSpaceValid() && super.toSpaceValid(true) && validActionPath()) {
            return true;
        }
        return false;
    }

    /**
     * This method removes Piece from the from space, sets Piece onto the space,
     * and changes the turn
     * It also checks whether the piece is set to land on the construction site (random empty space
     * chosen at beginning of game). If it does, then it prints out a message, removes the piece from the game,
     * and changes the turn.
     */
    public void performAction() {
        if (super.toSpaceRow == game.getRandSpace().getRow()&& super.toSpaceCol == game.getRandSpace().getColumn()) {
            game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].removePiece());
            game.getCurrentTeam().removePieceFromTeam(game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece());
            game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].removePiece();
            System.out.println("You have landed on the invisible UD Construction Zone BoardSpace. " +
                    "You have been taken out of the game and your team's turn is over");
            game.changeTurn();
        } else {
            game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].setPiece(
                    game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].removePiece());
            game.changeTurn();
        }
    }
}
