package com.example.messageappjava.RestApi;

import com.example.messageappjava.RestApi.ResponseModel.GetFriendListModel;
import com.example.messageappjava.RestApi.ResponseModel.GetUserDetailModel;
import com.example.messageappjava.RestApi.ResponseModel.GetUserMessageListModel;
import com.example.messageappjava.RestApi.ResponseModel.LoginPageModel;
import com.example.messageappjava.RestApi.ResponseModel.RegisterResponseModel;
import com.example.messageappjava.RestApi.ResponseModel.SearchUsersModel;
import com.google.gson.JsonObject;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;


public interface IRestService {
    @POST("api/User/Register")
    Call<RegisterResponseModel> register(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType
    );

    @POST("api/User/Login")
    Call<LoginPageModel> login(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType
    );

    @POST("/api/User/GetUserDetail")
    Call<GetUserDetailModel> getUserDetail(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    //FRİEND

    @POST("/api/Friend/AddFriend")
    Call<Boolean> addFriend(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Friend/GetFriendList")
    Call<List<GetFriendListModel>> getFriendList(
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );
    /*
        @POST("/api/Friend/GetBlockFriendList")
        Call<GetBlockFriendListModel> getBlockFriendList(
                @Header("Content-Type") String contentType,
                @Header("Authorization") String authorization
        );
    */
    @POST("/api/Friend/BlockFriend")
    Call<Boolean> blockFriend(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Friend/ActiveFriend")
    Call<Boolean> activeFriend(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Friend/DeleteFriend")
    Call<Boolean> deleteFriend(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Friend/SearchUser")
    Call<List<SearchUsersModel>> searchUser(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    //MESSAGE

    @POST("/api/Message/ReadMessage")
    Call<Boolean> readMessage(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Message/DeleteMessage")
    Call<Boolean> deleteMessage(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Message/SendMessage")
    Call<Boolean> sendMessage(
            @Body JsonObject jsonObject,
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );

    @POST("/api/Message/GetUserMessageList")
    Call<List<GetUserMessageListModel>> getUserMessageList(
            @Header("Content-Type") String contentType,
            @Header("Authorization") String authorization
    );
}
