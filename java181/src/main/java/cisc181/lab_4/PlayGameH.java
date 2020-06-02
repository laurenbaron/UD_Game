package cisc181.lab_4;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PlayGameH Class
 */
public class PlayGameH {
    private Game181H game;

    /**
     * one parameter constructor that accepts and sets the game member field
     * @param game -- the game for 181H
     */
    public PlayGameH(Game181H game) {
        this.game=game;
    }

    /**
     * asks the players to enter a char at the keyboard that represents the type of action they want
     * to take on their turn
     * @param scnr -- Scanner to get user input
     * @return char -- the char they entered
     */
    private char getValidActionType(Scanner scnr) {
        char actionType='\u0000';

        //keep asking for action type until they enter a valid one
        while(actionType!='M' && actionType!='R' && actionType!='A' && actionType!='T' && actionType!='S') {
            System.out.println("Please Enter the Letter of an Action Type\n" +
                    "M: Move  R: Recruit  A: Attack  T: Use Tool  S: Scout");
            actionType = scnr.next().charAt(0);
        }
        return actionType;
    }

    /**
     * based on the user's selected action, perform that action if valid
     */
    private void nextPlayersAction() {
        boolean valid=false;
        Scanner scnr=new Scanner(System.in);

        while(!valid) {
            char action=getValidActionType(scnr); //get the type of action the player wants to take

            //T to use a tool
            if(action=='T') {
                valid=userT(scnr);
                //exit method if action performed
                if (valid) {
                    return;
                }
            } else if (action=='A' || action=='M' || action=='R' || action=='S') {
                valid=userAMRS(action, scnr);
                if (valid) {
                    return;
                }
            }
            System.out.println("Input invalid. Please try again...\n");
        }
    }

    /**
     * helper method to perform an action (based on if user picked attack, move, or recruit)
     * @param action -- the action the user selected
     * @param scnr -- scanner to get user input
     * @return boolean -- whether or not the action was valid
     */
    private boolean userAMRS(char action, Scanner scnr) {
        // A, M, S, or R
        Action myAction;
        int rowFrom, colFrom, rowTo, colTo;
        System.out.print("Enter the row index of the from space: ");
        rowFrom=scnr.nextInt();
        System.out.print("Enter the column index of the from space: ");
        colFrom=scnr.nextInt();
        System.out.print("Enter the row index of the to space: ");
        rowTo=scnr.nextInt();
        System.out.print("Enter the column index of the to space: ");
        colTo=scnr.nextInt();

        //create instance of appropriate action subclass base on user's selection
        if (action=='A') {
            myAction=new ActionAttack(game, rowFrom, colFrom, rowTo, colTo);
        } else if (action=='M') {
            myAction=new ActionMove(game, rowFrom, colFrom, rowTo, colTo);
        } else if (action=='R'){
            myAction=new ActionRecruit(game, rowFrom, colFrom, rowTo, colTo);
        } else {
            myAction=new ActionScout(game, rowFrom, colFrom, rowTo, colTo);
        }

        if(myAction.validAction()) {
            myAction.performAction();
            return true;
        } else {
            return false;
        }
    }

    /**
     * helper method to use a tool
     * if a coin, purchase another tool from an appropriate toolbox
     * if not a coin, perform a valid action
     * @param scnr -- Scanner to get user input
     * @return boolean -- whether or not the action was valid (if not we need to continue with loop)
     */
    private boolean userT(Scanner scnr) {
        Tool myTool = getValidTool(scnr);
        //display the list of tools the user can choose from if they selected a coin
        if (myTool.getToolType() == Tool.ITEM.COIN) {
            if (myTool.getToolStrength() == Tool.STRENGTH.GOLD) {
                System.out.println("Game Tool Box: \n" + game.getGameToolBox().toString());
                System.out.println("Opponent Team Tool Box: \n" + game.getOpponentTeam().getToolBox().toString());
            } else {
                System.out.println("Game Tool Box: \n" + game.getGameToolBox().toString());
            }
            //get the tool they want to purchase with their coin and do it if valid
            Tool purchasingTool = getValidTool(scnr);
            PurchaseTool purchase = new PurchaseTool(game);
            if (purchase.validToolPurchase(myTool, purchasingTool)) {
                purchase.performToolPurchase(myTool, purchasingTool);
                return true;
            } else {
                return false; //if purchase not valid must reloop
            }
        } else {
            //the user did not select a coin
            UseTool use = new UseTool(game);
            if (use.validUseToolAction(myTool)) {
                use.performToolAction(myTool);
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * helper method to get a valid tool the user inputted that they want
     * @param scnr -- Scanner to get user input
     * @return Tool -- the Tool the user selected
     */
    private Tool getValidTool(Scanner scnr) {
        Tool myTool=null;
        String input="";

        //keep asking for action type until they enter a valid one
        while(myTool==null) {
            //remind user of what is in their own toolbox before they select tool to use/purchase
            System.out.println("Current Team Tool Box: \n" + game.getCurrentTeam().getToolBox().toString());
            System.out.println("Please Enter the name of the tool you want in the following format: "
                +"strength-type (EX: GOLD-COIN) : ");
            input=scnr.next();

            //match the string input with a real tool
            if (input.equals("GOLD-COIN")) {
                myTool=new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD);
            } else if (input.equals("SILVER-COIN")) {
                myTool=new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER);
            } else if (input.equals("GOLD-CLOAK")) {
                myTool=new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.GOLD);
            } else if (input.equals("SILVER-CLOAK")) {
                myTool=new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER);
            } else if (input.equals("GOLD-GLASSES")) {
                myTool=new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD);
            } else if (input.equals("SILVER-GLASSES")) {
                myTool=new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER);
            } else if (input.equals("SILVER-MIRROR")) {
                myTool=new Tool(Tool.ITEM.MIRROR, Tool.STRENGTH.SILVER);
            } else if (input.equals("GOLD-MIRROR")) {
                myTool=new Tool(Tool.ITEM.MIRROR, Tool.STRENGTH.GOLD);
            } else {
                System.out.println("Input invalid. Please try again...\n");
            }
        }
        return myTool;
    }

    /**
     * Play the game -- print game and call next player action until game has ended.
     * then print that it has ended and the winner (if there is one)
     */
    public void playOurGame() {
        while (!game.isGameEnded()) {
            System.out.println(game.toString());
            nextPlayersAction();
        }
        System.out.print("Game has ended. ");
        if (game.isAWinner()) {
            System.out.print("Winner: " + game.getWinner().toString());
        } else {
            System.out.print("There is no winner");
        }
    }

    /**
     * given main method to play our game
     * @param args
     */
    public static void main(String[] args){
        // Create an array list to hold Team A's pieces
        ArrayList<Piece> piecesTeamA = new ArrayList<>();
        // Create an array list to hold Team B's pieces
        ArrayList<Piece> piecesTeamB = new ArrayList<>();

        // Create TeamA and TeamB objects and pass them the array lists of pieces
        TeamH teamA = new TeamH("A", "Red", piecesTeamA);
        TeamH teamB = new TeamH("B",  "Green", piecesTeamB);

        // Create an instance of the game
        Game181H ourGame = new Game181H(7, 7,teamA, teamB);

        //initialize the teams pieces
        ourGame.choosePlayers();

        // Create PlayGame object and play the game
        PlayGameH play = new PlayGameH(ourGame);
        play.playOurGame();

    }
}
