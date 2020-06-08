package com.github.gutinicolas.ruler.model.responses;

import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;

import javax.mail.Session;
import java.util.List;
import java.util.Map;

public class LoginResponseModel {
    private boolean ok;
    private String reason;
    private Map<String, Object> data;
    private Session session;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public LoginResponseModel(boolean ok, String reason, Map<String, Object> data, Session session) {
        this.ok = ok;
        this.reason = reason;
        this.data = data;
        this.session = session;
    }
}
