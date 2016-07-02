package com.tocatapp.tocatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.adapters.InstrumentAdapter;
import com.tocatapp.tocatapp.helpers.Data;
import com.tocatapp.tocatapp.models.Instrument;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicianRegistrationTwo extends BaseActivity {

    private ArrayList<Instrument> instrumentList = new ArrayList<>();
    private RecyclerView recyclerView;
    private InstrumentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_two);
        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.instrumentRecyclerList);

        instrumentList = Data.getInstrumentList();

        adapter = new InstrumentAdapter(instrumentList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
