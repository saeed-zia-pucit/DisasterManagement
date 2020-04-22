package com.example.disastermanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddDisaster extends AppCompatActivity {
Button save;
EditText lat,lon,mag,los;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_disaster);
        lat= (EditText)findViewById(R.id.lat);
        lon= (EditText)findViewById(R.id.lon);
        mag= (EditText)findViewById(R.id.mag);
        los= (EditText)findViewById(R.id.loss);


        save=(Button)findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double lat1=Double.parseDouble(lat.getText().toString());
                double lon1=Double.parseDouble(lon.getText().toString());
                double mag1=Double.parseDouble(mag.getText().toString());
                int los1=Integer.parseInt(los.getText().toString());

              DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
              databaseHelper.addDisaster(lat1,lon1,mag1,los1);
                ///Toast.makeText(AddDisaster.this, "Data saved", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
