package com.example.android.mahasiswa;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class ViewHolder extends RecyclerView.ViewHolder {

    TextView namaText;
    TextView nimText;
    RadioButton radioButton;

    public ViewHolder(View itemView) {
        super(itemView);

        namaText    = itemView.findViewById(R.id.nama_mahasiswa);
        nimText     = itemView.findViewById(R.id.nim_mahasiswa);
        radioButton = itemView.findViewById(R.id.radio_button);
    }

}
