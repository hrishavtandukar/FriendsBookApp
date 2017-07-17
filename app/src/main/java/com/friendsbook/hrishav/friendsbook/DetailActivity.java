package com.friendsbook.hrishav.friendsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.friendsbook.hrishav.friendsbook.R;

public class DetailActivity extends AppCompatActivity {

    ImageView mImageView;
    Button backBtnDetailfrds;
    TextView frdName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        mImageView = (ImageView) findViewById(R.id.imageView2);

        backBtnDetailfrds = (Button)findViewById(R.id.backBtnFriendsDetail);

        frdName = (TextView)findViewById(R.id.friendName);

        backBtnDetailfrds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            frdName.setText("Name: " + mBundle.getString("friendNames"));
            mImageView.setImageResource(mBundle.getInt("friendPics"));
        }
    }
}
