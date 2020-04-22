package com.example.disastermanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Options extends AppCompatActivity {
Button predict,estimate,disaster;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

    predict=(Button)findViewById(R.id.prediction);
    predict.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent=new Intent(Options.this,Prediction.class);
            intent.putExtra("type","predict");
            startActivity(intent);
        }
    });


        estimate=(Button)findViewById(R.id.estimate);
        estimate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
        Intent intent=new Intent(Options.this,Estimate.class);
        startActivity(intent);
        }
    });

        disaster=(Button)findViewById(R.id.disaster);
        disaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Options.this,AddDisaster.class);
                startActivity(intent);
            }
        });
    }


}
