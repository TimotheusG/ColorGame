package com.timcorp.timotheus.colorgame;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Random;

import static org.junit.Assert.*;
public class FieldTest {
    @Test
    public void gameTest() throws Exception
    {
        int best = 1000;
        for (int i = 0; i < 100; i++) {
            int moves = 0;
            com.timcorp.timotheus.colorgame.Field field = new com.timcorp.timotheus.colorgame.Field();
            field.init(
                    "b r g r g b r g b r \n" +
                            "r r g r g b r g b r \n" +
                            "g g g r g b r g b r \n" +
                            "r r r r g b r g b r \n" +
                            "g g g g g b r g b r \n" +
                            "b b b b b b r g b r \n" +
                            "r r r r r r r g b r \n" +
                            "g g g g g g g g b r \n" +
                            "b b b b b b b b b r \n" +
                            "r r r r r r r r r r ");
            //System.out.println(field.ToString());
            Random rand = new Random();
            int previousRand = 0;
            int rand3 = 0;
            while (!Utilities.won(field.tiles)) {
                while (rand3 == previousRand)//so it doesn't click the same color twice
                {
                    rand3 = rand.nextInt(GlobalValues.numberOfColors) + 1;
                }
                previousRand = rand3;
                moves++;
                //GlobalValues.Colors randColor = GlobalValues.Colors.values()[rand3];
                switch (rand3) {
                    case 1:
                        //System.out.println("Red");
                        for (Tile t : field.getSelectedList()) {
                            field.evalNeighbors(t, GlobalValues.Colors.red);
                        }
                        break;
                    case 2:
                        //System.out.println("Green");
                        for (Tile t : field.getSelectedList()) {
                            field.evalNeighbors(t, GlobalValues.Colors.green);
                        }
                        break;
                    case 3:
                        //System.out.println("Blue");
                        for (Tile t : field.getSelectedList()) {
                            field.evalNeighbors(t, GlobalValues.Colors.blue);
                        }
                        break;
                    case 4:
                        //System.out.println("Yellow");
                        for (Tile t : field.getSelectedList()) {
                            field.evalNeighbors(t, GlobalValues.Colors.yellow);
                        }
                        break;
                    case 5:
                        //System.out.println("Purple");
                        for (Tile t : field.getSelectedList()) {
                            field.evalNeighbors(t, GlobalValues.Colors.purple);
                        }
                        break;
                    case 6:
                        //System.out.println("Cyan");
                        for (Tile t : field.getSelectedList()) {
                            field.evalNeighbors(t, GlobalValues.Colors.cyan);
                        }
                        break;
                    default:
                        break;
                }
                //System.out.println(field.ToString());
            }
            //System.out.println(moves);
            if (moves < best)
                best = moves;
            Utilities.resetStage();
        }
        System.out.println("Best: " + best);
        assertEquals(true, true);
    }
}