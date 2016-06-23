package com.tocatapp.tocatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MusicianRegistrationTwo extends AppCompatActivity {

    private static final String TAG = MusicianRegistrationOne.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_two);
    }

    public void goToStepThree(View view) {
        Intent intent = new Intent(this, MusicianRegistrationThree.class);
        startActivity(intent);
    }

    public void goBack(View view) {
       finish();
    }
}
