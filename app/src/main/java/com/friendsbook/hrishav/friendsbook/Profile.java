package com.friendsbook.hrishav.friendsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class Profile extends AppCompatActivity {

    Button backBtn;
    TextView profileName;
    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        backBtn = (Button)findViewById(R.id.backButton);

        profileName = (TextView) findViewById(R.id.ProfileName);
        Intent profileActivity = getIntent();
        String userName=profileActivity.getStringExtra("user");
        profileName.setText(userName);

        String[] numberArray = {"Mobile Number: 977-9843414370", "Phone Number: 01-4424647"};
        ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,numberArray);
        ListView listView = (ListView) findViewById(R.id.listViewProfile);
        listView.setAdapter(adapter);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
