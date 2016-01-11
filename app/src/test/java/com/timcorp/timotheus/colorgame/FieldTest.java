package com.timcorp.timotheus.colorgame;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;

import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.Assert.*;
public class FieldTest {
    @Test
    public void gameTest() throws Exception
    {
        com.timcorp.timotheus.colorgame.Field field = new com.timcorp.timotheus.colorgame.Field();
        while(!Utilities.won(field.tiles))
        {
            System.out.println("Started");
        }

        assertEquals(true, true);
    }
}