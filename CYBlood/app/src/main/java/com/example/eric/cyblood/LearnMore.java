package com.example.eric.cyblood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;


public class LearnMore extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);
        Spinner select = (Spinner) findViewById(R.id.selector);
        Spinner pages = (Spinner) findViewById(R.id.pages);

        pages.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        select.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String whatToLearn = parent.getItemAtPosition(position).toString();
                learnAbout(whatToLearn);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

    public void learnAbout(String learning){
        if(learning.equals("Select")){

        }
        if(learning.equals("Committees")){
            startActivity(new Intent(getApplicationContext(), Committees.class));
        }
        if(learning.equals("Partners")){
            startActivity(new Intent(getApplicationContext(), Partners.class));
        }
        if(learning.equals("Greek Rules")){
            startActivity(new Intent(getApplicationContext(), GreekRules.class));
        }
        if(learning.equals("How to get involved")){
            startActivity(new Intent(getApplicationContext(), HowToGetInvolved.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_learn_more, menu);
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
