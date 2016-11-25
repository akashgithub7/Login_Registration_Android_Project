package com.mymindakash.login_registration_android_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Akash117759 on 03-11-2016.
 */

public class Login_Activity extends AppCompatActivity {
    Intent intent;
    private Context context=this;
    Button btnSetup,btnLogin;
    EditText useremail,userpw;
    public static final String DEFAULT="N/A";
    SharedPreferences preferences;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        btnSetup=(Button)findViewById(R.id.btnSetup);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        useremail=(EditText) findViewById(R.id.input_email);
        userpw=(EditText) findViewById(R.id.input_password);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preferences=getSharedPreferences("MyData",0);

                final String email=preferences.getString("MailId",null);
                final String pass=preferences.getString("Password",null);

                if(useremail.equals(email) && userpw.equals(pass)){
                    Intent intent=new Intent(getBaseContext(),Splash_Activity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getBaseContext(),"No data found",Toast.LENGTH_LONG).show();


            }
        });
        btnSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(context,Registration_Activity.class);
                startActivity(intent);
            }
        });
    }
}
