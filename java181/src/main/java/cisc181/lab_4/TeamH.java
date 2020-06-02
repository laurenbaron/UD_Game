package cisc181.lab_4;

import java.util.ArrayList;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * TeamH Class
 */
public class TeamH {
    private String teamName;
    private String teamColor;
    private ArrayList<Piece> teamPieces;
    private ToolBox toolbox;

    /**
     * 3 parameter constructor that sets the first 3 memeber fields and creates a new toolbox
     * @param teamName -- the team's name
     * @param teamColor -- the team's color
     * @param teamPieces -- the pieces that belong to the team
     */
    public TeamH (String teamName, String teamColor, ArrayList<Piece> teamPieces) {
        this.teamName=teamName;
        this.teamColor=teamColor;
        this.teamPieces=teamPieces;
        toolbox=new ToolBox(false);
    }

    /**
     * accessor for teamName
     * @return String -- the team's name
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * accessor for teamColor
     * @return String -- the team's color
     */
    public String getTeamColor() {
        return teamColor;
    }

    /**
     * accessor for teamPieces
     * @return ArrayList<Piece> -- the team's pieces
     */
    public ArrayList<Piece> getTeamPieces() {
        return teamPieces;
    }

    /**
     * accessor for toolbox
     * @return ToolBox -- the team's toolbox
     */
    public ToolBox getToolBox() {
        return toolbox;
    }

    //????

    /**
     * mutator method to remove the given Piece from the team
     * @param removeThis -- the piece to remove from the team
     */
    public void removePieceFromTeam(Piece removeThis) {
        teamPieces.remove(removeThis);
    }

    /**
     * mutator method to add a piece to the team
     * @param addThis -- the piece to add to the team (set color to the team color)
     */
    public void addPieceToTeam(Piece addThis) {
        addThis.setColor(teamColor);
        teamPieces.add(addThis);
    }

    /**
     * the team name, color, all of its pieces (their toString values), and the toolbox's toString
     * @return -- the string representation of a team
     */
    @Override
    public String toString() {
        String myString=("Team " + getTeamName() + " : " + getTeamColor() + "\nPieces : ");
        for(Piece myPiece : teamPieces) {
            myString+=(myPiece.toString()+" ");
        }
        myString+="\nTools : "+toolbox.toString();
        return myString;
    }
}
