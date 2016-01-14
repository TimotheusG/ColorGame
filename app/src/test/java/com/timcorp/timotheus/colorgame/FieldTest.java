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
        com.timcorp.timotheus.colorgame.Field field = new com.timcorp.timotheus.colorgame.Field();
        field.init();
        System.out.println(field.ToString());
        Random rand = new Random();
        int i = 0;
        while (!Utilities.won(field.tiles)) {
            int rand3 = rand.nextInt(GlobalValues.numberOfColors) + 1;
            i++;
            //GlobalValues.Colors randColor = GlobalValues.Colors.values()[rand3];
            switch (rand3) {
                case 1:
                    System.out.println("Red");
                    for (Tile t : field.getSelectedList()) {
                        field.evalNeighbors(t, GlobalValues.Colors.red);
                    }
                    break;
                case 2:
                    System.out.println("Green");
                    for (Tile t : field.getSelectedList()) {
                        field.evalNeighbors(t, GlobalValues.Colors.green);
                    }
                    break;
                case 3:
                    System.out.println("Blue");
                    for (Tile t : field.getSelectedList()) {
                        field.evalNeighbors(t, GlobalValues.Colors.blue);
                    }
                    break;
                default:
                    break;
            }
            System.out.println(field.ToString());
            System.out.println(i);
        }

        assertEquals(true, true);
    }
}