package com.example.catcare.Activity.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.example.catcare.Model.SharedPrefManager;
import com.example.catcare.R;
import com.google.firebase.auth.FirebaseAuth;
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
public class MenuAdmin extends AppCompatActivity {
    Button btnLogOut, btnartikel, btnkmbl;
    Intent PilihanArtikelActivity, kembali;
    SharedPrefManager sharedPrefManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);
        btnLogOut = (Button) findViewById(R.id.sign_out);
        btnartikel = (Button) findViewById(R.id.button3);
        btnkmbl =(Button) findViewById(R.id.button5);
        PilihanArtikelActivity = new Intent(this,PilihanArtikelActivity.class);
        kembali = new Intent(this, MainActivity.class);
        sharedPrefManager = new SharedPrefManager(this);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(MenuAdmin.this, LoginActivity.class);
                startActivity(I);

            }
        });
btnartikel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
startActivity(PilihanArtikelActivity);
    }
});
    btnkmbl.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startActivity(kembali);
        }
    });

    }
    }
