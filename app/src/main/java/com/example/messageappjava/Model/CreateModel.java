package com.example.messageappjava.Model;

import android.util.Log;

import com.example.messageappjava.InterfaceMvp.CreateContract;
import com.example.messageappjava.RestApi.IRestService;
import com.example.messageappjava.RestApi.ResponseModel.RegisterResponseModel;
import com.example.messageappjava.RestApi.RestService;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CreateModel implements CreateContract.PresenterToModel {

    private CreateContract.ToPresenter presenter;

    public CreateModel (CreateContract.ToPresenter presenter1){
        this.presenter = presenter1;
    }

    @Override
    public void register(JsonObject jsonObject) {
        if (jsonObject != null)
        {
            createtouser(jsonObject);
        }
        else {
            presenter.onError("kayıt olusmadı!");
        }
    }


    private void createtouser(JsonObject jsonObject){
        String contentType = "application/json";

        IRestService service = RestService.getClient().create(IRestService.class);
        service.register(jsonObject, contentType).enqueue(new Callback<RegisterResponseModel>() {
            @Override
            public void onResponse(Call<RegisterResponseModel> call, Response<RegisterResponseModel> response) {
                if (response.isSuccessful()){
                        presenter.onCreateResponse(response.body().getStatus());
                }
                else {
                    Log.d("olumlu", "olumsuz");
                    presenter.onCreateResponse(false);
                }
            }

            @Override
            public void onFailure(Call<RegisterResponseModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
