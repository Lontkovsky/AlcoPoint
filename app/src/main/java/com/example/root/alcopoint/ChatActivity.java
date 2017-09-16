package com.example.root.alcopoint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }


    public void toMain(View view)
    {
        Intent intent = new Intent(ChatActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void toProfile(View view)
    {
        Intent intent = new Intent(ChatActivity.this, Details.class);
        startActivity(intent);
    }

    public void toSettings(View view)
    {
        Intent intent = new Intent(ChatActivity.this, SettingsActivity.class);
        startActivity(intent);
    }
}
