package com.antivariant.testapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.ViewHolder> {

    private List<FilmDataModel> data;

    public FilmListAdapter(List<FilmDataModel> data) {
        this.data = data;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FilmDataModel dataLine = data.get(position);
        holder.titleView.setText(dataLine.getTitle());
        holder.yearView.setText(String.valueOf(dataLine.getYear()));
        holder.actorsView.setText(dataLine.getActors());



    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleView;
        public TextView yearView;
        public TextView actorsView;

        public ViewHolder(View itemView) {
            super(itemView);
            this.titleView = itemView.findViewById(R.id.filmTitleView);
            this.yearView = itemView.findViewById(R.id.filmYearView);
            this.actorsView = itemView.findViewById(R.id.filmActorsView);
        }

    }


}
