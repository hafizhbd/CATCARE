package com.example.catcare.Activity.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.catcare.Model.SharedPrefManager;
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
public class Detail_Artikel extends AppCompatActivity {

    private ImageView imgPost;
    private TextView txtPostDesc, txtPostTitle;
    SharedPrefManager sharedPrefManager;
    private Button edit;

    //get data dari adapter
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__artikel);

        imgPost = findViewById(R.id.detail_img_artikel);

        txtPostTitle = findViewById(R.id.detail_title_artikel);
        txtPostDesc = findViewById(R.id.detail_desc_artikel);
        String postimage = getIntent().getExtras().getString("image");
        Glide.with(this).load(postimage).into(imgPost);

        String postTitle = getIntent().getExtras().getString("title");
        txtPostTitle.setText(postTitle);

        String postDesc = getIntent().getExtras().getString("desc");
        txtPostDesc.setText(postDesc);
    }
}


