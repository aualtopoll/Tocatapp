package com.tocatapp.tocatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.tocatapp.tocatapp.helpers.FormElement;
import com.tocatapp.tocatapp.helpers.UserData;

public class MusicianRegistrationOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_one);

        FormElement.setStringValue(this, R.id.textFirstName, UserData.getUserData(this, UserData.KEY_FNAME));
        FormElement.setStringValue(this, R.id.textLastName, UserData.getUserData(this, UserData.KEY_LNAME));
        FormElement.setStringValue(this, R.id.textEmail, UserData.getUserData(this, UserData.KEY_EMAIL));

    }

    public void goToStepTwo(View view) {
        Intent intent = new Intent(this, MusicianRegistrationTwo.class);
        UserData.setString(this, UserData.KEY_FNAME, FormElement.getStringValue(this, R.id.textFirstName));
        UserData.setString(this, UserData.KEY_LNAME, FormElement.getStringValue(this, R.id.textLastName));
        UserData.setString(this, UserData.KEY_EMAIL, FormElement.getStringValue(this, R.id.textEmail));
        startActivity(intent);
    }
}
