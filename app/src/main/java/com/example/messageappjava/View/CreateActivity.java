package com.example.messageappjava.View;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.messageappjava.InterfaceMvp.CreateContract;
import com.example.messageappjava.Presenter.CreatePresenter;
import com.example.messageappjava.R;
import com.google.gson.JsonObject;

import androidx.appcompat.app.AppCompatActivity;


public class CreateActivity extends AppCompatActivity implements CreateContract.PresenterToView, View.OnClickListener {


    private Button createbttn;
    private Button loginbttn;

    private EditText firstName;
    private EditText lastName;
    private EditText username;
    private EditText password;
    private EditText email;
    private CreateContract.ToPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        createbttn = findViewById(R.id.create_createbtn);
        createbttn.setOnClickListener(this);
        loginbttn = findViewById(R.id.create_login);
        loginbttn.setOnClickListener(this);

        firstName = findViewById(R.id.create_firstName);
        lastName = findViewById(R.id.create_lastName);
        username = findViewById(R.id.create_username);
        password = findViewById(R.id.create_password);
        email = findViewById(R.id.create_email);


        presenter = new CreatePresenter(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.create_createbtn: {

                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("firstName", firstName.getText().toString());
                jsonObject.addProperty("lastName", lastName.getText().toString());
                jsonObject.addProperty("username", username.getText().toString());
                jsonObject.addProperty("password", password.getText().toString());
                jsonObject.addProperty("email", email.getText().toString());


                if (jsonObject.get("firstName")!=null && jsonObject.get("lastName")!=null && jsonObject.get("username")!=null
                       && jsonObject.get("password")!=null && jsonObject.get("email")!=null) {
                    try {
                        presenter.register(jsonObject);
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }

                }

                break;
            }

            case R.id.create_login:{
                startActivity(new Intent(CreateActivity.this, LoginActivity.class));
                break;
            }
        }
    }

    @Override
    public void OnCreateResponse(boolean createResponse) {
        startActivity(new Intent(CreateActivity.this, LoginActivity.class));
    }

    @SuppressLint("ShowToast")
    @Override
    public void onError(String msg) {
         Toast.makeText(this, msg, Toast.LENGTH_LONG);
    }

    @Override
    public void hideProgressBar() {
       // progressBar.setVisibility(View.GONE);
       // createbttn.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgressBar() {
      //  progressBar.setVisibility(View.VISIBLE);
      //  createbttn.setVisibility(View.GONE);
    }


}
