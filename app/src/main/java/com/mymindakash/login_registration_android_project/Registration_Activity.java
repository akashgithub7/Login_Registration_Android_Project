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
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Akash117759 on 25-10-2016.
 */

public class Registration_Activity extends AppCompatActivity {

    Intent intent;
    EditText etUserName,etMailId,etMobileNo,etPassward, etConfirmPassward,etDate;
    RadioGroup radioGroup;
    Button submit;
    String password, confirmPassword;
    String emailPattern="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    SharedPreferences preferences;

    public void doValidation(View view){
        String UserName=etUserName.getText().toString();
        password=etPassward.getText().toString();
        confirmPassword =etConfirmPassward.getText().toString();

       try{
           if(UserName.length()==0) {
               Toast.makeText(getApplicationContext(), "Enter name please", Toast.LENGTH_SHORT).show();
           }
           else if(radioGroup.getCheckedRadioButtonId()==-1){
               Toast.makeText(getApplicationContext(), "Select Gender", Toast.LENGTH_SHORT).show();
           }
           else if(etMailId.length()==0 || etMailId.toString().matches(emailPattern)){
               Toast.makeText(getApplicationContext(), "Enter a valid Mail Id", Toast.LENGTH_SHORT).show();
           }
           else if (!password.equals(confirmPassword)){
               Toast.makeText(getApplicationContext(), "Password and Confirm password did not matched", Toast.LENGTH_SHORT).show();
           }
           else if(etMobileNo.length()!=10){
                Toast.makeText(getApplicationContext(),"Enter a valid Mobile number",Toast.LENGTH_LONG).show();
           }
           else if ((UserName.length()>0) && isValidEmail()==true && isValidMobileNo()==true){
              // sendEmail();
               Toast.makeText(getApplicationContext(),"All data is valid ..Wait for a moment..",Toast.LENGTH_LONG).show();

               SharedPreferences preferences=getSharedPreferences("MyData",Context.MODE_PRIVATE);
               SharedPreferences.Editor editor=preferences.edit();
               editor.putString("UserName",etUserName.getText().toString());
               editor.putString("Password",password);
               editor.putString("DOB",etDate.getText().toString());
               editor.putString("MailId",etMailId.getText().toString());
               editor.putString("Gender",radioGroup.toString());

               editor.commit();
               Toast.makeText(getApplicationContext(),"Data Saved Successfully",Toast.LENGTH_LONG).show();

               intent=new Intent(this,Login_Activity.class);
               startActivity(intent);
           }

       }catch (Exception e){
           Toast.makeText(getApplicationContext(), "All feilds are mandatory", Toast.LENGTH_SHORT).show();

       }


    }


    public boolean isValidEmail() {
        Pattern ps = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher ms = ps.matcher(etMailId.getText().toString());
        boolean bs = ms.matches();
        if (bs == false) {
            Toast.makeText(getApplicationContext(),"Email id is incorrect",Toast.LENGTH_LONG).show();
        }
    return true;
    }



    public boolean isValidMobileNo(){
        if (etMobileNo.length()!=10)
        {
            Toast.makeText(getApplicationContext(),"Mobile Number is incorrect",Toast.LENGTH_LONG).show();
        }
    return true;
    }

    public void sendEmail() {
        try {
            String to = etMailId.getText().toString();
            String subject = "Successful Registration";
            String message = "Registration is Successful. Welcome to our Webpage";
            SendMailActivity sm = new SendMailActivity(this, to, subject, message);
            sm.execute();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Email sending failed", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);
        etUserName=(EditText)findViewById(R.id.etUserName);
        etMailId=(EditText)findViewById(R.id.etMailId);
        submit=(Button)findViewById(R.id.btnSubmit);
        etPassward=(EditText)findViewById(R.id.etPassward);
        etConfirmPassward=(EditText)findViewById(R.id.etConfirmPassward);
        etMobileNo=(EditText)findViewById(R.id.etMobileNo);
        radioGroup=(RadioGroup)findViewById(R.id.rgGender);
        etDate=(EditText)findViewById(R.id.etDate);

    }



}
