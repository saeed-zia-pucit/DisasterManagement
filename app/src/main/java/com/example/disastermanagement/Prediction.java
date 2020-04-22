package com.example.disastermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Prediction extends AppCompatActivity {
Button show_on_map,send_alert;
TextView time,magnitude,loses,textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediction);

        time=(TextView)findViewById(R.id.time);
        magnitude=(TextView)findViewById(R.id.maginitude);
        loses=(TextView)findViewById(R.id.loses);

        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
       final DisasterModel disasterModel= databaseHelper.getData();

       magnitude.setText(disasterModel.getMag()+"km");




        show_on_map=(Button)findViewById(R.id.show_on_map);
        show_on_map.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        Intent intent=new Intent(Prediction.this,MapsActivity.class);
        intent.putExtra("lat",disasterModel.getLat());
        intent.putExtra("lon",disasterModel.getLon());

        startActivity(intent);
    }
});
send_alert=(Button)findViewById(R.id.send_alert);
send_alert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent=new Intent(Prediction.this,SendAlert.class);
        startActivity(intent);
    }
});

    }
}
