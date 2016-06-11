package com.tocatapp.tocatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.tocatapp.tocatapp.helpers.UserData;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        UserData.flush(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToRegistration(View view) {
        Intent intent = new Intent(this, MusicianRegistrationOne.class);
        startActivity(intent);
    }
}
