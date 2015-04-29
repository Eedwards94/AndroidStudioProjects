package com.example.eric.cyblood;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ContactUs extends ActionBarActivity {
    TextView email;
    TextView subject;
    TextView name;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);

        Spinner tabs = (Spinner) findViewById(R.id.tabs);
        Button contact = (Button) findViewById(R.id.contactButton);

        tabs.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String itemSelectedInSpinner =
                        parent.getItemAtPosition(position).toString();
                handleSpinner(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        contact.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {

        email = (TextView) findViewById(R.id.emailOfSender);
        subject = (TextView) findViewById(R.id.subject);
        text = (TextView) findViewById(R.id.message);
        name = (TextView) findViewById(R.id.sender);

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType(("text/plain"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{"erice1@iastate.edu"});
        i.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
        i.putExtra(Intent.EXTRA_TEXT, "From: " + name.getText().toString() + "\n(" + email.getText().toString() + ")"+ "\n\n" + text.getText().toString());
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (ActivityNotFoundException ex){
            Toast.makeText(ContactUs.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
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
        getMenuInflater().inflate(R.menu.menu_contact_us, menu);
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
