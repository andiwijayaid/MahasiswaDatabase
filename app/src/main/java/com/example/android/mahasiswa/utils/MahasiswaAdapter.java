package com.example.android.mahasiswa.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.mahasiswa.Detail;
import com.example.android.mahasiswa.R;
import com.example.android.mahasiswa.Update;
import com.example.android.mahasiswa.model.Mahasiswa;

import java.util.List;


public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {

    private List<Mahasiswa> mPeopleList;
    private Context mContext;
    private RecyclerView mRecyclerV;
    DBHelper dbHelper = new DBHelper(mContext);

    AlertDialog alertDialog;
    android.support.v7.app.AlertDialog alertBuilder;

    // Menyediakan sebuah reference pada view untuk setiap data item
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namaMahasiswa;
        public TextView nimMahasiswa;

        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            namaMahasiswa = v.findViewById(R.id.nama_mahasiswa);
            nimMahasiswa = v.findViewById(R.id.nim_mahasiswa);
        }
    }


    // Constructor
    public MahasiswaAdapter(List<Mahasiswa> myDataset, Context context, RecyclerView recyclerView) {
        mPeopleList = myDataset;
        mContext = context;
        mRecyclerV = recyclerView;
    }

    // invoked by the layout manager
    @Override
    public MahasiswaAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Membuat views baru
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.recycler_view_item, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        final Mahasiswa mahasiswa = mPeopleList.get(position);
        holder.namaMahasiswa.setText(mahasiswa.getNamaMahasiswa());
        holder.nimMahasiswa.setText(mahasiswa.getNimMahasiswa());

        //listen to single view layout click
        holder.layout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(mContext, R.style.AlertDialogCustom);
                builder.setTitle("Pilih opsi");
                builder.setMessage("Update atau delete mahasiswa?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        goToUpdateActivity(mahasiswa.getId());

                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog, int which) {
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mContext, R.style.AlertDialogCustom);
                        alertBuilder.setMessage("Hapus Data");
                        alertBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                DBHelper dbHelper = new DBHelper(mContext);
                                dbHelper.deleteMahasiswaRecord(mahasiswa.getId(), mContext);

                                mPeopleList.remove(position);
                                mRecyclerV.removeViewAt(position);
                                notifyItemRemoved(position);
                                notifyItemRangeChanged(position, mPeopleList.size());
                                notifyDataSetChanged();
                            }
                        });

                        alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialog.dismiss();
                            }
                        });

                        alertBuilder.create().show();
                    }
                });
                builder.create().show();
                return false;
            }
        });

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDetailActivity(mahasiswa.getId());
            }
        });

    }

    private void goToUpdateActivity(long mahasiswaId){
        Intent goToUpdate = new Intent(mContext, Update.class);
        goToUpdate.putExtra("USER_ID", mahasiswaId);
        mContext.startActivity(goToUpdate);
    }

    private void goToDetailActivity(long mahasiswaId){
        Intent goToDetail = new Intent(mContext, Detail.class);
        goToDetail.putExtra("USER_ID", mahasiswaId);
        mContext.startActivity(goToDetail);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mPeopleList.size();
    }
}
