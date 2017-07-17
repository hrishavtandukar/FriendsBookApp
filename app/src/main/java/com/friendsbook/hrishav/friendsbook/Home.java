package com.friendsbook.hrishav.friendsbook;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    TextView userMessage;

    Button  profile;
    Button friends;
    Button help;
    Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userMessage =(TextView)findViewById(R.id.hiMessages);
        Intent i = getIntent();
        String user=i.getStringExtra("user");
        userMessage.setText("Hi, " + user);

        profile = (Button)findViewById(R.id.profileButton);
        friends = (Button)findViewById(R.id.viewFriendsButton);
        help = (Button)findViewById(R.id.helpButton);
        exit = (Button)findViewById(R.id.exitButton);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileActivity = new Intent(Home.this,Profile.class);

                Intent i = getIntent();
                String user=i.getStringExtra("user");
                profileActivity.putExtra("user",user);

                startActivity(profileActivity);

            }
        });

        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileActivity = new Intent(Home.this,Friends.class);
                startActivity(profileActivity);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileActivity = new Intent(Home.this,Help.class);
                startActivity(profileActivity);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFinishing()){
                    new AlertDialog.Builder(Home.this)
                            .setTitle("Close The App")
                            .setMessage("Thank you for using this app!!!")
                            .setCancelable(true)
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            }).show();
                }
            }
        });

    }
}
