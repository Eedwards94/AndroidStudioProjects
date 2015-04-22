package com.example.eric.cyblood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class VolunteerSubmit extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_submit);

        Intent intent = getIntent();

        TextView volunteerDate2 = (TextView) findViewById(R.id.volunteeringDate);
        TextView volunteerTime2 = (TextView) findViewById(R.id.volunteeringTime);
        //Get the bundle
        Bundle bundle = intent.getExtras();

        //Extract the data…
        String day = bundle.getString("Date");
        String time = bundle.getString("Time");

        volunteerDate2.setText(day);
        volunteerTime2.setText(time);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_volunteer_submit, menu);
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
