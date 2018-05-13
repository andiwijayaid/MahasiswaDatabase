package com.example.android.mahasiswa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.android.mahasiswa.utils.MahasiswaAdapter;

public class Lihat extends AppCompatActivity {

//    final String NAME = "Lecturer NAME";
//    final String NIM = "Lecturere NIM";
//    final String PRODI = "Lecturer PRODI";
//    final String EMAIL = "Lecturer EMAIL";
//    Toolbar toolbar;
//    Button backButton;
//    Button hapusButton;
//    Button lihatButton;
//    Intent detailIntent;
//    private RecyclerView recyclerView;
//    private LinearLayoutManager layoutManager;
//    private RecyclerAdapter recyclerAdapter;
//    private DBHandler dbHandler;
//    private TextView txt_resultadapter;
//    private List<Mahasiswa> mahasiswaList = new ArrayList<>();

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

//        initComponents();
//        initRecyclerView();
//        cekDataRecyclerView();
//
//        toolbar = findViewById(R.id.toolbar_lihat);
//        setSupportActionBar(toolbar);
//
//        backButton = findViewById(R.id.lihat_activity_back_button);
//
//        lihatButton = findViewById(R.id.lihat_activity_lihat_button);
//
//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//            }
//
//        });
//
//        hapusButton = findViewById(R.id.lihat_activity_hapus_button);
//        hapusButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dbHandler.hapusSemuaDataMahasiswa();
//                Toast.makeText(Lihat.this, "Berhasil Menghapus Semua Data Mahasiswa", Toast.LENGTH_SHORT).show();
//            }
//        });


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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_lihat_activity, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        if (id == R.id.hapus_semua_data) {
//            dbHandler.hapusSemuaDataMahasiswa();
//            Toast.makeText(Lihat.this, "Berhasil Menghapus Semua Data Mahasiswa", Toast.LENGTH_SHORT).show();
//            finish();
//        }
//        return super.onOptionsItemSelected(item);
//    }

//    private void initRecyclerView() {
//        recyclerView = findViewById(R.id.recyclerView_id);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(layoutManager);
//
//        dbHandler = new DBHandler(Lihat.this);
//        mahasiswaList = dbHandler.getSemuaMahasiswa();
//        recyclerAdapter = new RecyclerAdapter(mahasiswaList);
//        recyclerView.setAdapter(recyclerAdapter);
//        recyclerAdapter.notifyDataSetChanged();
//    }

//    private void initComponents() {
//        txt_resultadapter = findViewById(R.id.masih_kosong);
//    }

//    private void cekDataRecyclerView() {
//        if (recyclerAdapter.getItemCount() == 0) {
//            txt_resultadapter.setVisibility(View.VISIBLE);
//        } else {
//            txt_resultadapter.setVisibility(View.GONE);
//            recyclerView.setVisibility(View.VISIBLE);
//
//            recyclerView.addOnItemTouchListener(
//                    new RecyclerItemClickListener(getApplicationContext(), new RecyclerItemClickListener.OnItemClickListener() {
//                        @Override
//                        public void onItemClick(View view, int position) {
//                            detailIntent = new Intent(getApplicationContext(), Detail.class);
//                            detailIntent.putExtra(NAME, mahasiswaList.get(position).getNamaMahasiswa());
//                            detailIntent.putExtra(NIM, mahasiswaList.get(position).getNimMahasiswa());
//                            detailIntent.putExtra(PRODI, mahasiswaList.get(position).getProdiMahasiswa());
//                            detailIntent.putExtra(EMAIL, mahasiswaList.get(position).getEmailMahasiswa());
//                            detailIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            startActivity(detailIntent);
//                            dbHandler.hapusDataMahasiswa(mahasiswaList.get(position));
//                        }
//                    })
//            );
//
//
//        }
//    }

}