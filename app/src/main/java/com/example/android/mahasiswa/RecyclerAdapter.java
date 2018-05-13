//package com.example.android.mahasiswa;
//
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CompoundButton;
//
//import com.example.android.mahasiswa.model.Mahasiswa;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {
//
//    private List<Mahasiswa> mahasiswaList = new ArrayList<>();
//    static int lastCheckedPos = -1;
//
//    public RecyclerAdapter (List<Mahasiswa> mahasiswaList) {
//        this.mahasiswaList = mahasiswaList;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        holder.nimText.setText(mahasiswaList.get(position).getNimMahasiswa());
//        holder.namaText.setText(mahasiswaList.get(position).getNamaMahasiswa());
//        holder.radioButton.setOnCheckedChangeListener(null);
//        holder.radioButton.setChecked(position == lastCheckedPos);
//        holder.radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                lastCheckedPos = position;
//                notifyDataSetChanged();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return mahasiswaList.size();
//    }
//
//    @Override
//    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
//        super.onAttachedToRecyclerView(recyclerView);
//    }
//}