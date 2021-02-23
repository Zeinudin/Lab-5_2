package com.example.myimplintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button webButton = (Button) findViewById(R.id.webButton);
        webButton.setOnClickListener(this::onClick);

        Button mapButton = (Button) findViewById(R.id.mapButton);
        mapButton.setOnClickListener(this::onClick);

        Button phoneButton = (Button) findViewById(R.id.phoneButton);
        phoneButton.setOnClickListener(this::onClick);
    }

    public void onClick(View v){
        Intent intentWebMap = new Intent(Intent.ACTION_VIEW);
        Intent intentTel = new Intent(Intent.ACTION_CALL);
        switch (v.getId()){
            case R.id.webButton:
                Uri web = Uri.parse("https://stackoverflow.com");
                intentWebMap.setData(web);
                startActivity(intentWebMap);
                break;
            case R.id.mapButton:
                Uri map = Uri.parse("google.streetview:cbll=42.8452412,75.292383");
                intentWebMap.setData(map);
                intentWebMap.setPackage("com.google.android.apps.maps");
                startActivity(intentWebMap);
                break;
            case R.id.phoneButton:
                Uri tel = Uri.parse("tel:" + "+996553055266");
                intentTel.setData(tel);
                intentTel.setAction(Intent.ACTION_DIAL);
                startActivity(intentTel);
                break;

        }

    }
}