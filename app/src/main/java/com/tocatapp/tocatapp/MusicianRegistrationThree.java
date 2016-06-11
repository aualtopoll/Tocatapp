package com.tocatapp.tocatapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MusicianRegistrationThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_three);
    }

    public void goBack(View view) {
        Intent intent = new Intent(this, MusicianRegistrationTwo.class);
        startActivity(intent);
    }

    public void finish(View view) {
        Intent intent = new Intent(this, Congratulations.class);
        startActivity(intent);
    }
}
