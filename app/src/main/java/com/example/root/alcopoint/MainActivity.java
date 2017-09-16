package com.example.root.alcopoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Random;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    public void toChat(View view)
    {
        Intent intent = new Intent(MainActivity.this, ChatActivity.class);
        startActivity(intent);
    }

    public void toProfile(View view)
    {
        Intent intent = new Intent(MainActivity.this, Details.class);
        startActivity(intent);
    }

    public void toSettings(View view)
    {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }








    public void changePlus(View view){
        int [] userImageList = new int[]{R.drawable.e, R.drawable.i, R.drawable.q, R.drawable.r, R.drawable.t, R.drawable.u,R.drawable.w, R.drawable.y};
        Random random = new Random();
        Integer rand = random.nextInt(userImageList.length - 1);
        ImageView img1 = (ImageView) findViewById(R.id.section1);
        ImageView img2 = (ImageView) findViewById(R.id.section2);
        ImageView img3 = (ImageView) findViewById(R.id.section3);
        ImageView img4 = (ImageView) findViewById(R.id.section4);
        ImageView img5 = (ImageView) findViewById(R.id.section5);
        ImageView img6 = (ImageView) findViewById(R.id.section6);
        ImageView img7 = (ImageView) findViewById(R.id.section7);
        ImageView img8 = (ImageView) findViewById(R.id.section8);
        img1.setImageResource(userImageList[rand]);
        img2.setImageResource(userImageList[rand]);
        img3.setImageResource(userImageList[rand]);
        img4.setImageResource(userImageList[rand]);
        img5.setImageResource(userImageList[rand]);
        img6.setImageResource(userImageList[rand]);
        img7.setImageResource(userImageList[rand]);
        img8.setImageResource(userImageList[rand]);

    }

    public void changeMinus(View view){
        int [] userImageList = new int[]{R.drawable.e, R.drawable.i, R.drawable.q, R.drawable.r, R.drawable.t, R.drawable.u,R.drawable.w, R.drawable.y};
        Random random = new Random();
        Integer rand = random.nextInt(userImageList.length - 1);
        ImageView img1 = (ImageView) findViewById(R.id.section1);
        ImageView img2 = (ImageView) findViewById(R.id.section2);
        ImageView img3 = (ImageView) findViewById(R.id.section3);
        ImageView img4 = (ImageView) findViewById(R.id.section4);
        ImageView img5 = (ImageView) findViewById(R.id.section5);
        ImageView img6 = (ImageView) findViewById(R.id.section6);
        ImageView img7 = (ImageView) findViewById(R.id.section7);
        ImageView img8 = (ImageView) findViewById(R.id.section8);
        img1.setImageResource(userImageList[rand]);
        img2.setImageResource(userImageList[rand]);
        img3.setImageResource(userImageList[rand]);
        img4.setImageResource(userImageList[rand]);
        img5.setImageResource(userImageList[rand]);
        img6.setImageResource(userImageList[rand]);
        img7.setImageResource(userImageList[rand]);
        img8.setImageResource(userImageList[rand]);

    }


    }

