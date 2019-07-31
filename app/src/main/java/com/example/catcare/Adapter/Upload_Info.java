package com.example.catcare.Adapter;
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
public class Upload_Info {
    private String mImageUrl;
    private String mTitleinfo;
    private String mDescinfo;



    public Upload_Info()
    {
        //Construktor Kosong

    }
    public Upload_Info(String mPostTitle_info, String mPostDesc_info, String ImageUrl)
    {
        if (mPostTitle_info.trim().equals(""))
        {
            mPostTitle_info = "Title salah";
        }
        else if (mPostDesc_info.trim().equals(""))
        {
            mPostDesc_info = "desc tidak ada";
        }
        mTitleinfo = mPostTitle_info;
        mDescinfo = mPostDesc_info;
        this.mImageUrl = ImageUrl;

    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public void setmImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }

    public String getmTitleinfo() {
        return mTitleinfo;
    }

    public void setmTitleinfo(String mTitleinfo) {
        this.mTitleinfo = mTitleinfo;
    }

    public String getmDescinfo() {
        return mDescinfo;
    }

    public void setmDescinfo(String mDescinfo) {
        this.mDescinfo = mDescinfo;
    }
}
