package com.example.catcare.Fragment.Gambar;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.catcare.Adapter.RecyclerAdapter;
import com.example.catcare.Fragment.Menu.Gambar;
import com.example.catcare.Model.DataModels;
import com.example.catcare.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
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
/**
 * A simple {@link Fragment} subclass.
 */
public class GambarKO extends Fragment {
    //Deklarasi Variable
    private Button back;
    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private FirebaseRecyclerAdapter<DataModels, RecyclerAdapter> recyclerAdapter;
    private FirebaseRecyclerOptions<DataModels> options;
    private ProgressBar progressBar;
    private DatabaseReference mDatabaseRef;

    public GambarKO() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gambarko, container, false);
        getActivity().setTitle("Kucing Orange");
        back = (Button) view.findViewById(R.id.button);
        recyclerView = view.findViewById(R.id.recyclerView);
        progressBar = view.findViewById(R.id.progressBar);
        //Digunakan untuk mengatur dan memposisikan item didalam RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        //Digunakan agar ukuran RecyclerView tidak berubah saat menambahkan item atau menghapusnya
        recyclerView.setHasFixedSize(true);

        //Mendapatkan referensi dari Database
        reference = FirebaseDatabase.getInstance().getReference();

        firebaseReyclerViewAdapter();
        return view;
    }

    private void firebaseReyclerViewAdapter() {
        // Mengatur setelah opsi untuk FirebaseRecyclerAdapter
        options = new FirebaseRecyclerOptions.Builder<DataModels>()
                // Referensi Database yang akan digunakan beserta data Modelnya
                .setQuery(reference.child("KucingOren"), DataModels.class)
                .setLifecycleOwner((LifecycleOwner) getActivity()) //Untuk menangani perubahan siklus hidup pada Activity/Fragment
                .build();

        // Digunakan untuk menghubungkan View dengan data Models
        recyclerAdapter = new FirebaseRecyclerAdapter<DataModels, RecyclerAdapter>(options) {

            @Override
            protected void onBindViewHolder(@NonNull RecyclerAdapter holder, int position, @NonNull DataModels model) {
                //Mendapatkan data dari Database yang akan ditampilkan pada RecyclerView
                holder.setDisplayImage(model.getImage_url(), getActivity());

                progressBar.setVisibility(View.GONE);
            }

            @NonNull
            @Override
            public RecyclerAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                //Mengubungkan adapter dengan Layout yang akan digunakan
                return new RecyclerAdapter(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.recycler_layout, parent, false));
            }
        };
        recyclerView.setAdapter(recyclerAdapter);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Gambar root = new Gambar();

                getFragmentManager().beginTransaction().replace(R.id.frame_container, root)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
            }
        });
    }

}