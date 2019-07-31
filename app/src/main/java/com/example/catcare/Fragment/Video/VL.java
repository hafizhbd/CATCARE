package com.example.catcare.Fragment.Video;


import android.os.Bundle;

import android.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catcare.Adapter.VideoAdapter;
import com.example.catcare.Model.YouTubeVideos;
import com.example.catcare.R;

import java.util.ArrayList;
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
/**
 * A simple {@link Fragment} subclass.
 */
public class VL extends Fragment {


    public VL() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vl, container, false);
        getActivity().setTitle("VIDEO FUNNY");
        final List<YouTubeVideos> youtubeVideos = new ArrayList<>();
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/WEkSYw3o5is\"" +
                " frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/pOmu0LtcI6Y\"" +
                " frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/97nyYTBPJi4\"" +
                " frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/5dsGWM5XGdg\"" +
                " frameborder=\"0\" allowfullscreen></iframe>"));
        youtubeVideos.add(new YouTubeVideos("<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/1Wh8RzcQZr4\"" +
                " frameborder=\"0\" allowfullscreen></iframe>"));
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final VideoAdapter videoAdapter = new VideoAdapter(youtubeVideos);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.smoothScrollToPosition(recyclerView.getBottom());
        recyclerView.setAdapter(videoAdapter);
        return view;
    }
}
