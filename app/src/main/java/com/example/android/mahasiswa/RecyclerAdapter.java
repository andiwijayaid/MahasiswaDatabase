package com.example.android.mahasiswa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Mahasiswa> mahasiswas;
    Context context;

    public RecyclerAdapter(List<Mahasiswa> mahasiswaList, Context context) {
        this.context    = context;
        this.mahasiswas = mahasiswaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mahasiswa mahasiswa = mahasiswas.get(position);
        holder.namaText.setText(mahasiswa.namaMahasiswa);
        holder.nimText.setText(mahasiswa.nimMahasiswa);

    }

    @Override
    public int getItemCount() {
        return mahasiswas.size();
    }
}
