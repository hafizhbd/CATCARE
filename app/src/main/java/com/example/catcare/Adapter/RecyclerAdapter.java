package com.example.catcare.Adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catcare.R;
/*
AKB 2 10116060 Muhammad Hafizh Budiman
Changelog
versi 0.0.1 14 Juli 2019
1. Membuat Splash Screen
2. Membuat Menu Utama
versi 0.0.2 16 Juli 2019
1. Membuat Fragment
2. Membuat Tampilan Video melalui ArrayList
Versi 0.0.3 17 Juli 2019
1. Mengkoneksikan App dengan Firebase
2. Menampilkan Gambar secara Manual
versi 0.0.4 19 Juli 2019
1. Menampilkan Gambar melalui Firebase
versi 0.0.5 23 Juli 2019
1. Membuat Adapter
2. Menampilkan Data Artikel
versi 0.0.6 29 Juli 2019
1. Membuat Add Data Pada menu Artikel
versi 0.0.7 31 Juli 2019
1. Mempercantik UI.
*/
public class RecyclerAdapter extends RecyclerView.ViewHolder{

    public RecyclerAdapter(View itemView) {
        super(itemView);
    }

    public void setDisplayImage(String imageUrl, Context context) {

        ImageView image = itemView.findViewById(R.id.gambar);
        Glide.with(context)
                .load(imageUrl)
                .into(image);
    }
}
