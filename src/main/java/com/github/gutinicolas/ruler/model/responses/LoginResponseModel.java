package com.github.gutinicolas.ruler.model.requests;

import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;

import java.util.List;

public class LoginRequestModel {
    private String username;
    private String email;
    private String password;
    private List<GraphMapEntry> data;

    public LoginRequestModel(String username, String email, String password, List<GraphMapEntry> data) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.data = data;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GraphMapEntry> getData() {
        return data;
    }

    public void setData(List<GraphMapEntry> data) {
        this.data = data;
    }
}
