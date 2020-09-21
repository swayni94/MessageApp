package com.example.messageappjava.Fragment;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.messageappjava.Adapters.MessageListAdapter;
import com.example.messageappjava.R;
import com.example.messageappjava.RestApi.ResponseModel.GetUserMessageListModel;
import com.example.messageappjava.RestApi.ResponseModel.MessageListModel;
import com.example.messageappjava.View.UserChatPage;

import java.util.ArrayList;
import java.util.List;

public class MessageListFragment extends Fragment{

    private RecyclerView messageListRecyclerView;
    private MessageListAdapter messageListAdapter;

    private MessageListViewModel mViewModel;

    private ArrayList<GetUserMessageListModel> messageListModels;
    private List<MessageListModel> chatMessageListModel;

    public static MessageListFragment newInstance() {
        return new MessageListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.message_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MessageListViewModel.class);
        mViewModel.init();
        mViewModel.getNewMessageList().observe(this, getUserMessageListModels ->{
            messageListModels.addAll(getUserMessageListModels);
            messageListAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
    }


    private void setupRecyclerView(){

        if (messageListAdapter == null)
        {
            messageListAdapter = new MessageListAdapter(messageListModels, data -> {
                chatMessageListModel = data.getMessageList();
                startActivity(new Intent(getContext(), UserChatPage.class));

            });
            messageListRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            messageListRecyclerView.setAdapter(messageListAdapter);
            messageListRecyclerView.setItemAnimator(new DefaultItemAnimator());
            messageListRecyclerView.setNestedScrollingEnabled(true);
        }
        else {messageListAdapter.notifyDataSetChanged();}
    }

}
