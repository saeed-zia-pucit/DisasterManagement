package com.example.disastermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Estimate extends AppCompatActivity {
Button show;
TextView mag,los;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimate);


        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        final DisasterModel disasterModel= databaseHelper.getData();
       if(disasterModel!=null){
           mag=(TextView)findViewById(R.id.maginitude);
           los=(TextView)findViewById(R.id.loses);
           mag.setText(disasterModel.getMag()+"km");
           los.setText(disasterModel.getLos()+"people");

       }


        show=(Button)findViewById(R.id.show_map);
   show.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View v) {
           Intent intent=new Intent(Estimate.this,MapsActivity.class);
           intent.putExtra("lat",disasterModel.getLat());
           intent.putExtra("lon",disasterModel.getLon());
           startActivity(intent);
       }
   });
    }
}
