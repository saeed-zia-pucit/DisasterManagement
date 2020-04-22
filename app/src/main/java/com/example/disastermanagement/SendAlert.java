package com.example.disastermanagement;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SendAlert extends AppCompatActivity {
Button send;
EditText Sms,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_alert);

   send=(Button)findViewById(R.id.send);
   send.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Sms=(EditText)findViewById(R.id.sms);
           phone=(EditText)findViewById(R.id.phone);
           SmsManager smgr = SmsManager.getDefault();
           smgr.sendTextMessage(phone.getText().toString(),null,Sms.getText().toString(),null,null);
           Toast.makeText(SendAlert.this, "Alert Send", Toast.LENGTH_SHORT).show();

       }
   });
    }
}
