package com.tocatapp.tocatapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tocatapp.tocatapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicianRegistrationThree extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_three);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnBack)
    public void goBack(View view) {
        finish();
    }

    @OnClick(R.id.btnOk)
    public void finish(View view) {
        Intent intent = new Intent(this, Congratulations.class);
        startActivity(intent);
    }
}
