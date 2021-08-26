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

public class AdapterExplanation extends RecyclerView.Adapter<AdapterExplanation.ViewHolder> {

    public LayoutInflater inflater;
    private ArrayList<GeometryExplanation> list;
    private AdapterExplanation.OnItemClickListener onItemClickListener;

    public interface OnItemClickListener{
        void onClick(int position);
    }

    public void setList(ArrayList<GeometryExplanation> list) {
        this.list = list;
    }

    public AdapterExplanation(ArrayList<GeometryExplanation> list, Context context) {
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    public void setOnItemClickListener(AdapterExplanation.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AdapterExplanation.ViewHolder(inflater.inflate(R.layout.blockexplanation, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView1.setText(list.get(position).getName());
        holder.textView2.setText(list.get(position).getExplanation());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        public TextView textView2;
        public TextView textView1;

        ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            layout = view.findViewById(R.id.layoutExplanation);
            textView2 = view.findViewById(R.id.textView2);

        }
    }
}
