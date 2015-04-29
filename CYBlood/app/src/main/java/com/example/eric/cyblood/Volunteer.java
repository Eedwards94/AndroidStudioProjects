package com.example.eric.cyblood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;


public class Volunteer extends ActionBarActivity {

    String volunteerDay = null;
    String volunteerTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_volunteer);
        final Button submit = (Button) findViewById(R.id.Submit2);
        Spinner pages2 = (Spinner) findViewById(R.id.Pages2);
        Spinner date2 = (Spinner) findViewById(R.id.VolunteerDay);
        Spinner time2 = (Spinner) findViewById(R.id.VolunteerTime);

        final Intent i2 = new Intent(this, VolunteerSubmit.class);

        date2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                volunteerDay = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        time2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                volunteerTime = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        pages2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner2 =
                        parent.getItemAtPosition(position).toString();
                handleSpinner(itemSelectedInSpinner2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//Create the bundle
                Bundle bundle2 = new Bundle();
//Add your data to bundle
                if (volunteerDay != "" || volunteerDay != null)
                    bundle2.putString("VolunteerDate", volunteerDay);
                if (volunteerTime != "" || volunteerTime != null)
                    bundle2.putString("VolunteerTime", volunteerTime);
//Add the bundle to the intent
                i2.putExtras(bundle2);
                startActivity(i2);
            }
        });
    }



    public void handleSpinner(String selected){
        if(selected.equals("Select")){

        }
        if(selected.equals("Home")){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        if(selected.equals("Donate")){
            startActivity(new Intent(getApplicationContext(), Donors.class));
        }

        if(selected.equals("Volunteer")){
            startActivity(new Intent(getApplicationContext(), Volunteer.class));
        }

        if(selected.equals("Contact Us")){
            startActivity(new Intent(getApplicationContext(), ContactUs.class));
        }

        if(selected.equals("Get More Info")){
            startActivity(new Intent(getApplicationContext(), LearnMore.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_volunteer, menu);
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
