package com.timcorp.timotheus.colorgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgelner on 1/6/2016.
 */
public class Utilities {

    public static int getImageColor(GlobalValues.Colors color) {
        if(color == GlobalValues.Colors.red)
            return R.drawable.red;
        if(color == GlobalValues.Colors.green)
            return R.drawable.green;
        if(color == GlobalValues.Colors.blue)
            return R.drawable.blue;
        if(color == GlobalValues.Colors.selected)
            return R.drawable.selected;
        return R.drawable.green;//Replace later
    }

    public static boolean won (List<Tile> tiles) {
        for (Tile t : tiles) {
            if (!t.selected)
                return false;
        }
        return true;
    }
    public static void resetStage()
    {
        if(GlobalValues.best > GlobalValues.moves)
            GlobalValues.best = GlobalValues.moves;
        GlobalValues.moves = 0;
        Field.tiles =  new ArrayList<Tile>();
    }

    public static void clearStage() {
        GlobalValues.moves = 0;
        Field.tiles = new ArrayList<Tile>();
    }
}
