package com.timcorp.timotheus.colorgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridTable);

        gridLayout.removeAllViews();
        TextView tv = (TextView)findViewById(R.id.best);
        tv.setText("Best: " + GlobalValues.best);
        List<Tile> tiles = GlobalValues.tiles;

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
            ImageView oImageView = new ImageView(this);
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
                    Toast.makeText(this, "Wrong Number", Toast.LENGTH_LONG).show();
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
        for(Tile t : GlobalValues.tiles)
            Log.d("MyApp", t.toString());

        //set first tile and all same color tiles to selected
        for (Tile t : GlobalValues.tiles) {
            if (t.selected) {
                Utilities.evalTile(t, t.color);
            }
        }
    }

    public void colorClick(View view) {
        GlobalValues.moves++;
        TextView tv = (TextView)findViewById(R.id.moves);
        tv.setText("Moves: " + GlobalValues.moves);
        for (Tile t : GlobalValues.tiles) {
            if (t.selected) {
                t.changeColor(GlobalValues.Colors.selected);
                switch (view.getId()) {
                    case R.id.Red:
                        Utilities.evalNeighbors(t, GlobalValues.Colors.red);
                        break;
                    case R.id.Green:
                        Utilities.evalNeighbors(t, GlobalValues.Colors.green);
                        break;
                    case R.id.Blue:
                        Utilities.evalNeighbors(t, GlobalValues.Colors.blue);
                        break;
                }
            }
        }
        for (Tile a : GlobalValues.tiles) {
            if (a.selected)
                Log.d("MyApp", a.toString());
        }
        Log.d("MyApp", "End");
        if(Utilities.won(GlobalValues.tiles)) {
            Toast.makeText(this, "You won in " + GlobalValues.moves + " moves!",
                    Toast.LENGTH_SHORT).show();
            Utilities.resetStage();
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }
    }


}
