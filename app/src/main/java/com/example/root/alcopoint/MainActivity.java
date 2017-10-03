package com.example.root.alcopoint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import static com.example.root.alcopoint.Details.createTempImageFile;

public class MainActivity extends AppCompatActivity {


    private ImageView mIVpicture;

    private String mRereference = "";

    private StorageReference mStorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIVpicture = (ImageView) findViewById(R.id.iv_picture);

        File localFile = null;

        mRereference = getIntent().getStringExtra("Reference");
        mStorageRef = FirebaseStorage.getInstance().getReference();

        try {
            localFile = createTempImageFile(getExternalCacheDir());
            final File finalLocalFile = localFile;

            mStorageRef.child("images/" + mRereference).getFile(localFile)
                    .addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                            Picasso.with(getBaseContext())
                                    .load(Uri.fromFile(finalLocalFile))
                                    .into(mIVpicture);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.i("Load", "" + e);
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void toChat(View view) {
        Intent intent = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    public void toProfile(View view) {
        Intent intent = new Intent(MainActivity.this, Details.class);
        startActivity(intent);
    }

    public void toSettings(View view) {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    public void toUserProfile(View view) {
        Intent intent = new Intent(MainActivity.this, userActivity.class);
        startActivity(intent);
    }


    public void changePlus(View view) {
        int[] userImageList = new int[]{R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.user5, R.drawable.user6, R.drawable.user7, R.drawable.user8, R.drawable.user9, R.drawable.user10, R.drawable.user11, R.drawable.user12, R.drawable.user14, R.drawable.user15, R.drawable.user16};
        Random random = new Random();
        Integer rand = random.nextInt(userImageList.length - 1);
        Integer rand1 = random.nextInt(userImageList.length - 1);
        Integer rand2 = random.nextInt(userImageList.length - 1);
        Integer rand3 = random.nextInt(userImageList.length - 1);
        Integer rand4 = random.nextInt(userImageList.length - 1);
        Integer rand5 = random.nextInt(userImageList.length - 1);
        Integer rand6 = random.nextInt(userImageList.length - 1);
        Integer rand7 = random.nextInt(userImageList.length - 1);
        ImageView img1 = (ImageView) findViewById(R.id.section1);
        ImageView img2 = (ImageView) findViewById(R.id.section2);
        ImageView img3 = (ImageView) findViewById(R.id.section3);
        ImageView img4 = (ImageView) findViewById(R.id.section4);
        ImageView img5 = (ImageView) findViewById(R.id.section5);
        ImageView img6 = (ImageView) findViewById(R.id.section6);
        ImageView img7 = (ImageView) findViewById(R.id.section7);
        ImageView img8 = (ImageView) findViewById(R.id.section8);
        img1.setImageResource(userImageList[rand]);
        img2.setImageResource(userImageList[rand1]);
        img3.setImageResource(userImageList[rand2]);
        img4.setImageResource(userImageList[rand3]);
        img5.setImageResource(userImageList[rand4]);
        img6.setImageResource(userImageList[rand5]);
        img7.setImageResource(userImageList[rand6]);
        img8.setImageResource(userImageList[rand7]);


    }

    public void changeMinus(View view) {
        int[] userImageList = new int[]{R.drawable.user1, R.drawable.user2, R.drawable.user3, R.drawable.user4, R.drawable.user5, R.drawable.user6, R.drawable.user7, R.drawable.user8, R.drawable.user9, R.drawable.user10, R.drawable.user11, R.drawable.user12, R.drawable.user14, R.drawable.user15, R.drawable.user16};
        Random random = new Random();
        Integer rand1 = random.nextInt(userImageList.length);
        Integer rand2 = random.nextInt(userImageList.length);
        Integer rand3 = random.nextInt(userImageList.length);
        Integer rand4 = random.nextInt(userImageList.length);
        Integer rand5 = random.nextInt(userImageList.length);
        Integer rand6 = random.nextInt(userImageList.length);
        Integer rand7 = random.nextInt(userImageList.length);
        ImageView img1 = (ImageView) findViewById(R.id.section1);
        ImageView img2 = (ImageView) findViewById(R.id.section2);
        ImageView img3 = (ImageView) findViewById(R.id.section3);
        ImageView img4 = (ImageView) findViewById(R.id.section4);
        ImageView img5 = (ImageView) findViewById(R.id.section5);
        ImageView img6 = (ImageView) findViewById(R.id.section6);
        ImageView img7 = (ImageView) findViewById(R.id.section7);
        ImageView img8 = (ImageView) findViewById(R.id.section8);
        img1.setImageResource(userImageList[rand1]);
        img2.setImageResource(userImageList[rand2]);
        img3.setImageResource(userImageList[rand3]);
        img4.setImageResource(userImageList[rand4]);
        img5.setImageResource(userImageList[rand5]);
        img6.setImageResource(userImageList[rand6]);
        img7.setImageResource(userImageList[rand7]);
        img8.setImageResource(userImageList[rand1]);

    }


}

