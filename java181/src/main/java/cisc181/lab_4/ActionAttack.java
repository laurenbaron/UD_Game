package cisc181.lab_4;
/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * ActionAttack Class
 */
public class ActionAttack extends Action {

   // constructor
    public ActionAttack(Game181H game, int fromSpaceRow, int fromSpaceCol, int toSpaceRow, int toSpaceCol) {
        super(game, fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
    }

    // Check to see if this is valid Attack Action
    public boolean validAction() {

        // check if from space valid
        if(fromSpaceValid() ) {
            boolean isDifferent = true;
            // get the piece that is in the from BoardSpace
            Piece fromPiece = game.getBoard().getSpaces()
                    [fromSpaceRow][fromSpaceCol].getPiece();
            // get piece that is in the to BoardSpace
            Piece toPiece = game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece();
            // check to see if this piece has implemented the Attacker interface
            if (Attacker.class.isAssignableFrom(fromPiece.getClass())) {
                if(toPiece.getClass() == fromPiece.getClass()){
                    //checks to make sure that the pieces aren't of the same type
                    //new rule: cannot attack pieces of same class
                    isDifferent = false;
                }
                // if to space is valid - should NOT be empty so pass false to the method
                if (toSpaceValid(false)) {
                    //only if both are true it returns
                    return validActionPath() && isDifferent;
                }
            } else {
                System.out.println("The piece on first space can't attack.");
                return false;
            }
        }
        return false;
    }

   // this method calls the Piece's attack method

    private void attack(){
        // Get the piece that is in the fromSpace
        Piece attPiece = game.getBoard()
                .getSpaces()[fromSpaceRow][fromSpaceCol].getPiece();
        // ** Final Project Edit: Get the piece in the to space
        Piece attackee = game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece();
        // check to see which type of Piece we have
        // we can't call the attack method on all pieces in the game
        // we can only call these methods on pieces that have this method - ie - Pieces that have implemented the Attacker Interface
        // so we will cast the Piece to its subclass type so we can call attack
        if(attPiece instanceof PieceBlueHen && !(attackee instanceof PieceBlueHen)){
            // cast and call BlueHen's attack method
            //added rule: cannot attack pieces of same type
             ((PieceBlueHen) attPiece)
                    .attack(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
        else if(attPiece instanceof PiecePenguin && !(attackee instanceof PiecePenguin)){
            // cast and call Penguin's attack method.
            // added rule: cannot attack piece of same type
            ((PiecePenguin) attPiece)
                    .attack(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
        else if(attPiece instanceof PieceHengineer && !(attackee instanceof PieceHengineer)){
            //cast and call Heningeer's attack method. Cannot attack fellow Hengineer.
            ((PieceHengineer) attPiece)
                    .attack(fromSpaceRow,fromSpaceCol,toSpaceRow,toSpaceCol);
        }
    }

    /**
     * Calls helper method attack, removes attacked piece from board, removes
     * attacked piece from opponent's team, moves the piece in the from space
     * to the to space, and changes the turn
     */
    public void performAction() {
        attack();

        Piece remove = game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].getPiece();
        game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].removePiece();
        game.getOpponentTeam().removePieceFromTeam(remove);
        game.getBoard().getSpaces()[toSpaceRow][toSpaceCol].
                setPiece(game.getBoard().getSpaces()[fromSpaceRow][fromSpaceCol].removePiece());
        game.changeTurn();

    }
}
