package com.example.messageappjava.InterfaceMvp;

import com.google.gson.JsonObject;

public class LoginContract {

    public interface PresenterToModel {
        void login(JsonObject jsonObject);
    }
    public interface PresenterToView {
        void onLoginResponse(boolean loginResponse);

        void onError(String msg);
    }

    public interface ToPresenter {
        void login(JsonObject jsonObject);
        void onLoginResponse(boolean loginResponse);
        void onError(String msg);
    }
}
