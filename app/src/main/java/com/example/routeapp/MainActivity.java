package com.example.routeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.routeapp.R.id;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MaterialButton courseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseBtn = findViewById(R.id.courseBtn);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<ContentModel> contentModels = addData();
        ContentRecycleViewAdapter adapter = new ContentRecycleViewAdapter(contentModels);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<ContentModel> addData() {
        ArrayList<ContentModel> itemList = new ArrayList<>();
        itemList.add(new ContentModel("android course", R.drawable.android));
        itemList.add(new ContentModel("ios course", R.drawable.ios));
        itemList.add(new ContentModel("full stack", R.drawable.fullstack));
        return itemList;
    }

    public void buttonClickAction(int position) {
        if (position == 0) {
            Intent intent = new Intent(this,AndroidActivity.class);
            startActivity(intent);
        }
        if (position == 1) {
            Intent intent = new Intent(this,IosActivity.class);
            startActivity(intent);
        }
        if (position == 2) {
            Intent intent = new Intent(this,FullStackActivity.class);
            startActivity(intent);
        }
    }

}