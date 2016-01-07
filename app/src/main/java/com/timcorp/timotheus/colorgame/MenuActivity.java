package com.timcorp.timotheus.colorgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void difClick(View view) {
        switch (view.getId()) {
            case R.id.Easy:
                //Toast.makeText(this, "Clicked on Easy", Toast.LENGTH_LONG).show();
                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
