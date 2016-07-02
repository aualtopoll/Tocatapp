package com.tocatapp.tocatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.adapters.InstrumentAdapter;
import com.tocatapp.tocatapp.adapters.StylesAdapter;
import com.tocatapp.tocatapp.helpers.Data;
import com.tocatapp.tocatapp.models.Style;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicianRegistrationThree extends BaseActivity {

    private ArrayList<Style> stylesList = new ArrayList<>();
    private RecyclerView recyclerView;
    private StylesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician_registration_three);
        ButterKnife.bind(this);

        recyclerView = (RecyclerView) findViewById(R.id.stylesRecyclerList);

        stylesList = Data.getStyleList();

        adapter = new StylesAdapter(stylesList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
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
