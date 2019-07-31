package com.example.catcare.Activity.Fun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.catcare.Adapter.Upload_Info;
import com.example.catcare.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
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
public class AddArtikelA extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    private ImageButton mSelectImage_info;
    private EditText mPostTitle_info;
    private EditText mPostDesc_info;
    private Button mSubmitBtn_info;
    private StorageReference mStorageRef_info;
    private DatabaseReference mDatabaseref_info;
    private ProgressBar mProgressBar_info;
    private StorageTask mUploadTask_info;
    private Uri mImageUri = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_artikel);
        mSelectImage_info = findViewById(R.id.imageSelect_info);
        mPostTitle_info = findViewById(R.id.titleField_info);
        mPostDesc_info = findViewById(R.id.descField_info);
        mProgressBar_info = findViewById(R.id.progressBar_info);
        mSubmitBtn_info = findViewById(R.id.submitButton_info);

        mStorageRef_info = FirebaseStorage.getInstance().getReference("ArtikelA");
        mDatabaseref_info = FirebaseDatabase.getInstance().getReference("ArtikelA");

        mSelectImage_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openfilechooser();
            }
        });

        mSubmitBtn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUploadTask_info != null && mUploadTask_info.isInProgress()) {
                    Toast.makeText(AddArtikelA.this, "sedang upload", Toast.LENGTH_SHORT).show();
                } else {
                    uploadfile();
                }
            }
        });
    }

    private void uploadfile() {
        if (mImageUri != null) {
            final StorageReference fileReferences = mStorageRef_info.child(System.currentTimeMillis()
                    + "." + getFileExtension(mImageUri));
            mUploadTask_info = fileReferences.putFile(mImageUri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                            Task<Uri> urlTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!urlTask.isSuccessful());
                            Uri downloadurl = urlTask.getResult();

                            Handler handler = new Handler();
                            handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    mProgressBar_info.setProgress(0);
                                }
                            }, 500);
                            Toast.makeText(AddArtikelA.this, "Upload berhasil", Toast.LENGTH_LONG).show();
                            Upload_Info upload = new Upload_Info(mPostTitle_info.getText().toString(),
                                    mPostDesc_info.getText().toString(), downloadurl.toString());
                            String uploadid = mDatabaseref_info.push().getKey();
                            mDatabaseref_info.child(uploadid).setValue(upload);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(AddArtikelA.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0 * taskSnapshot.getBytesTransferred() / taskSnapshot.getTotalByteCount());
                            mProgressBar_info.setProgress((int) progress);
                        }
                    });

        }
        else {
            Toast.makeText(AddArtikelA.this, "File tidak di temukan", Toast.LENGTH_SHORT).show();

        }

    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR2 = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR2.getType(uri));
    }

    private void openfilechooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {
            mImageUri = data.getData();
            Picasso.with(this).load(mImageUri).fit().into(mSelectImage_info);
        }
    }
}
