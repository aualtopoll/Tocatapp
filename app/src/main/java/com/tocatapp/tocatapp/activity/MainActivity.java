package com.tocatapp.tocatapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tocatapp.tocatapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnRegistration)
    public void goToRegistration(View view) {
        Intent intent = new Intent(this, MusicianRegistrationOne.class);
        startActivity(intent);
    }
}
