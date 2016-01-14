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

    public static void init() {
        List<Tile> tiles = Field.tiles;
        int total = GlobalValues.total;
        int column = GlobalValues.column;
        int row = total / column;
        for (int i = 0, c = 0, r = 0; i < total; i++, c++) {
            if (c == column) {
                c = 0;
                r++;
            }
            Tile t = new Tile(c, r);
            Random rand = new Random();
            int rand3 = rand.nextInt(GlobalValues.numberOfColors) + 1;
            //GlobalValues.Colors randColor = GlobalValues.Colors.values()[rand3];
            switch (rand3) {
                case 1:
                    t.color = GlobalValues.Colors.red;
                    break;
                case 2:
                    t.color = GlobalValues.Colors.green;
                    break;
                case 3:
                    t.color = GlobalValues.Colors.blue;
                    break;
                case 4:
                    t.color = GlobalValues.Colors.yellow;
                    break;
                case 5:
                    t.color = GlobalValues.Colors.purple;
                    break;
                case 6:
                    t.color = GlobalValues.Colors.cyan;
                    break;
                default:
                    break;
            }
            tiles.add(t);
        }
        //set first tile and all same color tiles to selected
        for (Tile t : Field.tiles) {
            if (t.selected) {
                Field.evalTile(t, t.color);
            }
        }
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

    public String ToString() //change to real string later
    {
        String s = new String();
        for (Tile t : Field.tiles) {
            s += t.color.toString().substring(0, 1) + " ";
            if (t.x == GlobalValues.column - 1)
                s += "\n";
        }
        return s;
    }

    public List<Tile> getSelectedList() {
        ArrayList<Tile> l = new ArrayList<Tile>();
        for (Tile t : Field.tiles) {
            if (t.selected)
                l.add(t);
        }
        return l;
    }


}
