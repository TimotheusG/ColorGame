package com.timcorp.timotheus.colorgame;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by tgelner on 1/8/2016.
 */
public class Field {
    public static List<Tile> tiles = new ArrayList<Tile>();


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
        Tile e = getTile(tile.x + 1, tile.y);
        if(e != null)
            if(!e.selected)
                evalTile(e, color);
    }

    public static Tile getTile(int X, int Y)
    {
        for(Tile t : tiles) {
            if (t.x == X && t.y == Y)
                return t;
        }
        return null;
    }

    public static void evalTile(Tile tile, GlobalValues.Colors color) {
        if(tile.color == color) {
            tile.selected = true;
            tile.changeColor(GlobalValues.Colors.selected);
            evalNeighbors(tile, color);

        }
    }


}
