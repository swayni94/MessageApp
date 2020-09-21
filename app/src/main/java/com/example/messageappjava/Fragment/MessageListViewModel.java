package com.example.messageappjava.Fragment;

import com.example.messageappjava.RestApi.Repository;
import com.example.messageappjava.RestApi.ResponseModel.GetUserMessageListModel;
import com.example.messageappjava.RestApi.ResponseModel.MessageListModel;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MessageListViewModel extends ViewModel {

    private MutableLiveData<List<GetUserMessageListModel>> getUserMessageListModelMutableLiveData;
    //private MutableLiveData<MessageListModel> messageListModelMutableLiveData;
    private Repository repository;

    public void init(){
        if (getUserMessageListModelMutableLiveData != null){
            return;
        }
        repository = Repository.getInstance();
        getUserMessageListModelMutableLiveData = repository.getUserMessageListMutableLiveData();
    }

    public LiveData<List<GetUserMessageListModel>> getNewMessageList(){
        return getUserMessageListModelMutableLiveData;
    }
}
