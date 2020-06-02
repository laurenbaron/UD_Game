package cisc181.lab_4;

import org.junit.Test;

import static org.junit.Assert.*;

public class ToolTest {

    @Test
    public void testingTool() {
        Tool tool;

        System.out.println("Testing Tool Class");

        tool = new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.SILVER);
        assertEquals(tool.getToolType(), Tool.ITEM.CLOAK);
        assertEquals(tool.getToolStrength(), Tool.STRENGTH.SILVER);
        assertEquals(tool.toString().toLowerCase(), "silver cloak");
        assertEquals(tool.getDescription(), "Hide one of your own team's pieces");

        tool = new Tool(Tool.ITEM.CLOAK, Tool.STRENGTH.GOLD);
        assertEquals(tool.getToolType(), Tool.ITEM.CLOAK);
        assertEquals(tool.getToolStrength(), Tool.STRENGTH.GOLD);
        assertEquals(tool.toString().toLowerCase(), "gold cloak");
        assertEquals(tool.getDescription(), "Unidentified tool");

        tool = new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.SILVER);
        assertEquals(tool.getToolType(), Tool.ITEM.GLASSES);
        assertEquals(tool.getToolStrength(), Tool.STRENGTH.SILVER);
        assertEquals(tool.toString().toLowerCase(), "silver glasses");
        assertEquals(tool.getDescription(), "Unhide one of the other team's pieces");

        tool = new Tool(Tool.ITEM.GLASSES, Tool.STRENGTH.GOLD);
        assertEquals(tool.getToolType(), Tool.ITEM.GLASSES);
        assertEquals(tool.getToolStrength(), Tool.STRENGTH.GOLD);
        assertEquals(tool.toString().toLowerCase(), "gold glasses");
        assertEquals(tool.getDescription(), "Unhide all of the other team's pieces");

        tool = new Tool(Tool.ITEM.COIN, Tool.STRENGTH.SILVER);
        assertEquals(tool.getToolType(), Tool.ITEM.COIN);
        assertEquals(tool.getToolStrength(), Tool.STRENGTH.SILVER);
        assertEquals(tool.toString().toLowerCase(), "silver coin");
        assertEquals(tool.getDescription(), "Buy any tool from the game's toolbox");

        tool = new Tool(Tool.ITEM.COIN, Tool.STRENGTH.GOLD);
        assertEquals(tool.getToolType(), Tool.ITEM.COIN);
        assertEquals(tool.getToolStrength(), Tool.STRENGTH.GOLD);
        assertEquals(tool.toString().toLowerCase(), "gold coin");
        assertEquals(tool.getDescription(), "Trade for any tool in the game");

    }


}