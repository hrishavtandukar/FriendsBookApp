package com.friendsbook.hrishav.friendsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    Button logInBtn;
    EditText usrName;
    EditText passWrd;
    TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        usrName = (EditText)findViewById(R.id.username);
        passWrd = (EditText)findViewById(R.id.password);

        error = (TextView)findViewById(R.id.errorMessage);
        logInBtn = (Button)findViewById(R.id.logInButton);

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = usrName.getText().toString();
                String pwd = passWrd.getText().toString();

                if(user.equals("admin")&&pwd.equals("admin"))
                {
                    Intent i = new Intent(LogIn.this,Home.class);
                    Intent profileIntent = new Intent(LogIn.this,Profile.class);

                    i.putExtra("user",user);
                    profileIntent.putExtra("user",user);

                    startActivity(i);
                }

                else
                {
                    error.setText("Please Enter Valid username and password to continue!!!");
                }
            }
        });
    }
}
