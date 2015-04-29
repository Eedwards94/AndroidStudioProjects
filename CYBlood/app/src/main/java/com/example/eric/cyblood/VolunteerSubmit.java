package com.example.eric.cyblood;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class VolunteerSubmit extends ActionBarActivity {

    TextView volunteerDate2;
    TextView volunteerTime2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_submit);
        final Button finalSubmit2 = (Button) findViewById(R.id.finalSubmit2);

        Intent intent = getIntent();

        volunteerDate2 = (TextView) findViewById(R.id.volunteeringDate);
        volunteerTime2 = (TextView) findViewById(R.id.volunteeringTime);
        //Get the bundle
        Bundle bundle = intent.getExtras();

        //Extract the data…
        String day = bundle.getString("VolunteerDate");
        String time = bundle.getString("VolunteerTime");

        volunteerDate2.setText(day);
        volunteerTime2.setText(time);

        finalSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {
                    @Override
                    public void run() {
                        Socket clientSocket = null;
                        try {
                            clientSocket = new Socket("10.25.48.33", 8000);
                            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                            out.println(messageToSocket());
                            out.flush();
                            br.readLine();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            clientSocket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });

    }

    public String messageToSocket(){
        String toSocket = "insertData;VolunteerInfo;'";
        //"insertData;VolunteerInfo;'erice1@iastate.edu','2015-03-24 11:00:00','American Red Cross';' ';' '"
        TextView emailText = (TextView) findViewById(R.id.volunteersEmail);
        String date = volunteerDate2.getText().toString();
        String time = volunteerTime2.getText().toString();

        if(time.contains("p.m.")){
            time = time.substring(0,4);
        }
        if(time.contains("a.m.")){
            time = time.substring(0,5);
        }

        String email = emailText.getText().toString();

        toSocket = toSocket + email + "','" + date + " " + time + ":00','American Red Cross';' ';' '";
        return toSocket;
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
