package com.example.eric.cyblood;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;


public class Committees extends ActionBarActivity {

    TextView academics;
    TextView design;
    TextView fundraising;
    TextView offCampus;
    TextView onCampus;
    TextView publicRelations;
    TextView sponsorship;
    TextView volunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_committees);

        academics = (TextView) findViewById(R.id.Academics);
        design = (TextView) findViewById(R.id.Design);
        fundraising = (TextView) findViewById(R.id.Fundraising);
        offCampus = (TextView) findViewById(R.id.OffCampus);
        onCampus = (TextView) findViewById(R.id.OnCampus);
        publicRelations = (TextView) findViewById(R.id.PublicRelations);
        sponsorship = (TextView) findViewById(R.id.Sponsorship);
        volunteer = (TextView) findViewById(R.id.Volunteer);
        Spinner committees = (Spinner) findViewById(R.id.Committees);

        committees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        if(selected.equals("Select")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }
        if(selected.equals("Academics")){
            academics.setTextColor(Color.parseColor("#CC2233"));
            academics.bringToFront();
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }
        if(selected.equals("Design")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#CC2233"));
            design.bringToFront();
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }

        if(selected.equals("Fundraising")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#CC2233"));
            fundraising.bringToFront();
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }

        if(selected.equals("Off-Campus")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#CC2233"));
            offCampus.bringToFront();
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }

        if(selected.equals("On-Campus")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#CC2233"));
            onCampus.bringToFront();
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }

        if(selected.equals("Public Relations")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#CC2233"));
            publicRelations.bringToFront();
        }

        if(selected.equals("Sponsorship")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#CC2233"));
            sponsorship.bringToFront();
            volunteer.setTextColor(Color.parseColor("#FFD700"));
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }

        if(selected.equals("Volunteer")){
            academics.setTextColor(Color.parseColor("#FFD700"));
            design.setTextColor(Color.parseColor("#FFD700"));
            fundraising.setTextColor(Color.parseColor("#FFD700"));
            onCampus.setTextColor(Color.parseColor("#FFD700"));
            offCampus.setTextColor(Color.parseColor("#FFD700"));
            sponsorship.setTextColor(Color.parseColor("#FFD700"));
            volunteer.setTextColor(Color.parseColor("#CC2233"));
            volunteer.bringToFront();
            publicRelations.setTextColor(Color.parseColor("#FFD700"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_committees, menu);
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
