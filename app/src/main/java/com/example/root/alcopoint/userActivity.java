package com.example.root.alcopoint;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.root.alcopoint.R.drawable.f;

public class userActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        ImageView IVuserIMG = (ImageView) findViewById(R.id.user_image);


    }

    @Override
    public void onClick(View view) {

    }
}
