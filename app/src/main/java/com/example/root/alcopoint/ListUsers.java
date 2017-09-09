package com.example.root.alcopoint;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ListUsers extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference myRef;

    FirebaseUser user = mAuth.getInstance().getCurrentUser();

    FirebaseListAdapter mAdapter;

    private EditText ET_new_info;
    private Button Btn_new_info;

    ListView listUsersInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        listUsersInfo = (ListView) findViewById(R.id.discr_for_info);
        //
        myRef = FirebaseDatabase.getInstance().getReference();

        mAdapter = new FirebaseListAdapter<String>(this, String.class, android.R.layout.simple_list_item_1, myRef.child(user.getUid()).child("Tasks")) {
            @Override
            protected void populateView(View v, String s, int position) {

                TextView text = (TextView) v.findViewById(android.R.id.text1);
                text.setText(s);
            }
        };

        listUsersInfo.setAdapter(mAdapter);

        Btn_new_info = (Button) findViewById(R.id.btn_add);
        ET_new_info = (EditText) findViewById(R.id.et_new_info);

        Btn_new_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.child(user.getUid()).child("Tasks").push().setValue(ET_new_info.getText().toString());
            }
        });


    }

}
