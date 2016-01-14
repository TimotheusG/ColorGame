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

import java.util.List;
import java.util.Random;

/**
 * Created by tgelner on 1/11/2016.
 */
public class UI {
    public static MainActivity mainActivity;
    public static GridLayout gridLayout;
    public static Field field = new Field();
    public static void UpdateColor(View view) {
        GlobalValues.moves++;
        TextView tv = (TextView)mainActivity.findViewById(R.id.moves);
        tv.setText("Moves: " + GlobalValues.moves);
        for (Tile t : field.getSelectedList()) {
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
        //update all new selected
        for (Tile t : field.getSelectedList()) {
            t.changeColor(GlobalValues.Colors.selected);
            t.image.setImageResource(Utilities.getImageColor(GlobalValues.Colors.selected));
        }
        if(Utilities.won(Field.tiles)) {
            Toast.makeText(mainActivity, "You won in " + GlobalValues.moves + " moves!",
                    Toast.LENGTH_SHORT).show();
            Utilities.resetStage();
            Intent intent = mainActivity.getIntent();
            mainActivity.finish();
            mainActivity.startActivity(intent);
        }
    }

    public static void init(Activity th) {
        gridLayout.removeAllViews();

        field.init();
        int total = GlobalValues.total;
        int column = GlobalValues.column;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for (Tile t : field.tiles)
        {
            ImageView oImageView = new ImageView(th);
            //GlobalValues.Colors randColor = GlobalValues.Colors.values()[rand3];
            switch (t.color)
            {
                case red:
                    oImageView.setImageResource(R.drawable.red);
                    break;
                case green:
                    oImageView.setImageResource(R.drawable.green);
                    break;
                case blue:
                    oImageView.setImageResource(R.drawable.blue);
                    break;
                case selected:
                    oImageView.setImageResource(R.drawable.selected);
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
            param.columnSpec = GridLayout.spec(t.x);
            param.rowSpec = GridLayout.spec(t.y);
            oImageView.setLayoutParams(param);
            gridLayout.addView(oImageView);
            t.image = oImageView;
        }

        //set first tile and all same color tiles to selected
        for (Tile t : Field.tiles) {
            if (t.selected) {
                Field.evalTile(t, t.color);
            }
        }
    }
}
