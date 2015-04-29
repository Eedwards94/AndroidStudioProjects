package com.example.eric.cyblood;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class GreekRules extends ActionBarActivity {

    TextView HC;
    TextView GW;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek_rules);
        HC = (TextView) findViewById(R.id.HC);
        GW = (TextView) findViewById(R.id.GW);
        Spinner greeks = (Spinner) findViewById(R.id.greeks);

        greeks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selected = parent.getItemAtPosition(position).toString();
                handleSpinner(selected);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void handleSpinner(String selected) {
        if (selected.equals("Greek Week")) {
            GW.setTextColor(Color.parseColor("#CC2233"));
            GW.bringToFront();
            HC.setTextColor(Color.parseColor("#FFD700"));
        }
        if (selected.equals("Homecoming")) {
            GW.setTextColor(Color.parseColor("#FFD700"));
            HC.setTextColor(Color.parseColor("#CC2233"));
            HC.bringToFront();
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_greek_rules, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
