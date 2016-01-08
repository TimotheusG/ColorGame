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
    public GridLayout gridLayout;
    public static List<Tile> tiles = new ArrayList<Tile>();
    public static MainActivity mainActivity;

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

    public void init(Activity th) {
        gridLayout.removeAllViews();
        List<Tile> tiles = Field.tiles;
        int total = GlobalValues.total;
        int column = GlobalValues.column;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++)
        {
            if(c == column)
            {
                c = 0;
                r++;
            }
            Tile t = new Tile(c, r);
            ImageView oImageView = new ImageView(th);
            Random rand = new Random();
            int rand3 = rand.nextInt(GlobalValues.numberOfColors) + 1;
            //GlobalValues.Colors randColor = GlobalValues.Colors.values()[rand3];
            switch (rand3)
            {
                case 1:
                    t.color = GlobalValues.Colors.red;
                    oImageView.setImageResource(R.drawable.red);
                    break;
                case 2:
                    t.color = GlobalValues.Colors.green;
                    oImageView.setImageResource(R.drawable.green);
                    break;
                case 3:
                    t.color = GlobalValues.Colors.blue;
                    oImageView.setImageResource(R.drawable.blue);
                    break;
                default:
                    break;
            }

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();
            param.height = GridLayout.LayoutParams.WRAP_CONTENT;
            param.width = GridLayout.LayoutParams.WRAP_CONTENT;
            //param.rightMargin = 5;
            //param.topMargin = 5;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec = GridLayout.spec(r);
            oImageView.setLayoutParams(param);
            gridLayout.addView(oImageView);
            t.image = oImageView;
            tiles.add(t);
        }
        for(Tile t : Field.tiles)
            Log.d("MyApp", t.toString());

        //set first tile and all same color tiles to selected
        for (Tile t : Field.tiles) {
            if (t.selected) {
                Field.evalTile(t, t.color);
            }
        }
    }


    public static void UpdateColor(View view) {
        GlobalValues.moves++;
        TextView tv = (TextView)mainActivity.findViewById(R.id.moves);
        tv.setText("Moves: " + GlobalValues.moves);
        for (Tile t : Field.tiles) {
            if (t.selected) {
                t.changeColor(GlobalValues.Colors.selected);
                switch (view.getId()) {
                    case R.id.Red:
                        Field.evalNeighbors(t, GlobalValues.Colors.red);
                        break;
                    case R.id.Green:
                        Field.evalNeighbors(t, GlobalValues.Colors.green);
                        break;
                    case R.id.Blue:
                        Field.evalNeighbors(t, GlobalValues.Colors.blue);
                        break;
                }
            }
        }
//        for (Tile a : Field.tiles) {
//            if (a.selected)
//                Log.d("MyApp", a.toString());
//        }
//        Log.d("MyApp", "End");
        if(Utilities.won(Field.tiles)) {
            Toast.makeText(mainActivity, "You won in " + GlobalValues.moves + " moves!",
                    Toast.LENGTH_SHORT).show();
            Utilities.resetStage();
            Intent intent = mainActivity.getIntent();
            mainActivity.finish();
            mainActivity.startActivity(intent);
        }
    }
}
