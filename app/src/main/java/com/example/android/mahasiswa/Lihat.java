package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Lihat extends AppCompatActivity {

    Toolbar toolbar;
    Button backButton;
    Button hapusButton;
    Button lihatButton;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private RecyclerAdapter recyclerAdapter;
    private DBHandler dbHandler;
    private TextView txt_resultadapter;
    private List<Mahasiswa> mahasiswaList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        toolbar     = findViewById(R.id.toolbar_lihat);
        backButton  = findViewById(R.id.lihat_activity_back_button);
        hapusButton = findViewById(R.id.lihat_activity_hapus_button);
        lihatButton = findViewById(R.id.lihat_activity_lihat_button);

        initComponents();
        initRecyclerView();
        cekDataRecyclerView();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView_id);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        dbHandler = new DBHandler(Lihat.this);
        mahasiswaList = dbHandler.getSemuaMahasiswa();
        recyclerAdapter = new RecyclerAdapter(mahasiswaList);
        recyclerView.setAdapter(recyclerAdapter);
        recyclerAdapter.notifyDataSetChanged();
    }

    private void initComponents() {
        txt_resultadapter = findViewById(R.id.masih_kosong);
    }

    private void cekDataRecyclerView() {
        if (recyclerAdapter.getItemCount() == 0) {
            txt_resultadapter.setVisibility(View.VISIBLE);
        } else {
            txt_resultadapter.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}
