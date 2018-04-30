package com.example.android.mahasiswa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Lihat extends AppCompatActivity {

    Toolbar toolbar;
    Button backButton;
    Button hapusButton;
    Button lihatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        toolbar     = findViewById(R.id.toolbar_lihat);
        backButton  = findViewById(R.id.lihat_activity_back_button);
        hapusButton = findViewById(R.id.lihat_activity_hapus_button);
        lihatButton = findViewById(R.id.lihat_activity_lihat_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
