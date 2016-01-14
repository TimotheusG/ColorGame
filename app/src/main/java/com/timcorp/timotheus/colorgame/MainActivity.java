package com.timcorp.timotheus.colorgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout gridLayout = (GridLayout) findViewById(R.id.gridTable);
        UI.gridLayout = gridLayout;
        UI.mainActivity = this;
        UI.init(this);

        TextView tv = (TextView)findViewById(R.id.best);
        tv.setText("Best: " + GlobalValues.best);
    }

    public void colorClick(View view) {
        UI.UpdateColor(view);
    }
}
