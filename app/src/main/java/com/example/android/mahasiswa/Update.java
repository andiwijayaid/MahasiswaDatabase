package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import com.example.android.mahasiswa.model.Mahasiswa;

public class Update extends AppCompatActivity {

    TextInputLayout namaLayout;
    AppCompatEditText namaEditText;
    TextInputLayout nimLayout;
    AppCompatEditText nimEditText;
    TextInputLayout prodiLayout;
    AppCompatEditText prodiEditText;
    TextInputLayout emailLayout;
    AppCompatEditText emailEditText;
    Button updateButton;
    FloatingActionButton backButton;
//    final String NAME = "Lecturer NAME";
//    final String NIM = "Lecturere NIM";
//    final String PRODI = "Lecturer PRODI";
//    final String EMAIL = "Lecturer EMAIL";
//    final Bundle bundle = getIntent().getExtras();

    private DBHelper dbHelper;
    private long receiveMahasiswaId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        initComponents();
    }

    private void initComponents() {
        namaLayout = findViewById(R.id.nama_textInputLayout);
        namaEditText = findViewById(R.id.nama_editText);
        nimLayout = findViewById(R.id.NIM_textInputLayout);
        nimEditText = findViewById(R.id.NIM_editText);
        prodiLayout = findViewById(R.id.prodi_textInputLayout);
        prodiEditText = findViewById(R.id.prodi_editText);
        emailEditText = findViewById(R.id.email_editText);
        emailLayout = findViewById(R.id.email_textInputLayout);
        updateButton= findViewById(R.id.update_button);

        dbHelper = new DBHelper(this);

        try {
            //get intent to get person id
            receiveMahasiswaId = getIntent().getLongExtra("USER_ID", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        /***populate user data before update***/
        Mahasiswa queriedMahasiswa = dbHelper.getMahasiswa(receiveMahasiswaId);
        //set field to this user data
        namaEditText.setText(queriedMahasiswa.getNamaMahasiswa());
        nimEditText.setText(queriedMahasiswa.getNimMahasiswa());
        prodiEditText.setText(queriedMahasiswa.getProdiMahasiswa());
        emailEditText.setText(queriedMahasiswa.getEmailMahasiswa());


        //listen to add button click to update
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //call the save person method
                updateMahasiswa();
            }
        });

    }

    private void updateMahasiswa() {
        String form_nama = namaEditText.getText().toString();
        String form_nim = nimEditText.getText().toString();
        String form_prodi = prodiEditText.getText().toString();
        String form_email = emailEditText.getText().toString();

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
        }

        Mahasiswa updateMahasiswa = new Mahasiswa(form_nama, form_nim, form_prodi, form_email);
        dbHelper.updateMahasiswaRecord(receiveMahasiswaId, this, updateMahasiswa);
        finish();

    }
}
