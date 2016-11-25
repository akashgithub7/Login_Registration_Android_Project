package com.mymindakash.login_registration_android_project;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=(TextView)findViewById(R.id.textView2);

        preferences=getSharedPreferences("MyData",0);
        String name=preferences.getString("EmailId" + "Password",null);

        tv.setText(name);
    }
}
