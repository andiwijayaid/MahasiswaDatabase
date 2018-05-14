package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.mahasiswa.model.Mahasiswa;
import com.example.android.mahasiswa.utils.DBHelper;

public class Detail extends AppCompatActivity {

    TextView namaMahasiswaText, nimMahasiswaText, prodiMahasiswaText, emailMahasiswaText;
    Button backButton;
    android.support.v7.widget.Toolbar toolbar;
    DBHelper dbHelper;
    private long receiveMahasiswaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initComponents();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void initComponents() {
        namaMahasiswaText = findViewById(R.id.nama_mahasiswa);
        nimMahasiswaText = findViewById(R.id.nim_mahasiswa);
        prodiMahasiswaText = findViewById(R.id.prodi_mahasiswa);
        emailMahasiswaText = findViewById(R.id.email_mahasiswa);
        backButton = findViewById(R.id.detail_activity_back_button);

        toolbar = findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);

        dbHelper = new DBHelper(this);

        try {
            //get intent to get person id
            receiveMahasiswaId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }


        Mahasiswa queriedMahasiswa = dbHelper.getMahasiswa(receiveMahasiswaId);
        //set field to this user data
        namaMahasiswaText.setText(queriedMahasiswa.getNamaMahasiswa());
        nimMahasiswaText.setText(queriedMahasiswa.getNimMahasiswa());
        prodiMahasiswaText.setText(queriedMahasiswa.getProdiMahasiswa());
        emailMahasiswaText.setText(queriedMahasiswa.getEmailMahasiswa());
    }

}
