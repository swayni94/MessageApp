package com.example.messageappjava.InterfaceMvp;

import com.google.gson.JsonObject;

public class CreateContract {

    public interface PresenterToModel{
        void register(JsonObject jsonObject);
    }
    public interface PresenterToView{
        void OnCreateResponse(boolean createResponse);

        void onError(String msg);

        void hideProgressBar();
        void showProgressBar();
    }
    public interface ToPresenter{
        void register(JsonObject jsonObject);
        void onCreateResponse(boolean createResponse);
        void onError(String msg);
    }
}
