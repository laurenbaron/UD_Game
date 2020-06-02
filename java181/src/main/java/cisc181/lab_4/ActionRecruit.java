package cisc181.lab_4;
/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * ActionRecruit Class
 */
public class ActionRecruit extends Action {

   // constructor
    public ActionRecruit(Game181H game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    // Check to see if this is valid Recruit Action
    public boolean validAction() {
        // check if from space valid
        if(fromSpaceValid() ) {
            // get the piece that is in the from BoardSpace
            // cannot recruit a hengineer piece
            boolean notHengineer = true;
            Piece fromPiece = game.getBoard().getSpaces()
                    [fromSpaceRow][fromSpaceCol].getPiece();
            Piece toPiece = game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece();
            // check to see if this piece has implemented the Recruiter interface
            if (Recruiter.class.isAssignableFrom(fromPiece.getClass())) {
                if(toPiece instanceof PieceHengineer){
                    notHengineer = false;
                }
                // if to space valid - should NOT be empty so pass a value of false to the toSpaceValid method
                if (toSpaceValid(false)) {
                    return validActionPath() && notHengineer;
                }
            } else {
                System.out.println("The piece on first space can't recruit.");
                return false;
            }
        }
        return false;
    }
    // this method calls the Piece's recruit method
    private void recruit(){
        // Get the piece that is in the fromSpace
        Piece recPiece = game.getBoard()
                .getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        Piece recruitee = game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece();
        // check to see which type of Piece we have
        // we can't call the recruit method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Recruiter Interface
        // so we will cast the Piece to its subclass type so we can call recruit
        if(recPiece instanceof PieceSharkBait){
            // cast and call SharkBait's recruit method
            ((PieceSharkBait) recPiece).recruit(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
        else if(recPiece instanceof PiecePenguin){
            // cast and call Penguin's recruit method
            ((PiecePenguin) recPiece).recruit(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
        else if(recPiece instanceof PieceBookWorm){
            ((PieceBookWorm) recPiece).recruit(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
    }

    /**
     * Calls helper method recruit, removes the Piece that was recruited from the opponent's team,
     * adds the Piece that was just recruited to the current team, and changes the turn
     */
     public void performAction() {
        recruit();
        game.getOpponentTeam().removePieceFromTeam(game.getBoard().
                getSpaces()[toSpaceRow][toSpaceCol].getPiece());
        game.getCurrentTeam().addPieceToTeam(game.getBoard().
                getSpaces()[toSpaceRow][toSpaceCol].getPiece());
        game.changeTurn();

    }
}