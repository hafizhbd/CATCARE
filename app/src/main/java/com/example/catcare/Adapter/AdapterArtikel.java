package com.example.catcare.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.catcare.Activity.Menu.Detail_Artikel;
import com.example.catcare.R;
import com.squareup.picasso.Picasso;

import java.util.List;
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
public class AdapterArtikel extends RecyclerView.Adapter<AdapterArtikel.ImageViewHolder> {
    private Context mContext;
    private List<Upload_Info> mUploads1;

    public AdapterArtikel(Context context,List<Upload_Info>uploads){
        mContext = context;
        mUploads1 = uploads;
    }
    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewtype) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item_artikel,parent,false );
        return new ImageViewHolder(v);
    }
    //get data dari upload
    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {

        Upload_Info uploadcurrent = mUploads1.get(position);
        holder.textViewTitle.setText(uploadcurrent.getmTitleinfo());
        Picasso.with(mContext)
                .load(uploadcurrent.getmImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return mUploads1.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewTitle;
        public ImageView imageView;

        public ImageViewHolder(@NonNull final View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.text_view_title);
            imageView = itemView.findViewById(R.id.image_view_upload);

            //berpindah atau intent ke post detail untuk menampilkan detail artikel
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent DetailArtikel =  new Intent(mContext, Detail_Artikel.class);
                    int position = getAdapterPosition();

                    DetailArtikel.putExtra("title",mUploads1.get(position).getmTitleinfo());
                    DetailArtikel.putExtra("desc",mUploads1.get(position).getmDescinfo());
                    DetailArtikel.putExtra("image",mUploads1.get(position).getmImageUrl());

                    mContext.startActivity(DetailArtikel);
                }
            });

        }
    }
}

