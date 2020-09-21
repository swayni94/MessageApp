package com.example.messageappjava.RestApi;

import android.util.Log;

import com.example.messageappjava.Model.UserId;
import com.example.messageappjava.RestApi.ResponseModel.GetFriendListModel;
import com.example.messageappjava.RestApi.ResponseModel.GetUserDetailModel;
import com.example.messageappjava.RestApi.ResponseModel.GetUserMessageListModel;
import com.example.messageappjava.RestApi.ResponseModel.SearchUsersModel;
import com.google.gson.JsonObject;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Repository {

    private static String contentType = "application/json";

    private static Repository repository;
    private static UserId userId;

    public static Repository getInstance()
    {
        if (repository == null)
        {
            repository=new Repository();
        }
        return repository;
    }

    private IRestService service;

    public Repository(){
        service = RestService.getClient().create(IRestService.class);
    }

/////UserMessageList
    public MutableLiveData<List<GetUserMessageListModel>> getUserMessageListMutableLiveData(){
        MutableLiveData<List<GetUserMessageListModel>> data = new MutableLiveData<>();

        service.getUserMessageList(contentType, userId.getToken()).enqueue(new Callback<List<GetUserMessageListModel>>() {
            @Override
            public void onResponse(Call<List<GetUserMessageListModel>> call, Response<List<GetUserMessageListModel>> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
                else {
                    data.setValue(null);
                    Log.d("response", "response hatası");
                }
            }

            @Override
            public void onFailure(Call<List<GetUserMessageListModel>> call, Throwable t) {
                    data.setValue(null);
            }
        });
        return data;
    }

//////Send Message
    public Boolean toSendMessage(JsonObject jsonObject){
        final boolean[] data = {false};
        service.sendMessage(jsonObject, contentType , userId.getToken()).enqueue(new Callback<Boolean>() {
            @Override
            public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                if (response.isSuccessful()){
                    data[0] = response.body().booleanValue();
                }
            }

            @Override
            public void onFailure(Call<Boolean> call, Throwable t) {
                t.printStackTrace();
            }
        });
        return data[0];
    }

////Friend List
    public MutableLiveData<List<GetFriendListModel>> getFriendListMutableLiveData(){
        MutableLiveData<List<GetFriendListModel>> data = new MutableLiveData<>();

        service.getFriendList(contentType, userId.getToken()).enqueue(new Callback<List<GetFriendListModel>>() {
            @Override
            public void onResponse(Call<List<GetFriendListModel>> call, Response<List<GetFriendListModel>> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<GetFriendListModel>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

///// Add Friend
    public Boolean addNewFriend(JsonObject jsonObject){
       boolean[] data = {false};
       service.addFriend(jsonObject, contentType, userId.getToken()).enqueue(new Callback<Boolean>() {
           @Override
           public void onResponse(Call<Boolean> call, Response<Boolean> response) {
               if (response.isSuccessful()){
                   data[0] = response.body().booleanValue();
               }
           }

           @Override
           public void onFailure(Call<Boolean> call, Throwable t) {
                t.printStackTrace();
           }
       });
        return data[0];
    }

///Search User
    public MutableLiveData<List<SearchUsersModel>> searchUsersMutableLiveData(JsonObject jsonObject){
        MutableLiveData<List<SearchUsersModel>> data = new MutableLiveData<>();

        service.searchUser(jsonObject, contentType, userId.getToken()).enqueue(new Callback<List<SearchUsersModel>>() {
            @Override
            public void onResponse(Call<List<SearchUsersModel>> call, Response<List<SearchUsersModel>> response) {
                if (response.isSuccessful()){
                    data.setValue(response.body());
                }
                else {
                    Log.d("searchHata", "hata olustu!");
                    data.setValue(null);
                }
            }

            @Override
            public void onFailure(Call<List<SearchUsersModel>> call, Throwable t) {
                data.setValue(null);
                t.printStackTrace();
            }
        });
        return data;
    }
}
