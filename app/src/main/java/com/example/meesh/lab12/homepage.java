package com.example.meesh.lab12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        TextView text=(TextView)findViewById(R.id.text1);
        final SharedPreferences  sharedPreferences= getSharedPreferences("LoginDetails",MODE_PRIVATE);
        if(sharedPreferences != null) {
            String value = sharedPreferences.getString("Username", "");
            text.setText(value);

            Button btn1=(Button) findViewById(R.id.tbtn);
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("Username","");
                    editor.putString("Password","");
                    editor.commit();

                    Intent i=new Intent(homepage.this,MainActivity.class);
                    startActivity(i);
                    finish();
                }
            });
        }    }
}
