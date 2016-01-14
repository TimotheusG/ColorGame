package com.timcorp.timotheus.colorgame;

import com.timcorp.timotheus.colorgame.GlobalValues.Colors;

import junit.framework.TestCase;

import static com.timcorp.timotheus.colorgame.GlobalValues.Colors.*;

/**
 * Created by tgelner on 1/8/2016.
 */
public class TileTest extends TestCase {
    public void colorTest()
    {
        Tile t = new Tile(0,0);
        t.color = Colors.red;
        t.changeColor(Colors.green);
        assertEquals(Colors.green, t.color);
    }
}