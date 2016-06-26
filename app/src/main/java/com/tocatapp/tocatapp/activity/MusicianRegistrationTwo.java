package com.tocatapp.tocatapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tocatapp.tocatapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicianRegistrationTwo extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_two);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnOk)
    public void goToStepThree(View view) {
        Intent intent = new Intent(this, MusicianRegistrationThree.class);
        startActivity(intent);
    }

    @OnClick(R.id.btnBack)
    public void goBack(View view) {
       finish();
    }
}
