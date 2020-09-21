package com.example.messageappjava.Model;

public class UserId {
    private String id;
    private String token;
    private String serverPublikKey;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServerPublikKey() {
        return serverPublikKey;
    }

    public String getToken() {
        return token;
    }

    public void setServerPublikKey(String serverPublikKey) {
        this.serverPublikKey = serverPublikKey;
    }

    public void setToken(String token) {
        this.token =("Bearer " + token);
    }
}
