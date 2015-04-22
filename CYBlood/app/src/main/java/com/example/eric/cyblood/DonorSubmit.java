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

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.UnknownHostException;


public class DonorSubmit extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_submit);
        final Button finalSubmit = (Button) findViewById(R.id.finalSubmit);

        Intent intent = getIntent();

        TextView date2 = (TextView) findViewById(R.id.Date2);
        TextView time2 = (TextView) findViewById(R.id.Time2);
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
                ServerSocket serverSocket = null;
                try {
                    serverSocket = new ServerSocket(8000);

                } catch (IOException e) {
                    System.out.println("Could not listen on port: 4001");
                    System.out.println(e.getMessage());

                    System.exit(-1);
                }

                while (true) {

                    Socket clientSocket = null;
                    try {
                        clientSocket = serverSocket.accept();
                        finalSubmit.setTextColor(Color.RED);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_donor_submit, menu);
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
