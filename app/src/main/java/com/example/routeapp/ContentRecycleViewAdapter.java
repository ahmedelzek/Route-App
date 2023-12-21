package com.example.routeapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class ContentRecycleViewAdapter extends RecyclerView.Adapter<ContentRecycleViewAdapter.MyViewHolder> {

    ArrayList<ContentModel> contentModels = new ArrayList<>();

    public ContentRecycleViewAdapter(ArrayList<ContentModel> contentModels) {
        this.contentModels = contentModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ContentModel contentModel = contentModels.get(position);
        holder.courseImg.setImageResource(contentModel.getCourseImage());
        holder.courseBtn.setText(contentModel.getCourseName());
    }

    @Override
    public int getItemCount() {
        return contentModels.size();
    }

    public void setContentModels(ArrayList<ContentModel> contentModels) {
        this.contentModels = contentModels;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView courseImg;
        private MaterialButton courseBtn;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            courseImg = itemView.findViewById(R.id.courseImg);
            courseBtn = itemView.findViewById(R.id.courseBtn);

            courseBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Get the position of the clicked item
                    int position = getAdapterPosition();
                    ((MainActivity) itemView.getContext()).buttonClickAction(position);
                }
            });
        }
    }
}

