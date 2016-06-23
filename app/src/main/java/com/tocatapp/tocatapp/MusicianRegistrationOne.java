package com.tocatapp.tocatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.tocatapp.tocatapp.helpers.IsValid;

public class MusicianRegistrationOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_one);
    }

    public void goToStepTwo(View view) {
        if(validateRegistrationForm()) {
            Intent intent = new Intent(this, MusicianRegistrationTwo.class);
            startActivity(intent);
        }
    }

    public void goBack(View view) {
        finish();
    }

    private Boolean validateRegistrationForm() {
        Boolean valid = true;
        String fname;
        String lname;
        String email;
        String password;
        EditText fnameEdit;
        EditText lnameEdit;
        EditText emailEdit;
        EditText passwordEdit;

        try {
            fnameEdit = (EditText)findViewById(R.id.textFirstName);
            lnameEdit = (EditText)findViewById(R.id.textLastName);
            emailEdit = (EditText)findViewById(R.id.textEmail);
            passwordEdit = (EditText)findViewById(R.id.textPassword);
            fname = fnameEdit.getText().toString();
            lname = lnameEdit.getText().toString();
            email = emailEdit.getText().toString();
            password = passwordEdit.getText().toString();
        } catch(Exception e) {
            return false;
        }

        if(valid && !IsValid.name(fname)) {
            fnameEdit.setError(getString(R.string.ta_invalid_fname));
            valid = false;
        }
        if(valid && !IsValid.name(lname)) {
            lnameEdit.setError(getString(R.string.ta_invalid_lastname));
            valid = false;

        }
        if(valid && !IsValid.email(email)) {
            emailEdit.setError(getString(R.string.ta_invalid_email));
            valid = false;
        }
        if(valid && !IsValid.password(password)) {
            passwordEdit.setError(getString(R.string.ta_invalid_pass));
            valid = false;
        }

        return valid;
    }
}
