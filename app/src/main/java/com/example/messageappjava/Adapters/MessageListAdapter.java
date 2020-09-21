package com.example.messageappjava.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.messageappjava.R;
import com.example.messageappjava.RestApi.ResponseModel.GetUserMessageListModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MessageViewHolder> {

    private ArrayList<GetUserMessageListModel> list;
    private OnClickListenerMessage listenerMessage;

    public MessageListAdapter(ArrayList<GetUserMessageListModel> l, OnClickListenerMessage listener)
    {
        this.list = l;
        this.listenerMessage = listener;
    }

    @Override
    public MessageListAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.messagelist_item, parent,false);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bind(list.get(position), listenerMessage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnClickListenerMessage{
        void onItemClick(GetUserMessageListModel data);
    }
    public class MessageViewHolder extends RecyclerView.ViewHolder{

        TextView tvitemName;
        TextView tvNewMessageCount;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);

            tvitemName= itemView.findViewById(R.id.itemName);
            tvNewMessageCount = itemView.findViewById(R.id.itemNewMessageCount);

        }

        public void bind(final GetUserMessageListModel data, MessageListAdapter.OnClickListenerMessage listenerMessage)
        {
            tvitemName.setText(data.getTitle());
            tvNewMessageCount.setText(data.getNewMessageCount());

           itemView.setOnClickListener(view -> listenerMessage.onItemClick(data));
        }
    }
}
