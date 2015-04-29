package com.example.eric.cyblood;

import android.content.Intent;
import android.graphics.Color;
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
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class DonorSubmit extends ActionBarActivity {

    TextView date2;
    TextView time2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_submit);
        final Button finalSubmit = (Button) findViewById(R.id.finalSubmit);

        Intent intent = getIntent();

        date2 = (TextView) findViewById(R.id.Date2);
        time2 = (TextView) findViewById(R.id.Time2);
        //Get the bundle
        Bundle bundle = intent.getExtras();

        //Extract the data…
        String day = bundle.getString("Date");
        String time = bundle.getString("Time");

        date2.setText(day);
        time2.setText(time);

      //  TextView dateTime = new TextView(R.id.day);


        finalSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread() {
                    @Override
                    public void run() {
                        Socket clientSocket = null;
                        try {
                            clientSocket = new Socket("10.26.48.33", 8000);
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donor_submit, menu);
        return true;
    }

    public String messageToSocket(){
        String toSocket = "insertData;DonorInfo;";
        String date = date2.getText().toString();
        String time = time2.getText().toString();

        if(time.contains("p.m.")){
            time = time.substring(0,4);
        }
        if(time.contains("a.m.")){
            time = time.substring(0,5);
        }
        TextView emailText = (TextView) findViewById(R.id.editText2);

        String email = emailText.getText().toString();
        //"insertData;DonorInfo;'erice1@iastate.edu','2015-03-24 11:00:00';' ';' '"
        toSocket = toSocket + "'" + email + "','" + date + " " + time + ":00';' ';' '";

        return toSocket;
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
