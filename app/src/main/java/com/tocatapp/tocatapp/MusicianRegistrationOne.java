package com.tocatapp.tocatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MusicianRegistrationOne extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_one);
    }


    public void goToStepTwo(View view) {
        Intent intent = new Intent(this, MusicianRegistrationTwo.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
    }

}
