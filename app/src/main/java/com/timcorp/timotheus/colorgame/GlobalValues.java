package com.timcorp.timotheus.colorgame;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tgelner on 1/6/2016.
 */
public class GlobalValues {
    public enum Colors{red, green, blue, selected}
    public final static int numberOfColors = 3;
    public final static int total = 100;
    public final static int column = 10;
    public static List<Tile> tiles = new ArrayList<Tile>();
    public static int moves = 0;
    public static int best = 10;
}
