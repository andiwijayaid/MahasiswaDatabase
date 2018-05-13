package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.mahasiswa.model.Mahasiswa;
import com.example.android.mahasiswa.utils.DBHelper;

public class Registrasi extends AppCompatActivity {

    FloatingActionButton backButton;
    TextInputLayout namaLayout;
    AppCompatEditText namaEditText;
    TextInputLayout nimLayout;
    AppCompatEditText nimEditText;
    TextInputLayout prodiLayout;
    AppCompatEditText prodiEditText;
    TextInputLayout emailLayout;
    AppCompatEditText emailEditText;
    Button simpanButton, kosongkanButton;

//    private RecyclerAdapter recyclerAdapter;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);

//        dbHandler = new DBHandler(this);
        initComponents();
    }

    private void initComponents() {
        namaLayout = findViewById(R.id.nama_textInputLayout);
        namaEditText = findViewById(R.id.nama_editText);
        nimEditText = findViewById(R.id.NIM_editText);
        nimLayout = findViewById(R.id.NIM_textInputLayout);
        prodiEditText = findViewById(R.id.prodi_editText);
        prodiLayout = findViewById(R.id.prodi_textInputLayout);
        emailEditText = findViewById(R.id.email_editText);
        emailLayout = findViewById(R.id.email_textInputLayout);

        simpanButton = findViewById(R.id.simpan_button);
        backButton = findViewById(R.id.back_button);

        kosongkanButton = findViewById(R.id.kosong_button);
        kosongkanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nimEditText.getText().clear();
                namaEditText.getText().clear();
                prodiEditText.getText().clear();
                emailEditText.getText().clear();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        simpanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validasiForm();
            }
        });
    }

    private void validasiForm() {
        String form_nama = namaEditText.getText().toString();
        String form_nim = nimEditText.getText().toString();
        String form_prodi = prodiEditText.getText().toString();
        String form_email = emailEditText.getText().toString();
        dbHelper = new DBHelper(this);

        if (form_nim.isEmpty()) {
            nimEditText.setError("Isi NIM dulu");
            nimEditText.requestFocus();
        }
        if (form_nama.isEmpty()) {
            namaEditText.setError("Isi nama dulu");
            namaEditText.requestFocus();
        }
        if (form_prodi.isEmpty()) {
            prodiEditText.setError("Isi prodi dulu");
            prodiEditText.requestFocus();
        }
        if (form_email.isEmpty()) {
            emailEditText.setError("Isi email dulu");
            emailEditText.requestFocus();
        } else {
            Mahasiswa mahasiswa = new Mahasiswa(form_nama, form_nim, form_prodi, form_email);
            dbHelper.saveMahasiswa(mahasiswa);
            nimEditText.getText().clear();
            namaEditText.getText().clear();
            prodiEditText.getText().clear();
            emailEditText.getText().clear();
            Toast.makeText(Registrasi.this, "Berhasil Menambahkan Data", Toast.LENGTH_SHORT).show();
        }
    }
}
