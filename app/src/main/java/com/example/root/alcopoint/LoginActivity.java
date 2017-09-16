package com.example.root.alcopoint;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    private CallbackManager callbackManager;
    private AccessToken accessToken;
    private LoginButton loginButton;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText ETemail;
    private EditText ETpassword;

    private Button Login;
    private Button Regisration;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_login);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        initializeFacebookLogin();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    // User is signed in

                } else {
                    // User is signed out

                }

            }
        };


        ETemail = (EditText) findViewById(R.id.et_email);
        ETpassword = (EditText) findViewById(R.id.et_password);

        Login = (Button) findViewById(R.id.btn_sign_in);
        Regisration = (Button) findViewById(R.id.btn_registration);
        findViewById(R.id.btn_sign_in).setOnClickListener(this);
        findViewById(R.id.btn_registration).setOnClickListener(this);


        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        Login.setEnabled(false);
        Regisration.setEnabled(false);

        Observable<String> emailObservable = RxEditText.getTextWatcherObservable(ETemail);
        Observable<String> passwordObservable = RxEditText.getTextWatcherObservable(ETpassword);

        Observable.combineLatest(emailObservable, passwordObservable, new Func2<String, String, Boolean>() {

            @Override
            public Boolean call(String s, String s2) {
                if (s.isEmpty() || s2.isEmpty())
                    return false;
                else
                    return true;
            }
        }).subscribe(new Action1<Boolean>() {
            @Override
            public void call(Boolean aBoolean) {
                Login.setEnabled(aBoolean);
                Regisration.setEnabled(aBoolean);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getInstance().getCurrentUser();
        if (user != null) {
            for (UserInfo profile : user.getProviderData()) {
                // Id of the provider (ex: google.com)
                String providerId = profile.getProviderId();

                // UID specific to the provider
                String uid = profile.getUid();

                // Name, email address, and profile photo Url
                String name = profile.getDisplayName();
                String email = profile.getEmail();
                Uri photoUrl = profile.getPhotoUrl();


            }


        }


    }


    private void initializeFacebookLogin() {
        callbackManager = CallbackManager.Factory.create();
        loginButton.setReadPermissions("email", "public_profile", "user_friends");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                accessToken = loginResult.getAccessToken();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_sign_in) {
            signin(ETemail.getText().toString(), ETpassword.getText().toString());
        } else if (view.getId() == R.id.btn_registration) {
            registration(ETemail.getText().toString(), ETpassword.getText().toString());
        }

    }

    public void signin(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Aвторизация успешна", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginActivity.this, "Aвторизация провалена", Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void registration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                } else
                    Toast.makeText(LoginActivity.this, "Регистрация провалена", Toast.LENGTH_SHORT).show();
            }
        });
    }


}