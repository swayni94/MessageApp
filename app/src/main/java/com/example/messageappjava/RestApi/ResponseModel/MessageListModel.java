package com.example.messageappjava.RestApi.ResponseModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageListModel {
    @SerializedName("fromUserId")
    @Expose
    private String fromUserId;
    @SerializedName("toUserId")
    @Expose
    private String toUserId;
    @SerializedName("messageTitle")
    @Expose
    private Object messageTitle;
    @SerializedName("messageBody")
    @Expose
    private String messageBody;
    @SerializedName("isRead")
    @Expose
    private Boolean isRead;
    @SerializedName("parentMessageId")
    @Expose
    private Object parentMessageId;
    @SerializedName("messageDateTime")
    @Expose
    private String messageDateTime;
    @SerializedName("id")
    @Expose
    private String id;

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

    public Object getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(Object messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    public Boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(Boolean isRead) {
        this.isRead = isRead;
    }

    public Object getParentMessageId() {
        return parentMessageId;
    }

    public void setParentMessageId(Object parentMessageId) {
        this.parentMessageId = parentMessageId;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
