//package com.example.android.mahasiswa;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class Detail extends AppCompatActivity {
//
//    TextView namaMahasiswaText, nimMahasiswaText, prodiMahasiswaText, emailMahasiswaText;
//    DBHandler dbHandler;
//    Intent updateIntent;
//    android.support.v7.widget.Toolbar toolbar;
//    final String NAME = "Lecturer NAME";
//    final String NIM = "Lecturere NIM";
//    final String PRODI = "Lecturer PRODI";
//    final String EMAIL = "Lecturer EMAIL";
//    final Bundle bundle = getIntent().getExtras();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail);
//
//        namaMahasiswaText = findViewById(R.id.nama_mahasiswa);
//        nimMahasiswaText = findViewById(R.id.nim_mahasiswa);
//        prodiMahasiswaText = findViewById(R.id.prodi_mahasiswa);
//        emailMahasiswaText = findViewById(R.id.email_mahasiswa);
//
//        // Ambil extras Intent
//        namaMahasiswaText.setText(bundle.getString(NAME));
//        nimMahasiswaText.setText(bundle.getString(NIM));
//        prodiMahasiswaText.setText(bundle.getString(PRODI));
//        emailMahasiswaText.setText(bundle.getString(EMAIL));
//
//        toolbar = findViewById(R.id.toolbar_detail);
//        setSupportActionBar(toolbar);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_detail_activity, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        int id = item.getItemId();
//        if (id == R.id.edit_data) {
//            updateIntent = new Intent(getApplicationContext(), Update.class);
//            updateIntent.putExtra(NAME, bundle.getString(NAME));
//            updateIntent.putExtra(NIM, bundle.getString(NIM));
//            updateIntent.putExtra(PRODI, bundle.getString(PRODI));
//            updateIntent.putExtra(EMAIL, bundle.getString(EMAIL));
//            startActivity(updateIntent);
//            Toast.makeText(Detail.this, "Berhasil Menghapus Semua Data Mahasiswa", Toast.LENGTH_SHORT).show();
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}
