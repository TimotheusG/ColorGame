package com.timcorp.timotheus.colorgame;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgelner on 1/6/2016.
 */
public class Utilities {
    public static Tile getTile(int X, int Y)
    {
        for(Tile t : GlobalValues.tiles) {
            if (t.x == X && t.y == Y)
                return t;
        }
        return null;
    }

    public static void evalNeighbors(Tile tile, GlobalValues.Colors color) {
        //North
        Tile n = getTile(tile.x, tile.y - 1);
        if(n != null)
            if(!n.selected)
                evalTile(n, color);
        //South
        Tile s = getTile(tile.x, tile.y + 1);
        if(s != null)
            if(!s.selected)
                evalTile(s, color);
        //West
        Tile w = getTile(tile.x - 1, tile.y);
        if(w != null)
            if(!w.selected)
                evalTile(w, color);
        //East
        Tile e = getTile(tile.x +1, tile.y);
        if(e != null)
            if(!e.selected)
                evalTile(e, color);
    }

    public static void evalTile(Tile tile, GlobalValues.Colors color) {
        if(tile.color == color) {
            tile.selected = true;
            tile.changeColor(GlobalValues.Colors.selected);
            evalNeighbors(tile, color);

        }
    }

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
        GlobalValues.tiles =  new ArrayList<Tile>();

    }
}
