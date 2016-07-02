package com.tocatapp.tocatapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.activities.MusicianProfile;
import com.tocatapp.tocatapp.activities.MusiciansList;
import com.tocatapp.tocatapp.models.Instrument;
import com.tocatapp.tocatapp.models.Musician;
import com.tocatapp.tocatapp.models.Style;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicianAdapter extends RecyclerView.Adapter<MusicianAdapter.ViewHolder> {

    ArrayList<Musician> collection;
    Context context;

    public MusicianAdapter(Context context, ArrayList<Musician> collection) {
        this.context = context;
        this.collection = collection;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.musician_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Musician element = collection.get(position);
        holder.musicianFullName.setText(element.getFullName());

        String instrumentsString = "";
        for (Instrument i :
                element.getInstruments()) {
            instrumentsString += (context.getString(i.getName()) + " ");
        }

        String stylesString = "";
        for (Style s :
                element.getStyles()) {
            stylesString += (context.getString(s.getName()) + " ");
        }

        holder.musicianInstruments.setText(instrumentsString);
        holder.musicianStyles.setText(stylesString);
        holder.btnViewProfile.setId(element.getId());
    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.musicianFullName)
        TextView musicianFullName;
        @BindView(R.id.musicianStyles)
        TextView musicianStyles;
        @BindView(R.id.musicianInstruments)
        TextView musicianInstruments;
        @BindView(R.id.btnViewProfile)
        Button btnViewProfile;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.btnViewProfile)
        public void viewProfile(View v) {
            int musicianId = v.getId();
            ((MusiciansList)context).goToProfile(musicianId);
        }
    }
}
