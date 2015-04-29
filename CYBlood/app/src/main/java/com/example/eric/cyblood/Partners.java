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


public class Partners extends ActionBarActivity {

    TextView ARC;
    TextView LS;
    TextView MVRBC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partners);
        ARC = (TextView) findViewById(R.id.ARC);
        LS = (TextView) findViewById(R.id.LS);
        MVRBC = (TextView) findViewById(R.id.MVRBC);
        Spinner partners = (Spinner) findViewById(R.id.partners);

        partners.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    public void handleSpinner(String selected){
        if(selected.equals("American Red Cross")){
            ARC.setTextColor(Color.parseColor("#CC2233"));
            ARC.bringToFront();
            LS.setTextColor(Color.parseColor("#FFD700"));
            MVRBC.setTextColor(Color.parseColor("#FFD700"));
        }
        if(selected.equals("Life Serve")){
            ARC.setTextColor(Color.parseColor("#FFD700"));
            LS.setTextColor(Color.parseColor("#CC2233"));
            LS.bringToFront();
            MVRBC.setTextColor(Color.parseColor("#FFD700"));
        }
        if(selected.equals("Mississippi Valley Regional Blood Center")){
            ARC.setTextColor(Color.parseColor("#FFD700"));
            LS.setTextColor(Color.parseColor("#FFD700"));
            MVRBC.setTextColor(Color.parseColor("#CC2233"));
            MVRBC.bringToFront();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_partners, menu);
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
