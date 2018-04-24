package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.LinearLayout;

public class Registrasi extends AppCompatActivity {

    LinearLayout registrasiLayout;
    FloatingActionButton backButton;

    TextInputLayout namaLayout;
    AppCompatEditText namaEditText;
    TextInputLayout nimLayout;
    AppCompatEditText nimEditText;
    TextInputLayout prodiLayout;
    AppCompatEditText prodiEditText;
    TextInputLayout emailLayout;
    AppCompatEditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        registrasiLayout = findViewById(R.id.registrasi_layout);
        backButton       = findViewById(R.id.back_button);

        namaLayout   = findViewById(R.id.nama_textInputLayout);
        namaEditText = findViewById(R.id.nama_editText);
        nimLayout   = findViewById(R.id.NIM_textInputLayout);
        nimEditText = findViewById(R.id.NIM_editText);
        prodiLayout   = findViewById(R.id.prodi_textInputLayout);
        prodiEditText = findViewById(R.id.prodi_editText);
        emailLayout   = findViewById(R.id.email_textInputLayout);
        emailEditText = findViewById(R.id.email_editText);


        // Mematikan kursor ketika Linear Layout (Tempat Kosong) di tekan
        registrasiLayout.setOnClickListener(null);


        // Tutup Intent dengan Back Button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        // Required Nama
        namaEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (namaEditText.getText().toString().isEmpty()){

                    namaLayout.setErrorEnabled(true);
                    namaLayout.setError("Nama perlu diisi");
                }else {
                    namaLayout.setErrorEnabled(false);
                }
            }
        });

        namaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (namaEditText.getText().toString().isEmpty()){

                    namaLayout.setErrorEnabled(true);
                    namaLayout.setError("Nama perlu diisi");

                }else {
                    namaLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        // Required NIM
        nimEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (nimEditText.getText().toString().isEmpty()){

                    nimLayout.setErrorEnabled(true);
                    nimLayout.setError("NIM perlu diisi");
                }else {
                    nimLayout.setErrorEnabled(false);
                }
            }
        });

        nimEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (namaEditText.getText().toString().isEmpty()){

                    nimLayout.setErrorEnabled(true);
                    nimLayout.setError("NIM perlu diisi");

                }else {
                    nimLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        // Required Prodi
        prodiEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (prodiEditText.getText().toString().isEmpty()){

                    prodiLayout.setErrorEnabled(true);
                    prodiLayout.setError("Program studi perlu diisi");
                }else {
                    prodiLayout.setErrorEnabled(false);
                }
            }
        });

        prodiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (prodiEditText.getText().toString().isEmpty()){

                    prodiLayout.setErrorEnabled(true);
                    prodiLayout.setError("Program studi perlu diisi");

                }else {
                    prodiLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        // Required E-mail
        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if (emailEditText.getText().toString().isEmpty()){

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("E-mail perlu diisi");
                }else {
                    emailLayout.setErrorEnabled(false);
                }
            }
        });

        emailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (emailEditText.getText().toString().isEmpty()){

                    emailLayout.setErrorEnabled(true);
                    emailLayout.setError("E-mail perlu diisi");

                }else {
                    emailLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }
}
