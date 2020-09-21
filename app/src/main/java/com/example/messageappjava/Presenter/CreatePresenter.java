package com.example.messageappjava.Presenter;

import com.example.messageappjava.InterfaceMvp.CreateContract;
import com.example.messageappjava.Model.CreateModel;
import com.google.gson.JsonObject;

public class CreatePresenter implements CreateContract.ToPresenter {

    private CreateContract.PresenterToModel presenterToModel;
    private CreateContract.PresenterToView presenterToView;


    public CreatePresenter(CreateContract.PresenterToView view)
    {
        this.presenterToView = view;
        presenterToModel = new CreateModel(this);
    }

    @Override
    public void register(JsonObject jsonObject) {
    presenterToModel.register(jsonObject);
    }

    @Override
    public void onCreateResponse(boolean createResponse) {
        presenterToView.OnCreateResponse(createResponse);
    }

    @Override
    public void onError(String msg) {
        presenterToView.onError(msg);
    }

}
