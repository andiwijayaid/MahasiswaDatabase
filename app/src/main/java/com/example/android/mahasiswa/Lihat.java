package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.android.mahasiswa.utils.DBHelper;
import com.example.android.mahasiswa.utils.MahasiswaAdapter;

public class Lihat extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private DBHelper dbHelper;
    private MahasiswaAdapter adapter;
    private String filter = "";
    Toolbar toolbar;
    Button backButton;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        //initialize the variables
        mRecyclerView = findViewById(R.id.recyclerView_id);
        mRecyclerView.setHasFixedSize(true);
        toolbar = findViewById(R.id.toolbar_lihat);
        backButton = findViewById(R.id.lihat_activity_back_button);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Action
        setSupportActionBar(toolbar);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //populate recyclerview
        populaterecyclerView(filter);
    }

    private void populaterecyclerView(String filter){
        dbHelper = new DBHelper(this);
        adapter = new MahasiswaAdapter(dbHelper.mahasiswaList(filter), this, mRecyclerView);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }


}