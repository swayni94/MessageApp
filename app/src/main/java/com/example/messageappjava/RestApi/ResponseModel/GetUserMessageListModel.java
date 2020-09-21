package com.example.messageappjava.RestApi.ResponseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUserMessageListModel {
    @SerializedName("fromUserId")
    @Expose
    private String fromUserId;
    @SerializedName("toUserId")
    @Expose
    private String toUserId;
    @SerializedName("newMessageCount")
    @Expose
    private Integer newMessageCount;
    @SerializedName("messageCount")
    @Expose
    private Integer messageCount;
    @SerializedName("lastMessageDateTime")
    @Expose
    private String lastMessageDateTime;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("messageList")
    @Expose
    private List<MessageListModel> messageList = null;

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public Integer getNewMessageCount() {
        return newMessageCount;
    }

    public void setNewMessageCount(Integer newMessageCount) {
        this.newMessageCount = newMessageCount;
    }

    public Integer getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(Integer messageCount) {
        this.messageCount = messageCount;
    }

    public String getLastMessageDateTime() {
        return lastMessageDateTime;
    }

    public void setLastMessageDateTime(String lastMessageDateTime) {
        this.lastMessageDateTime = lastMessageDateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MessageListModel> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageListModel> messageList) {
        this.messageList = messageList;
    }
}
