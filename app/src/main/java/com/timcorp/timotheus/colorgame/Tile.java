package com.timcorp.timotheus.colorgame;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by tgelner on 1/6/2016.
 */
public class Tile {
    public boolean selected;
    public int x;
    public int y;
    public GlobalValues.Colors color;
    public ImageView image;
    public Tile(int X, int Y)
    {
        this.x = X;
        this.y = Y;
        if(this.x==0 && this.y == 0)
            this.selected = true;
        else
            this.selected = false;
    }
    public void changeColor(GlobalValues.Colors color)
    {
        this.color = color;
        this.image.setImageResource(Utilities.getImageColor(color));
    }
    @Override
    public String toString()
    {
        return "(" + this.x + "," + this.y + ") " + this.color + " " + this.selected;
    }
}
