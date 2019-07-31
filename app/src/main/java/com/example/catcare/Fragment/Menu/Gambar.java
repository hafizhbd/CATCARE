package com.example.catcare.Fragment.Menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.FragmentManager;

import com.example.catcare.Fragment.Gambar.GambarKH;
import com.example.catcare.Fragment.Gambar.GambarKO;
import com.example.catcare.Fragment.Gambar.GambarKP;
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
public class Gambar extends Fragment  {
    ListView listview;
    String e[] = {
            "Kucing Orange", "Kucing Hitam", "Kucing Putih"

    };
    public Gambar() {
    }

    RelativeLayout view;


   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = (RelativeLayout) inflater.inflate(R.layout.gambar, container, false);
        getActivity().setTitle("Gambar");
       listview = (ListView) view.findViewById(R.id.listview);
       /*
        *  ArrayAdapter<T> = T Tergantung Dari Tipe Data Variabel,
        *  Jika String Maka Isi String, Jika Integer Maka Tulis Integer
        */
       ArrayAdapter<String> adapter = new ArrayAdapter<String>(
               getActivity(), android.R.layout.simple_list_item_1, e
       );

       // set data
       listview.setAdapter(adapter);
       listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

           @Override
           public void onItemClick(AdapterView<?> parent, View view, int p, long id) {
               if (p == 0) {
                   FragmentManager fm = getFragmentManager();
                   FragmentTransaction ft = fm.beginTransaction();
                   GambarKO llf = new GambarKO();
                   ft.replace(R.id.frame_container, llf);
                   ft.commit();
               } else if (p == 1) {
                   FragmentManager fm = getFragmentManager();
                   FragmentTransaction ft = fm.beginTransaction();
                   GambarKH llf = new GambarKH();
                   ft.replace(R.id.frame_container, llf);
                   ft.commit();
               } else if (p == 2) {
                   FragmentManager fm = getFragmentManager();
                   FragmentTransaction ft = fm.beginTransaction();
                   GambarKP llf = new GambarKP();
                   ft.replace(R.id.frame_container, llf);
                   ft.commit();
               }
           }
   });
return view;
}
}

