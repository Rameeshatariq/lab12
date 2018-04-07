package com.example.meesh.lab12;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText uname, paswd;
    Button btnJoin;
    SharedPreferences sharedPreferences;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText)findViewById(R.id.username);
        paswd=(EditText)findViewById(R.id.pass);
        btnJoin=(Button)findViewById(R.id.btn);

        context=MainActivity.this;
        sharedPreferences= getSharedPreferences("LoginDetails",MODE_PRIVATE);

        if(savedInstanceState != null){
            String value=sharedPreferences.getString("Username","");
            if(value != null){
                Intent i= new Intent(context,homepage.class);
                startActivity(i);
                finish();
            }
        }

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username=uname.getText().toString();
                String Password=paswd.getText().toString();

                if(!TextUtils.isEmpty(Username) && !TextUtils.isEmpty(Password))
                {
                    //sharedPreferences= getSharedPreferences("LoginDetails",MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("Username",Username);
                    editor.putString("Password",Password);
                    editor.commit();

                    Intent i =new Intent(context,homepage.class);
                    startActivity(i);
                    finish();
                }
            }
        });

    }
}
