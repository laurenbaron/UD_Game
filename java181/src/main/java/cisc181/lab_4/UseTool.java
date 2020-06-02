package cisc181.lab_4;

import java.util.Scanner;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * UseTool Class
 */
public class UseTool {

    private Game181H game;

    /**
     * one parameter constructor that accepts and sets the game member field
     * @param game -- the game for 181H
     */
    public UseTool(Game181H game) {
        this.game=game;
    }

    /**
     * whether or not the action with the passed tool is valid
     * @param myTool -- the tool we are validating
     * @return boolean -- whether or not the action is valid (is valid if tool is not a coin and it
     * is in the current team's toolbox)
     */
    public boolean validUseToolAction(Tool myTool) {
        return ((myTool.getToolType()!=Tool.ITEM.COIN) &&
                game.getCurrentTeam().getToolBox().hasTool(myTool.getToolType(), myTool.getToolStrength()));
    }

    /**
     * removes a tool from one toolbox and adds it to another
     * @param myTool -- the tool being exchanged
     * @param removedFrom -- the toolbox the tool is being removed from
     * @param addedTo -- the toolbox the tool is being added to
     */
    public void exchangeTool(Tool myTool, ToolBox removedFrom, ToolBox addedTo) {
        removedFrom.removeTool(myTool.getToolType(), myTool.getToolStrength());
        addedTo.addTool(myTool);
    }

    /**
     * either hides or unhides Pieces on the gameboard
     * @param hidden -- whether pieces should be hidden (true) or unhidden (false)
     * @param allPieces -- whether ALL the team pieces or only ONE piece hidden/unhidden
     * @param myTeam -- the team that is having pieces hidden/unhidden
     */
    private void performHide(boolean hidden, boolean allPieces, TeamH myTeam) {
        if (allPieces) {
            for (Piece myPiece : myTeam.getTeamPieces()) {
                myPiece.setHidden(hidden);
            }
        } else {
            boolean changed=false;
            int i=0;

            while (!changed) {
                //hide/unhide one of the team's pieces (can't hide something that's already hidden)
                if (myTeam.getTeamPieces().get(i).isHidden() != hidden) {
                    myTeam.getTeamPieces().get(i).setHidden(hidden);
                    changed=true;
                }
            }
        }
    }

    /**
     * helper method to duplicate piece for mirror tool
     * @return Piece- the duplicated piece
     */
    private Piece duplicate() {
        Piece myPiece=game.getCurrentTeam().getTeamPieces().get(0);
        Piece duplicate;
        //duplicate first player of the team
        if(myPiece instanceof PieceBlueHen) {
            duplicate=new PieceBlueHen(myPiece.getSymbol(), myPiece.getColor(),0,0);
        } else if (myPiece instanceof PiecePenguin) {
            duplicate=new PiecePenguin(myPiece.getSymbol(), myPiece.getColor(),0,0);
        } else if (myPiece instanceof PieceSharkBait) {
            duplicate=new PieceSharkBait(myPiece.getSymbol(), myPiece.getColor());
        } else if (myPiece instanceof PieceHengineer) {
            duplicate=new PieceHengineer(myPiece.getSymbol(), myPiece.getColor());
        } else {
            duplicate = new PieceBookWorm(myPiece.getSymbol(), myPiece.getColor(), 0);
        }
        return duplicate;
    }

    /**
     * carry out the actions corresponding to the table and updates the team's toolbox,
     * game's toolbox, and turn
     * @param myTool -- the tool that is being used
     */
    public void performToolAction(Tool myTool) {
        //perform action and remove from the team's toolbox (depends on given chart)
        if (myTool.getToolType() == Tool.ITEM.CLOAK && myTool.getToolStrength() == Tool.STRENGTH.SILVER) {
            performHide(true, false, game.getCurrentTeam());
            game.getCurrentTeam().getToolBox().removeTool(myTool.getToolType(), myTool.getToolStrength());
        } else if (myTool.getToolType() == Tool.ITEM.GLASSES && myTool.getToolStrength() == Tool.STRENGTH.GOLD) {
            performHide(false, true, game.getOpponentTeam());
            game.getOpponentTeam().getToolBox().removeTool(myTool.getToolType(), myTool.getToolStrength());
        } else if (myTool.getToolType() == Tool.ITEM.GLASSES && myTool.getToolStrength() == Tool.STRENGTH.SILVER) {
            performHide(false, false, game.getOpponentTeam());
            game.getOpponentTeam().getToolBox().removeTool(myTool.getToolType(), myTool.getToolStrength());
        } else if (myTool.getToolType() == Tool.ITEM.MIRROR && myTool.getToolStrength() == Tool.STRENGTH.SILVER) {
            Piece duplicate = duplicate();
            //put on random space
            game.getBoard().findRandomEmptySpace().setPiece(duplicate);
            game.getCurrentTeam().addPieceToTeam(duplicate);

        } else if (myTool.getToolType() == Tool.ITEM.MIRROR && myTool.getToolStrength() == Tool.STRENGTH.GOLD) {
            int row=0, col=0;
            Piece duplicate = duplicate();
            Scanner scnr = new Scanner(System.in);
            game.getCurrentTeam().addPieceToTeam(duplicate);


            do {
                System.out.println("Enter row of an empty space to duplicate your piece onto: ");
                row = scnr.nextInt();
                System.out.println("Enter col of an empty space to duplicate your piece onto: ");
                col = scnr.nextInt();
            } while (!game.getBoard().getSpaces()[row][col].isEmpty());

            game.getBoard().getSpaces()[row][col].setPiece(duplicate);
         }

        //add tool to game toolbox and change turn
        game.getGameToolBox().addTool(myTool);
        game.changeTurn();
    }
}
