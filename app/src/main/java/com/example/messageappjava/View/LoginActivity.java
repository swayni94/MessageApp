package com.example.messageappjava.View;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.messageappjava.InterfaceMvp.LoginContract;
import com.example.messageappjava.Presenter.LoginPresenter;
import com.example.messageappjava.R;
import com.google.gson.JsonObject;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.PresenterToView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private Button login;
    private Button create;
    private LoginContract.ToPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = findViewById(R.id.lytprogressBar);
        username = findViewById(R.id.lytusername);
        password = findViewById(R.id.lytpassword);
        login = findViewById(R.id.lytlogin);
        login.setOnClickListener(this);
        create= findViewById(R.id.lytcreate);
        create.setOnClickListener(this);


        presenter = new LoginPresenter(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lytlogin: {
                progressBar.setVisibility(View.VISIBLE);
                login.setVisibility(View.GONE);


                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("userName", username.getText().toString());
                jsonObject.addProperty("password", password.getText().toString());
                jsonObject.addProperty("isRemainMe", true);
                /////////////////////clientpublickey gir
                jsonObject.addProperty("clientPublicKey", "deneme");

                presenter.login(jsonObject);

                login.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.GONE);

                break;
            }
            case R.id.lytcreate: {
                startActivity(new Intent(LoginActivity.this, CreateActivity.class));
                break;
            }

        }
    }

    @Override
    public void onLoginResponse(boolean loginResponse) {
        if (loginResponse)
        {
            startActivity(new Intent(LoginActivity.this, CreateActivity.class));
        }
    }

    @SuppressLint("ShowToast")
    @Override
    public void onError(String msg) {
        Toast.makeText(getApplicationContext(), "Giriş hatalı kontrol ediniz!" , Toast.LENGTH_SHORT);
    }
}
