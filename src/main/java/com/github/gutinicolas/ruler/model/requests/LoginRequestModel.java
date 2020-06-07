package com.github.gutinicolas.ruler.model.requests;

import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;

import java.util.List;

public class LoginRequestModel {
    private String username;
    private String email;
    private String password;
    private List<GraphMapEntry> data;
}
