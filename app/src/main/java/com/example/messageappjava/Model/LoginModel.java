package com.example.messageappjava.Model;

import android.util.Log;

import com.example.messageappjava.InterfaceMvp.LoginContract;

import com.example.messageappjava.RestApi.IRestService;
import com.example.messageappjava.RestApi.ResponseModel.LoginPageModel;
import com.example.messageappjava.RestApi.RestService;
import com.google.gson.JsonObject;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginModel implements LoginContract.PresenterToModel {

    private LoginContract.ToPresenter presenter;
    private UserId user;

    public LoginModel(LoginContract.ToPresenter presenter1) {
        this.presenter = presenter1;
    }

    @Override
    public void login(JsonObject jsonObject) {
        if (jsonObject != null) {
            LoginOperation(jsonObject);

        } else {
            presenter.onError("deneme");
        }
    }


    private void LoginOperation(JsonObject loginJson) {
        String contentType = "application/json";

        IRestService service = RestService.getClient().create(IRestService.class);

        Call<LoginPageModel> call = service.login(loginJson, contentType);
        call.enqueue(new Callback<LoginPageModel>() {
            @Override
            public void onResponse(Call<LoginPageModel> call, Response<LoginPageModel> response) {
                if (response.isSuccessful())
                {
                    user = new UserId();
                    user.setId(response.body().getId());
                    user.setToken(response.body().getToken());
                    user.setServerPublikKey(response.body().getServerPublicKey());
                    presenter.onLoginResponse(true);
                }
                else {
                    Log.d("olumlu", "olumsuz");
                }
            }

            @Override
            public void onFailure(Call<LoginPageModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}