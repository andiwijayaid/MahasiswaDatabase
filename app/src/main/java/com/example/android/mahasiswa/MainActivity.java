package com.example.android.mahasiswa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Membuat intent untuk Registrasi Activity
    public void registrasi(View view) {
        Intent intent = new Intent(this, Registrasi.class);
        startActivity(intent);
    }

    // Membuat intent untuk Lihat Activity
    public void lihat(View view) {
        Intent intent = new Intent(this, Lihat.class);
        startActivity(intent);
    }


}
