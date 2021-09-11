package com.example.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);



    }

    public void onClick(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://letsgrowmore.in/"));
        startActivity(intent);
    }

    public void getVaccinated(View view) {

        Intent intent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.cowin.gov.in/"));
        startActivity(intent);
    }

    public void showcity(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}