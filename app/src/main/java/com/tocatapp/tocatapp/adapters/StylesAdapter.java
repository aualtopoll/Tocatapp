package com.tocatapp.tocatapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tocatapp.tocatapp.R;
import com.tocatapp.tocatapp.models.Style;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StylesAdapter extends RecyclerView.Adapter<StylesAdapter.ViewHolder>{

    ArrayList<Style> collection;

    public StylesAdapter(ArrayList<Style> collection) {
        this.collection = collection;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.styles_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Style element = collection.get(position);
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
