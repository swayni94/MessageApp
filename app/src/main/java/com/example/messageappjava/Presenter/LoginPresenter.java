package com.example.messageappjava.Presenter;

import com.example.messageappjava.InterfaceMvp.LoginContract;
import com.example.messageappjava.Model.LoginModel;
import com.google.gson.JsonObject;

public class LoginPresenter implements LoginContract.ToPresenter {

    private LoginContract.PresenterToView view;
    private LoginContract.PresenterToModel model;

    public LoginPresenter(LoginContract.PresenterToView view)
    {
        this.view = view;
        this.model = new LoginModel(this);
    }
    @Override
    public void login(JsonObject jsonObject) {
        model.login(jsonObject);
    }

    @Override
    public void onLoginResponse(boolean loginResponse) {
        view.onLoginResponse(loginResponse);
    }

    @Override
    public void onError(String msg) {
        view.onError(msg);
    }
}
