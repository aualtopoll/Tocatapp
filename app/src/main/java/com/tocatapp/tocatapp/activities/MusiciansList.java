package com.tocatapp.tocatapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.adapters.MusicianAdapter;
import com.tocatapp.tocatapp.helpers.Data;
import com.tocatapp.tocatapp.models.Musician;

import java.util.ArrayList;

public class MusiciansList extends BaseActivity {

    private ArrayList<Musician> musicianList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MusicianAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musicians_list);

        recyclerView = (RecyclerView) findViewById(R.id.musicianRecyclerList);
        musicianList = Data.getMusicianList();
        adapter = new MusicianAdapter(this, musicianList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    public void goToProfile(int musicianId) {
        Intent intent = new Intent(this, MusicianProfile.class);
        intent.putExtra("musicianId", musicianId);
        startActivity(intent);
    }
}
