package cisc181.lab_4;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Game181 Class
 */
public class Game181H extends GameH {

    private ArrayList<Piece> possiblePieces;

    /**
     * four parameter constructor that sets up the teams, whose turn it is, the toolbox, and the board)
     * @param rows  -- the number of rows on the board
     * @param cols  -- the number of columns on the board
     * @param team1 -- the first team playing the game
     * @param team2 -- the second team playing the game
     */
    public Game181H(int rows, int cols, TeamH team1, TeamH team2) {
        super(rows, cols, team1, team2);
        possiblePieces=new ArrayList<Piece>(); //set up possible pieces for teams to pick
        initializePossiblePieces();
    }

    /**
     * there is a winner if the game has ended and only one of the Teams still has pieces on the board
     * or if the other team has lost their hengineer
     * @return boolean -- whether or not if there is a winning team
     */
    @Override
    public boolean isAWinner() {
        boolean hasWon = false;

        if(isGameEnded() && ((!team1.getTeamPieces().isEmpty()) || (!team2.getTeamPieces().isEmpty()))){
            hasWon = true;
        }

        if(isGameEnded() && (!hasHengineer(team1) || !hasHengineer(team2))) {
            hasWon = true;
        }
        return hasWon;
    }

    /**
     * method to get the winning team
     * @return TeamH -- the team that won
     */
    @Override
    public TeamH getWinner() {
        boolean hengineer = false; //if they still have their hengineer

        if (!isAWinner()) {
            return null;
        } else{
            if(team1.getTeamPieces().isEmpty()){
                return team2;
            } else if(team2.getTeamPieces().isEmpty()){
                return team1;
            } else if (hasHengineer(team2)){
                return team2;
            } else if(hasHengineer(team1)){
                return team1;
            }
        }
        return null;
    }

    /**
     * helper method to determine whether or not a team still has their hengineer
     * @param team -- the team to check
     * @return boolean -- if they have their hengineer
     */
    private boolean hasHengineer(TeamH team) {
        for(Piece myPiece: team.getTeamPieces()) {
            if (myPiece instanceof PieceHengineer) {
                return true;
            }
        }
        return false;
    }

    /**
     * the game has ended if at least one of the Teams has no more pieces on the board
     * or if a team has lost their hengineer
     * @return boolean -- whether or not the game has ended
     */
    @Override
    public boolean isGameEnded() {
        boolean gameEnded = false;

        if((team1.getTeamPieces().isEmpty()) || (team2.getTeamPieces().isEmpty()) || !hasHengineer(team1) || !hasHengineer(team2)){
            gameEnded = true;
        }
        return gameEnded;
    }

    /**
     * given method to create a string representation of the board
     * doesn't display Piedes that have their member field hidden set to true if opponent piece
     * @return String -- representation of hidden board
     */
    public String strHiddenBoard() {
        Piece curPiece;

        StringBuilder boardString = new StringBuilder();
        boardString.append("Col :       ");

        for (int col = 0; col < getBoard().getSpaces()[0].length; col++) {
            boardString.append(col + "           ");
        }
        boardString.append("\n");
        for (int row = 0; row < getBoard().getSpaces().length; row++) {
            boardString.append("Row : " + row + "   ");
            for (int col = 0; col < getBoard().getSpaces()[row].length; col++) {
                curPiece = getBoard().getSpaces()[row][col].getPiece();
                if (curPiece == null) {
                    boardString.append("----------" + "  ");
                }
                // if the Piece is hidden and it belongs to the other
                // team - don't show it on the board
                else if (curPiece.isHidden() && getOpponentTeam().getTeamPieces().contains(curPiece)){
                    boardString.append("----------" + "  ");
                }
                else {
                    boardString.append(getBoard().getSpaces()[row][col].toString() + "  ");
                }
            }
            boardString.append("\n");
        }
        return boardString.toString();
    }

