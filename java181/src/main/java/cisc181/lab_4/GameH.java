package cisc181.lab_4;

import java.util.Collections;

//Lauren Baron and Swetha Sankar 080

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * GameH Class
 */
public abstract class GameH {
    protected Board gameBoard;
    protected TeamH team1; //one for each player
    protected TeamH team2;
    protected ToolBox gameToolBox; //should have ALL tools
    protected String turn;//the name of the team whose turn it is–change after each player takes a turn
    protected BoardSpace randSpace; //random construction space. generates one at beginning of game.

    /**
     * four parameter constructor that sets up the teams, whose turn it is, the toolbox, and board)
     * @param rows -- the number of rows on the board
     * @param cols -- the number of columns on the board
     * @param team1 -- the first team playing the game
     * @param team2 -- the second team playing the game
     */
    public GameH(int rows, int cols, TeamH team1, TeamH team2) {
        this.team1=team1;
        this.team2=team2;
        turn=team1.getTeamName();
        initializeGameBoard(rows, cols);
        gameToolBox =new ToolBox(true);
        this.randSpace = getBoard().findRandomEmptySpace();

        //remove two silver coins from the game toolbox and give one to each team's
        gameToolBox.removeTool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER);
        gameToolBox.removeTool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER);
        team1.getToolBox().addTool(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        team2.getToolBox().addTool(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
    }

    /**
     * getter method for random construction space
     * @return BoardSpace
     */
    public BoardSpace getRandSpace(){ return this.randSpace;}
    /**
     * set up the game board
     * @param rows -- the number of rows for the game board
     * @param cols -- the number of columns for the game board
     */
    protected void initializeGameBoard(int rows, int cols) {
        gameBoard=new Board(rows, cols);
        //set up both Team's pieces randomly on the board
        for(Piece myPiece: team1.getTeamPieces()) {
            gameBoard.findRandomEmptySpace().setPiece(myPiece);
        }
        for(Piece myPiece: team2.getTeamPieces()) {
            gameBoard.findRandomEmptySpace().setPiece(myPiece);
        }
    }

    /**
     * accessor method for gameBoard
     * @return -- the game's board
     */
    public Board getBoard() {
        return gameBoard;
    }

    /**
     * accessor method for the current team
     * @return -- the team whose turn it is
     */
    public TeamH getCurrentTeam() {
        if (isTurn(team1)) {
            return team1;
        } else {
            return team2;
        }
    }

    /**
     * accessor method for the opponent team
     * @return -- the team whose turn it isn't
     */
    public TeamH getOpponentTeam() {
        if (isTurn(team1)) {
            return team2;
        } else {
            return team1;
        }
    }

    /**
     * accessor method for the team whose turn it is
     * @param team -- the team we are checking if it is their turn
     * @return boolean -- whether it is the given team's turn
     */
    public boolean isTurn(TeamH team) {
        return (turn.equals(team.getTeamName()));
    }

    /**
     * mutator method that sets turn to switch to the other team's name
     */
    public void changeTurn() {
        if (isTurn(team1)) {
            turn=team2.getTeamName();
        } else {
            turn=team1.getTeamName();
        }
    }

    /**
     * abstract method to check if we have a winner to this game
     * @return boolean -- whether or not there is a winning team
     */
    public abstract boolean isAWinner();

    /**
     * abstract method to get the winning team
     * @return TeamH -- the team that won
     */
    public abstract TeamH getWinner();

    /**
     * abstract method to check if the game has ended
     * @return boolean -- whether or not the game has ended
     */
    public abstract boolean isGameEnded();

    /**
     * given toString method
     * @return -- the string representation of a game
     */
    @Override
    public String toString() {
        StringBuilder retString = new StringBuilder();
        retString.append("Game ToolBox:\n").append(gameToolBox.toString());
        retString.append(String.join("", Collections.nCopies(50, "*")))
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getCurrentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\n\n" + getOpponentTeam().toString() + "\n")
                .append(String.join("", Collections.nCopies(50, "*")))
                .append("\nGame Board:\n")
                .append("\n" + getBoard().toString())
                .append("\nIt is Team" + getCurrentTeam().getTeamName() + "'s turn\n");
        return retString.toString();
    }

    /**
     * accessor method for the game tool box
     * @return ToolBox- the game's toolbox
     */
    public ToolBox getGameToolBox() {
        return gameToolBox;
    }
}
