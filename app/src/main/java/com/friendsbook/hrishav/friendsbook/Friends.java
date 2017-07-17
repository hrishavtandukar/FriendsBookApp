package com.friendsbook.hrishav.friendsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class Friends extends AppCompatActivity {

    Button ButtonBackFriends;

    ListView mListView;

    String[] friendNames = {"Ankit", "Dipesh", "Hrishav", "Prabin", "Pratik"};
    int[] friendPics = {R.drawable.friend_ankit, R.drawable.friend_dipesh, R.drawable.friend_hrishav, R.drawable.friend_prabin, R.drawable.friend_pratik};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        mListView = (ListView) findViewById(R.id.listView);
        MyAdapter myAdapter = new MyAdapter(Friends.this, friendNames, friendPics);
        mListView.setAdapter(myAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(Friends.this, DetailActivity.class);
                mIntent.putExtra("friendNames", friendNames[i]);
                mIntent.putExtra("friendPics", friendPics[i]);
                startActivity(mIntent);
            }
        });
        
        ButtonBackFriends = (Button)findViewById(R.id.backBtnFriends);

        ButtonBackFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
