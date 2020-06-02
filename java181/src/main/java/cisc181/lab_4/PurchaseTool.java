package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * PurchaseTool Class
 */
public class PurchaseTool {

    private Game181H game;

    /**
     * one parameter constructor that accepts and sets the game member field
     * @param game -- the game for 181H
     */
    public PurchaseTool(Game181H game) {
        this.game=game;
    }

    /**
     * whether or not the tool purchase is valid (if the tool being used to purchase the other tool
     * is a coin, if the coin is in the current team's toolbox, and check purchased based on strength
     * @param payingWith -- the tool they are paying for the other tool with
     * @param purchasing -- the tool they want to purchase
     * @return boolean -- if the purchase if valid
     */
    public boolean validToolPurchase(Tool payingWith, Tool purchasing) {
        //check if the tool they are paying with is gold and it is in their toolbox
        boolean isValidCoin= (payingWith.getToolType()==Tool.ITEM.COIN) &&
                (game.getCurrentTeam().getToolBox().hasTool(payingWith.getToolType(), payingWith.getToolStrength()));

        //if coin is gold, they can purchase tool from either the game toolbox or their opponent's
        if (payingWith.getToolStrength() == Tool.STRENGTH.GOLD) {
            return (isValidCoin && (
                    (game.getOpponentTeam().getToolBox().hasTool(purchasing.getToolType(), purchasing.getToolStrength()))
                    || game.getGameToolBox().hasTool(purchasing.getToolType(), purchasing.getToolStrength())));
        } else {
            //if coin is silver, they can only purchase from the game toolbox
            return (isValidCoin && game.getGameToolBox().hasTool(purchasing.getToolType(), purchasing.getToolStrength()));
        }
    }

    /**
     * removes a tool from one toolbox and adds the tool to another toolbox
     * @param exchanged -- the Tool that is being exchanged
     * @param removedFrom -- the tool box that the tool will be removed from
     * @param addedTo -- the tool box to which the tool will be added to
     */
    public void exchangeTool(Tool exchanged, ToolBox removedFrom, ToolBox addedTo) {
        removedFrom.removeTool(exchanged.getToolType(), exchanged.getToolStrength());
        addedTo.addTool(exchanged);
    }

    /**
     * when current team uses a coin to purchase a tool
     * @param coin -- the coin that is being used to purchase another Tool
     * @param purchasing -- The tool that is being purchased
     */
    public void performToolPurchase(Tool coin, Tool purchasing) {
        /*if the coin is gold and the opponent has the tool, the tool should be purchased from their
        tool box. otherwise, it should be from the game. give coin to whatever team we bought from*/
        if ((coin.getToolStrength()==Tool.STRENGTH.GOLD) &&
                game.getOpponentTeam().getToolBox().hasTool(purchasing.getToolType(), purchasing.getToolStrength())) {
            exchangeTool(coin, game.getCurrentTeam().getToolBox(), game.getOpponentTeam().getToolBox());
            exchangeTool(purchasing, game.getOpponentTeam().getToolBox(), game.getCurrentTeam().getToolBox());
        } else {
            exchangeTool(coin, game.getCurrentTeam().getToolBox(), game.getGameToolBox());
            exchangeTool(purchasing, game.getGameToolBox(), game.getCurrentTeam().getToolBox());
        }

        game.changeTurn(); //change turn after purchase complete
    }


}