    /**
     * given overridden toString to call the setHiddenBoard
     * @return String -- string representation of game 181 H
     */
    @Override
    public String toString(){
        StringBuilder retString = new StringBuilder();
        retString.append("Game ToolBox:\n").append(gameToolBox.toString());
        retString.append(String.join("", Collections.nCopies(50, "*")))
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nGame Board:\n")
                .append(strHiddenBoard())
                .append("\nIt is Team " + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }

    /**
     * initialize possible pieces array with the possible pieces the teams can choose from
     */
    private void initializePossiblePieces() {
        //make names as close to 8 characters bc want board to be even
        possiblePieces.add(new PieceBlueHen("YoUDee!!")); //UD's mascots
        possiblePieces.add(new PieceBlueHen("BabyBlue"));
        possiblePieces.add(new PiecePenguin("Kowalski"));//Penguins of Madagascar
        possiblePieces.add(new PiecePenguin("SkipperP"));
        possiblePieces.add(new PiecePenguin("PrivateP"));
        possiblePieces.add(new PiecePenguin("RicoPeng"));
        possiblePieces.add(new PieceSharkBait("NemoFish"));//Finding Nemo characters
        possiblePieces.add(new PieceSharkBait("DoryFish"));
        possiblePieces.add(new PieceSharkBait("MarlinSB"));
        possiblePieces.add(new PieceHengineer("SwethaCS")); //Hengineer game-makers
        possiblePieces.add(new PieceHengineer("LaurenCS"));
        possiblePieces.add(new PieceBookWorm("MorrisLB")); //based off UD buildings
        possiblePieces.add(new PieceBookWorm("ReddingH"));
        possiblePieces.add(new PieceBookWorm("GoreHall"));
    }

    /**
     * ability for players to choose Pieces for their team
     */
    public void choosePlayers() {
        String choice;

        //keep choosing until all unpicked players are gone
        while(possiblePieces.size()!=0) {
            //print the possible options of players to pick
            System.out.println("\nIt is Team "+getCurrentTeam().getTeamName()+"'s turn to pick a player");
            System.out.println("Available Pieces:");
            for (Piece myPiece : possiblePieces) {
                System.out.println(myPiece.getSymbol());
            }
            System.out.println("\nChoose a piece for your team (Type name exactly as shown): ");
            Scanner scnr = new Scanner(System.in);
            choice = scnr.next(); //get what team wants to pick

            //convert the string into a Piece object, making sure they entered a valid name
            if (getPiece(choice)==null) {
                System.out.println("Invalid entry. Try again");
            } else {
                //add piece to the team that picked, remove from possible players, and change who is picking
                getCurrentTeam().addPieceToTeam(getPiece(choice));
                possiblePieces.remove(getPiece(choice));
                changeTurn();
            }
        }
        //when they are done picking teams, make sure the teams they picked are valid (one of each Piece)
        if(!validTeam(getCurrentTeam()) || !validTeam(getOpponentTeam())) {
            System.out.println("Each team must pick one of each type of player. Pick teams again.");
            restart();
            choosePlayers();
        }
        //draw board with the team members on it
        super.initializeGameBoard(gameBoard.getNumRows(),gameBoard.getNumColumns());
    }

    /**
     * helper method to turn a String into a Piece
     * @param name -- the string name of the piece the team wants
     * @return Piece -- the object of the string name
     */
    private Piece getPiece(String name) {
        for(Piece myPiece: possiblePieces) {
            if(myPiece.getSymbol().equals(name)) {
                return myPiece;
            }
        }
        return null;
    }

    /**
     * helper method for when the team was invalid so must redraw and start with 0 players again
     */
    private void restart() {
        int size = getCurrentTeam().getTeamPieces().size(); //both teams should have same number of players

        initializePossiblePieces();
        for (int i = 0; i < size; i++) {
            //list gets shorter and shorter with each removal so keep removing from front
            getCurrentTeam().getTeamPieces().remove(0);
            getOpponentTeam().getTeamPieces().remove(0);
        }
    }

    /**
     * helper method to make sure a team has at least one of each type of player
     * @param team -- the team to check
     * @return boolean -- whether or not they picked a valid team
     */
    private boolean validTeam(TeamH team) {
        //counters to see if the teams have one of each
        int blueHens=0;
        int bookWorms=0;
        int hengineers=0;
        int penguins=0;
        int sharkBaits=0;

        //go through each teams players and mark what type of piece they are
        for(Piece myPiece: team.getTeamPieces()) {
            if(myPiece instanceof PieceBlueHen) {
                blueHens++;
            } else if(myPiece instanceof PieceBookWorm) {
                bookWorms++;
            } else if(myPiece instanceof PieceHengineer) {
                hengineers++;
            } else if(myPiece instanceof PiecePenguin) {
                penguins++;
            } else if(myPiece instanceof PieceSharkBait) {
                sharkBaits++;
            }
        }

        if(blueHens<1 || bookWorms<1 || hengineers<1 || penguins<1 || sharkBaits<1) {
            return false;
        } else {
            return true;
        }
    }
}

