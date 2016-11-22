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

  /*  public void doLogin(View view){
        intent=new Intent(this,Splash_Activity.class);
        startActivity(intent);
    }*/

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

                SharedPreferences preferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
                String email=preferences.getString("MailId",DEFAULT);
                String password=preferences.getString("password",DEFAULT);
                if(email==DEFAULT || password==DEFAULT){
                    Toast.makeText(getApplicationContext(),"No Data Found",Toast.LENGTH_LONG).show();
                }
                else {
                    useremail.setText(email);
                    userpw.setText(password);
                    intent=new Intent(context,Splash_Activity.class);
                    startActivity(intent);
                }


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
