package com.timcorp.timotheus.colorgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numberOfColors, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(1);
    }

    public void difClick(View view) {
        switch (view.getId()) {
            case R.id.Easy:
                Spinner spinner = (Spinner) findViewById(R.id.spinner);
                Intent i = new Intent(MenuActivity.this, MainActivity.class);
                i.putExtra("NUM_COLORS", spinner.getSelectedItem().toString());
                startActivity(i);
                break;
        }
    }
}
