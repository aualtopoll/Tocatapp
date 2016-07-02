package com.tocatapp.tocatapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.models.Instrument;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InstrumentAdapter extends RecyclerView.Adapter<InstrumentAdapter.ViewHolder>{

    ArrayList<Instrument> collection;

    public InstrumentAdapter(ArrayList<Instrument> collection) {
        this.collection = collection;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.instrument_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Instrument element = collection.get(position);
        holder.check.setText(element.getName());
    }

    @Override
    public int getItemCount() {
        return collection.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.check)
        TextView check;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
