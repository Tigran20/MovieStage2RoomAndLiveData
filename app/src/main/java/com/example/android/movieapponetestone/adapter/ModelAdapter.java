package com.example.android.movieapponetestone.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.android.movieapponetestone.R;
import com.example.android.movieapponetestone.model.Popular;
import com.example.android.movieapponetestone.view.DetailActivity;

import java.util.ArrayList;
import java.util.List;

public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.ViewHolder> {

    public static final String KEY = "key";
    private final ArrayList<Popular> modelList;
    private Context context;


    public ModelAdapter(ArrayList<Popular> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.model_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Popular movies = modelList.get(position);
        Glide.with(context).load("http://image.tmdb.org/t/p/w185" + movies.getPosterPath()).into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DetailActivity.newIntent(context, movies);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.tv_image);
        }
    }

    public void setData(List<Popular> list) {
        modelList.addAll(list);
        notifyDataSetChanged();
    }
}
