package cisc181.lab_4;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * Tool Class
 */
public class Tool {

    public enum ITEM {CLOAK, GLASSES, COIN, MIRROR};
    public enum STRENGTH {GOLD, SILVER};

    private ITEM toolType;
    private STRENGTH toolStrength;

    /**
     * constructor with two parameters
     * @param toolType -- the type of tool
     * @param toolStrength -- the strength of the tool
     */
    public Tool(ITEM toolType, STRENGTH toolStrength) {
        this.toolType=toolType;
        this.toolStrength=toolStrength;
    }

    /**
     * accessor for toolType
     * @return ITEM -- the type of tool
     */
    public ITEM getToolType() {
        return toolType;
    }

    /**
     * accessor for toolStrength
     * @return STRENGTH -- the strength of the tool
     */
    public STRENGTH getToolStrength() {
        return toolStrength;
    }

    /**
     * accessor for the tool's description
     * @return String -- ta description of what the tool can do (based on strength too)
     */
    public String getDescription() {
        String description="";
        switch (toolType) {
            case CLOAK:
                if (toolStrength==STRENGTH.SILVER) {
                    description="Hide one of your own team's pieces";
                } else {
                    description="Unidentified tool";
                }
                break;
            case GLASSES:
                if (toolStrength==STRENGTH.GOLD) {
                    description= "Unhide all of the other team's pieces";
                } else {
                    /*toolStrength can only be Gold or Silver declared by the enumerated type,
                    so we can assume this is Silver because it's not gold
                    */
                    description= "Unhide one of the other team's pieces";
                }
                break;
            case MIRROR:
                if (toolStrength==STRENGTH.GOLD) {
                    description= "Duplicate your piece in a space you choose";
                } else {
                    description= "Duplicate your piece in a random empty space";
                }
                break;
            default:
                /*toolType can only be Cloak, Glasses, Mirror, or Coin declared by the enumerated type,
                 so we can assume this is Coin because its not Cloak nor Glasses
                 */
                if (toolStrength==STRENGTH.GOLD) {
                    description= "Trade for any tool in the game";
                } else {
                    description= "Buy any tool from the game's toolbox";
                }
                break;
        }
        return description;
    }

    /**
     * string representation of a tool
     * @return String -- tool's strength and type
     */
    @Override
    public String toString() {
        return getToolStrength() + " " + getToolType();

    }
}
