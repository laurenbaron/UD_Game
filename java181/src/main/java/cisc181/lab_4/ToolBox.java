package cisc181.lab_4;

import java.util.ArrayList;

/**
 * Swetha Sankar & Lauren Baron
 * CISC 181-080
 * Final Project
 * 5/18/20
 * ToolBox Class
 */
public class ToolBox {

    public final int MAX_NUM_TOOLS = 12; //max number of tools a toolbox can hold
    private ArrayList<Tool> toolSet; //array of Tool objects

    /**
     * constructor with one parameter that creates the array of tool objects that can store no
     * more than the max number allowed
     * @param isGame -- represents whether this is a game toolbox(true) or a team's toolbox(false)
     */
    public ToolBox(boolean isGame) {
        toolSet=new ArrayList<Tool>();
        if (isGame) {
            setUpToolBox();
        }
    }

    /**
     * sets up the game's tool box with all the given tools
     */
    public void setUpToolBox() {
        toolSet.add(new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER));
        toolSet.add(new Tool(Tool.ITEM.MIRROR, Tool.STRENGTH.GOLD));
        toolSet.add(new Tool(Tool.ITEM.MIRROR, Tool.STRENGTH.SILVER));
    }

    /**
     * whether or not whether or not this tool is in the toolbox
     * @param item -- the type of tool we are checking for
     * @param strength -- the strength of the tool we are checking for
     * @return boolean -- if the tool is in the toolbox
     */
    public boolean hasTool(Tool.ITEM item, Tool.STRENGTH strength) {
        for (Tool myTool:toolSet) {
            if ( (myTool!=null) && (myTool.getToolType()==item) && (myTool.getToolStrength()==strength)) {
                return true;
            }
        }
        return false;
    }

    /**
     * remove and return the Tool object from the toolset if it is in the toolSet
     * @param item -- the item of the tool we want to remove
     * @param strength -- the strength of the tool we want to remove
     * @return Tool -- the tool you removed from the ArrayList
     */
    public Tool removeTool(Tool.ITEM item, Tool.STRENGTH strength) {
        for (int i=0; i<toolSet.size(); i++) {
            if ((getTool(i).getToolType()==item) && (getTool(i).getToolStrength()==strength)) {
                Tool found=getTool(i);
                toolSet.remove(getTool(i));
                return found;
            }
        }
        return null; //if tool isn't in the array list
    }

    /**
     * adds a given tool to the toolset
     * @param newTool -- the tool to add to the toolset
     */
    public void addTool(Tool newTool) {
        toolSet.add(newTool);
    }

    /**
     * getter/accessor for a Tool in the toolSet
     * @param index -- the index/location of the toolbox array to get the Tool from
     * @return Tool -- the tool at the given index
     */
    public Tool getTool(int index) {
        //make sure the index is in the bounds of the array
        if(index<MAX_NUM_TOOLS) {
            return toolSet.get(index);
        } else {
            return null;
        }
    }

    /**
     * the string representation of a Tool Box
     * @return -- String each tool in the tool set and its description
     */
    @Override
    public String toString() {
        StringBuilder toolBoxString = new StringBuilder(""); //use a StringBuilder to create the string
        for (Tool myTool : toolSet) {
            if(myTool!=null) {
                toolBoxString.append(myTool + " : " + myTool.getDescription() + "\n");
            }
        }
        return toolBoxString.toString();
    }

    /**
     * accessor method for toolSet
     * @return ArrayList<Tool> -- the toolSet
     */
    public ArrayList<Tool> getToolSet() {
        return toolSet;
    }
}
