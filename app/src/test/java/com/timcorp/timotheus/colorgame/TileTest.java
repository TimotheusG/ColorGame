package com.timcorp.timotheus.colorgame;

import android.app.Activity;
import android.widget.ImageView;

import com.timcorp.timotheus.colorgame.GlobalValues.Colors;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tgelner on 1/8/2016.
 */
public class TileTest {
    @Test
    public void colorTest() throws Exception {
        Activity a = new MainActivity();
        Tile t = new Tile(1, 1);
        t.image = new ImageView(a);
        t.changeColor(Colors.green);
        System.out.print("Test");
        assertEquals(Colors.green, t.color);
    }
}