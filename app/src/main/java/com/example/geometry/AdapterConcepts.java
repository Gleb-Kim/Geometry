package com.example.geometry;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterConcepts extends RecyclerView.Adapter<AdapterConcepts.ViewHolder> {
    public LayoutInflater inflater;
    private ArrayList<GeometryConcept> list;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public AdapterConcepts(ArrayList<GeometryConcept> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    public void setList(ArrayList<GeometryConcept> list) {
        this.list = list;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.blocktheory, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(list.get(position).getName());
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout layout;
        public ImageView imageView;
        public TextView textView;

        ViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.blockText);
            layout = view.findViewById(R.id.linearlayout);
            imageView = view.findViewById(R.id.image);

        }
    }
}
