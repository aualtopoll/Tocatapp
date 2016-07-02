package com.tocatapp.tocatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.helpers.IsValid;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicianRegistrationOne extends BaseActivity {

    @BindView(R.id.inputFirstName)
    EditText inputFirstName;
    @BindView(R.id.inputLastName)
    EditText inputLastName;
    @BindView(R.id.inputEmail)
    EditText inputEmail;
    @BindView(R.id.inputPassword)
    EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_one);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnOk)
    public void goToStepTwo(View view) {
        if (validateRegistrationForm()) {
            Intent intent = new Intent(this, MusicianRegistrationTwo.class);
            startActivity(intent);
        }
    }

    @OnClick(R.id.btnBack)
    public void goBack(View view) {
        finish();
    }

    private Boolean validateRegistrationForm() {
        Boolean valid = true;
        try {
            if (valid && !IsValid.name(inputFirstName.getText().toString())) {
                inputFirstName.setError(getString(R.string.ta_invalid_fname));
                valid = false;
            }
            if (valid && !IsValid.name(inputLastName.getText().toString())) {
                inputLastName.setError(getString(R.string.ta_invalid_lastname));
                valid = false;
            }
            if (valid && !IsValid.email(inputEmail.getText().toString())) {
                inputEmail.setError(getString(R.string.ta_invalid_email));
                valid = false;
            }
            if (valid && !IsValid.password(inputPassword.getText().toString())) {
                inputPassword.setError(getString(R.string.ta_invalid_pass));
                valid = false;
            }
        } catch(Exception e) {
            valid = false;
        }

        return valid;
    }
}
