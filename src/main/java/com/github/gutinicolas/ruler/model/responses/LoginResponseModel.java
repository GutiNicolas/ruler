package com.github.gutinicolas.ruler.model.responses;

import com.github.gutinicolas.ruler.model.graphQLUtilsModel.GraphMapEntry;

import javax.mail.Session;
import java.util.List;

public class LoginResponseModel {
    private boolean ok;
    private String reason;
    private List<GraphMapEntry> data;
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

    public List<GraphMapEntry> getData() {
        return data;
    }

    public void setData(List<GraphMapEntry> data) {
        this.data = data;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public LoginResponseModel(boolean ok, String reason, List<GraphMapEntry> data, Session session) {
        this.ok = ok;
        this.reason = reason;
        this.data = data;
        this.session = session;
    }
}
