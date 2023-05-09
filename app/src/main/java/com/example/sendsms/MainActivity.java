package com.example.sendsms;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
public class MainActivity extends AppCompatActivity {
    EditText mob,msg;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        Object id = new Object();
        mob=(EditText)findViewById(id.ed1);
        msg=(EditText)findViewById(id.ed2);
        btn=(Button)findViewById(id.btn);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SM
                S)!=PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MainActivity.this,new
                    String[]{Manifest.permission.SEND_SMS},100);
        }
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mo=mob.getText().toString().trim();
                String ms=msg.getText().toString().trim();
                try{
                    SmsManager sm=SmsManager.getDefault();
                    sm.sendTextMessage(mo,null,ms,null,null);
                    Toast.makeText(getApplicationContext(),"Send Message Successfully
                            ",Toast.LENGTH_LONG).show();
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Not Send
                            Message",Toast.LENGTH_LONG).show();
                }
            }
        });